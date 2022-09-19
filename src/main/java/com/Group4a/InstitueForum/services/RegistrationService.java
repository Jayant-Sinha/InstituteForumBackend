package com.Group4a.InstitueForum.services;

import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.entities.User;


public interface RegistrationService {

	User addUser(RegistrationDto regDto);
	

}
