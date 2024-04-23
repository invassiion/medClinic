package com.example.medClinic.user.controller;


import com.example.medClinic.user.dto.request.EditClientRequest;
import com.example.medClinic.user.dto.request.RegistrationClientRequest;
import com.example.medClinic.user.dto.response.ClientResponse;
import com.example.medClinic.user.entity.ClientEntity;
import com.example.medClinic.user.exceptions.BadRequestException;
import com.example.medClinic.user.exceptions.UserAlreadyExistException;
import com.example.medClinic.user.exceptions.UserNotFoundException;
import com.example.medClinic.user.repository.ClientRepository;
import com.example.medClinic.user.routes.ClientRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ClientApiController {

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    @PostMapping(ClientRoutes.REGISTRATION)
    public ClientResponse registration(@RequestBody RegistrationClientRequest request) throws BadRequestException, UserAlreadyExistException {
        request.validate();

        Optional<ClientEntity> check = clientRepository.findByEmail(request.getEmail());
        if (check.isPresent()) throw  new UserAlreadyExistException();

        ClientEntity client = ClientEntity.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        client = clientRepository.save(client);
        return ClientResponse.of(client);
    }

    @GetMapping(ClientRoutes.ME)
    public ClientResponse me(Principal principal) throws  UserNotFoundException {
        return clientRepository.findByEmail(principal.getName()).map(ClientResponse::of).orElseThrow(UserNotFoundException::new);
    }

    @PostMapping(ClientRoutes.ME)
    public ClientResponse edit(Principal principal, @RequestBody EditClientRequest request) throws UserNotFoundException {
        ClientEntity client = clientRepository
                .findByEmail(principal.getName())
                .orElseThrow(UserNotFoundException::new);

        client.setFirstname(request.getFirstName());
        client.setLastname(request.getLastName());
        client.setSecondName(request.getSecondName());

        client.setSnils(request.getSnils());
        client.setPassportNumber(request.getPassportNumber());
        client.setAnamnesis(request.getAnamnesis());

        client = clientRepository.save(client);
        return ClientResponse.of(client);
    }

}
