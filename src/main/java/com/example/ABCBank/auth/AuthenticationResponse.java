package com.example.ABCBank.auth;

import com.example.ABCBank.model.User;
import com.example.ABCBank.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse implements Serializable {

    private String token;
    private UserDto user;
}