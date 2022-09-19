/**
 * 
 */
package com.Group4a.InstitueForum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group4a.InstitueForum.daoRepository.RolesDao;
import com.Group4a.InstitueForum.daoRepository.UsersDao;
import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.entities.Role;
import com.Group4a.InstitueForum.entities.User;

/**
 * @author JaySin
 *
 */
@Service
public class RegistrationServiceImplementation implements RegistrationService {

	@Autowired
	private UsersDao userDao;
	
//	@Autowired
//	private RolesDao roleDao;
	
	@Override
	public User addUser(RegistrationDto regDto) {
		
		User user= new User();
		user.setEmail(regDto.getEmail());
		user.setUser_name(regDto.getUser_name());
		user.setPassword(regDto.getPassword());
		
		
		Role role= new Role();
		role.setRole_name(regDto.getRole_name());
		
		user.setRole(role);
		user= userDao.save(user);
		
//		role=roleDao.save(role);
		
		
		return user;
	}
	
}
