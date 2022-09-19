package com.Group4a.InstitueForum.dto;
import com.Group4a.InstitueForum.entities.User;
public class RegistrationDto {	

	private String user_name;
	private String email;
	private String password;

	private String role_name;


	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


}
