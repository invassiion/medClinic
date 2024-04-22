package com.example.medClinic.user.dto.request;

import com.example.medClinic.user.exceptions.BadRequestException;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditUserRequest {
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String  snils;
    private String anamnesis;

    public void validate() throws BadRequestException {
        if (firstName == null || firstName.isBlank()) throw  new BadRequestException();
        if (lastName== null || lastName.isBlank()) throw  new BadRequestException();
        if (passportNumber == null || passportNumber.isBlank()) throw  new BadRequestException();
        if (snils== null || snils.isBlank()) throw  new BadRequestException();
        if (anamnesis== null || anamnesis.isBlank()) throw  new BadRequestException();
    }
}
