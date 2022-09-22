package com.Group4a.InstitueForum.serviceImpl;

import java.util.ArrayList;

import com.Group4a.InstitueForum.daoRepository.UsersDao;
import com.Group4a.InstitueForum.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailImpl implements UserDetailsService {

    @Autowired
    UsersDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), new ArrayList<>());
    }
}