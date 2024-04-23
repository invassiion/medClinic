package com.example.medClinic.user.dto.request;


import com.example.medClinic.user.exceptions.BadRequestException;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegistrationClientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public void validate() throws BadRequestException {
        if (email == null || email.isBlank()) throw  new BadRequestException();
        if (password == null || password.isBlank()) throw  new BadRequestException();

    }
}
