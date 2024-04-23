package com.example.medClinic.user.dto.request;

import com.example.medClinic.user.exceptions.BadRequestException;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditClientRequest {
    private String firstName;
    private String lastName;
    protected String secondName;
    protected String passportNumber;
    protected String  snils;
    protected String anamnesis;

//    public void validate() throws BadRequestException {
//        if (firstName == null || firstName.isBlank()) throw  new BadRequestException();
//        if (lastName== null || lastName.isBlank()) throw  new BadRequestException();
//        if (secondName== null || secondName.isBlank()) throw  new BadRequestException();
//        if (passportNumber == null || passportNumber.isBlank()) throw  new BadRequestException();
//        if (snils== null || snils.isBlank()) throw  new BadRequestException();
//        if (anamnesis== null || anamnesis.isBlank()) throw  new BadRequestException();
//
//    }
}
