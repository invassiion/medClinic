package com.example.medClinic.user.controller;


import com.example.medClinic.user.dto.request.RegistrationUserRequest;
import com.example.medClinic.user.dto.response.UserResponse;
import com.example.medClinic.user.entity.UserEntity;
import com.example.medClinic.user.exceptions.BadRequestException;
import com.example.medClinic.user.exceptions.UserAlreadyExistException;
import com.example.medClinic.user.repository.UserRepository;
import com.example.medClinic.user.routes.UserRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${init.email}")
    private String initUser;
    @Value("${init.password}")
    private String initPassword;


    @GetMapping(UserRoutes.INIT)
    public UserResponse init() {
        Optional<UserEntity> checkUser = userRepository.findByEmail(initUser);
        UserEntity user;
        if (checkUser.isEmpty()) {
            user = UserEntity.builder()
                    .firstname("default user")
                    .lastname("default user")
                    .email(initUser)
                    .password(passwordEncoder.encode(initPassword))
                    .build();

            user = userRepository.save(user);
        } else {
            user = checkUser.get();
        }
        return  UserResponse.of(user);
    }

    @PostMapping(UserRoutes.REGISTRATION)
    public UserResponse registration(@RequestBody RegistrationUserRequest request) throws BadRequestException, UserAlreadyExistException {
        request.validate();

        Optional<UserEntity> check = userRepository.findByEmail(request.getEmail());
        if (check.isPresent()) throw  new UserAlreadyExistException();

        UserEntity user = UserEntity.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        user = userRepository.save(user);
        return UserResponse.of(user);
    }
}
