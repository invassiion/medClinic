package com.example.medClinic.user.dto.response;

import com.example.medClinic.user.entity.UserEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserResponse {
    protected Long id;

    protected String firstName;

    protected String lastName;

    protected String email;

    protected String snils;

    protected String passportNumber;

    protected String anamnesis;

    public static UserResponse of(UserEntity userEntity) {
        return UserResponse.builder()
                .id((userEntity.getId()))
                .firstName(userEntity.getFirstname())
                .lastName(userEntity.getLastname())
                .email(userEntity.getEmail())
                .snils(userEntity.getSnils())
                .passportNumber(userEntity.getPassportNumber())
                .anamnesis(userEntity.getAnamnesis())
                .build();
    }
}
