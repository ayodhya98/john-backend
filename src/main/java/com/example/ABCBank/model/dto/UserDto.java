package com.example.ABCBank.model.dto;

import com.example.ABCBank.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    private List<Role> role;
}
