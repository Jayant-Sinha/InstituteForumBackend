/**
 * 
 */
package com.Group4a.InstitueForum.serviceImpl;

import com.Group4a.InstitueForum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Group4a.InstitueForum.daoRepository.UsersDao;
import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.entities.Role;
import com.Group4a.InstitueForum.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * @author JaySin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User addUser(RegistrationDto regDto) {
		
		User user= new User();
		user.setLastName(regDto.getLastName());
		user.setFirstName(regDto.getFirstName());
		user.setEmail(regDto.getEmail());
		user.setUserName(regDto.getUserName());
		user.setPassword(passwordEncoder.encode(regDto.getPassword()));

		Role role= new Role();
		role.setRole_name(regDto.getRoleName());
		
		user.setRole(role);
		user= userDao.save(user);
		
		return user;
	}

	@Override
	public User findUserByUserName(String userName) {
		Optional<User> user = userDao.findUserByUserName(userName);
		return user.get();
	}

	@Override
	public List<User> findUsersByCourseId(String courseId) {
		return  userDao.findUsersByCourse(courseId);
	}

	@Override
	public RegistrationDto getUserDetails(String userName) {
		User user = findUserByUserName(userName);
		return  mapUserToDto(user);
	}

	private RegistrationDto mapUserToDto(User user){
		RegistrationDto dto = new RegistrationDto();
		dto.setEmail(user.getEmail());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setUserName(user.getUserName());
		dto.setRoleName(user.getRole().getRole_name());

		return dto;
	}

}
