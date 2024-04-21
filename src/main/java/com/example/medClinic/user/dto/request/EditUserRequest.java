package com.example.medClinic.user.dto.request;

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
}
