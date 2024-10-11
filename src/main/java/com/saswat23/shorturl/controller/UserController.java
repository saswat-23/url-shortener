package com.saswat23.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.shorturl.dto.UserLoginDTO;
import com.saswat23.shorturl.dto.UserRegistrationDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping({"/login","/"})
	public String userLogin(@ModelAttribute UserLoginDTO userLogin) {
		
		System.out.println("UserLogin Details: "+userLogin.toString());
		
		return "userLogin...";
	}
	
	
	@PostMapping({"/register"})
	public ResponseEntity<?> userLogin(@ModelAttribute @Valid UserRegistrationDTO userRegister) {
		System.out.println("Registration Details: "+userRegister.toString());
		
		userService.validateAndRegisterUser(userRegister);
		
		return ResponseEntity.ok("User Registered successfully ...");
	}
	
}
