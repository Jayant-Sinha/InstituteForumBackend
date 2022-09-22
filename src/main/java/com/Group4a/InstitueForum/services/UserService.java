package com.Group4a.InstitueForum.services;

import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.entities.User;

import java.util.List;


public interface UserService {

	User addUser(RegistrationDto regDto);
	User findUserByUserName(String userName);
	List<User> findUsersByCourseId(String courseId);

	RegistrationDto getUserDetails(String username);
}
