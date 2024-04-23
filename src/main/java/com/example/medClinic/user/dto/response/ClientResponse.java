package com.example.medClinic.user.dto.response;

import com.example.medClinic.user.entity.ClientEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ClientResponse {
    protected Long id;

    protected String firstName;

    protected String lastName;

    protected String secondName;

    protected String email;

    protected String snils;

    protected String passportNumber;

    protected String anamnesis;

    public static ClientResponse of(ClientEntity clientEntity) {
        return ClientResponse.builder()
                .id((clientEntity.getId()))
                .firstName(clientEntity.getFirstname())
                .lastName(clientEntity.getLastname())
                .secondName(clientEntity.getSecondName())
                .email(clientEntity.getEmail())
                .snils(clientEntity.getSnils())
                .passportNumber(clientEntity.getPassportNumber())
                .anamnesis(clientEntity.getAnamnesis())
                .build();
    }
}
