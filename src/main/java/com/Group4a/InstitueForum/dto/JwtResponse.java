package com.Group4a.InstitueForum.dto;

import com.Group4a.InstitueForum.entities.User;
import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private RegistrationDto user;
}
