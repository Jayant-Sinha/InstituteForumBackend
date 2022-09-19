package com.Group4a.InstitueForum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.services.RegistrationService;

@RestController
public class EntryPoint {
	
	@Autowired
	private RegistrationService regService;

	
	//Registration Controller
//	@GetMapping("/register")
//	public List<Role> getRoles() 
//	{
//		return this.reg_service.getRoles();
//		
//	}
//	
	@PostMapping("/register")
	
	public String regUser(@RequestBody RegistrationDto regDto) 
	{
		regService.addUser(regDto);
		return "Data entered";
	}
}
