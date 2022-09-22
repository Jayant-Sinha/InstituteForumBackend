package com.Group4a.InstitueForum.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class JwtRequestDto {
    private String username;
    private String password;
}
