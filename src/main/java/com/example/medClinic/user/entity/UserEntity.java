package com.example.medClinic.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "first_name")
    protected String firstname;
    @Column(name = "last_name")
    protected String lastname;

    protected String email;

    protected String password;

    protected String snils;

    protected String passportNumber;

    protected String anamnesis;


}
