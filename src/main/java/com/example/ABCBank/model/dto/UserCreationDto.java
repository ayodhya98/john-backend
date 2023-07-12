package com.example.ABCBank.model.dto;
import lombok.Data;

@Data
public class UserCreationDto {
    private String firstname;
    private String lastname;
    private String email;

    private String password;
}

