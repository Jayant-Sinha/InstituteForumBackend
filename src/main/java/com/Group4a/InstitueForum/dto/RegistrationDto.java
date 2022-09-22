package com.Group4a.InstitueForum.dto;
import com.Group4a.InstitueForum.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RegistrationDto {	

	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String roleName;
}
