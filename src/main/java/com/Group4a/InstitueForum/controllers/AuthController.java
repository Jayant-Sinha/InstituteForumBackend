package com.Group4a.InstitueForum.controllers;

import com.Group4a.InstitueForum.dto.JwtRequestDto;
import com.Group4a.InstitueForum.dto.JwtResponse;
import com.Group4a.InstitueForum.dto.RegistrationDto;
import com.Group4a.InstitueForum.entities.User;
import com.Group4a.InstitueForum.services.UserService;
import com.Group4a.InstitueForum.utils.JwtUtil;
import com.Group4a.InstitueForum.serviceImpl.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    UserDetailImpl userDetailsService;

    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequestDto.getUsername(), jwtRequestDto.getPassword())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequestDto.getUsername());

            final String jwt = jwtUtils.generateToken(userDetails);

            JwtResponse response = new JwtResponse();
            response.setToken(jwt);
            response.setUser(userService.getUserDetails(jwtRequestDto.getUsername()));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(jwtRequestDto, HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto) {
        try {
            User user = userService.addUser(registrationDto);
            UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDto.getUserName());
            final String jwt = jwtUtils.generateToken(userDetails);

            JwtResponse response = new JwtResponse();
            response.setToken(jwt);
            response.setUser(userService.getUserDetails(user.getUserName()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/currentUser")
    public ResponseEntity<?> registerUser(@RequestBody JwtResponse request ) {
        String token = request.getToken();
        String userName = jwtUtils.extractUsername(token);
        JwtResponse response = new JwtResponse();
        response.setToken(token);
        response.setUser(userService.getUserDetails(userName));
        return  ResponseEntity.ok(response);
    }
}
