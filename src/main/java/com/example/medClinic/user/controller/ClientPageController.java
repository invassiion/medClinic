package com.example.medClinic.user.controller;

import com.example.medClinic.user.entity.ClientEntity;
import com.example.medClinic.user.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ClientPageController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public String getClientPage(Model model, Principal principal) {
        String email = principal.getName();
        Optional<ClientEntity> client = clientRepository.findByEmail(email);
        model.addAttribute("client", client.orElse(new ClientEntity()));
        return "client";
    }
}