package com.saswat23.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.shorturl.dto.UserLoginReqDTO;
import com.saswat23.shorturl.dto.UserLoginRespDTO;
import com.saswat23.shorturl.dto.UserRegisterReqDTO;
import com.saswat23.shorturl.dto.UserRegisterRespDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping({"/login","/"})
	public ResponseEntity<UserLoginRespDTO> userLogin(UserLoginReqDTO userLoginReq) throws UserRegistrationException {
		System.out.println("UserLogin Details: "+userLoginReq.toString());
		return new ResponseEntity<>(userService.validateUserLogin(userLoginReq), HttpStatus.OK);
	}
	
	
	@PostMapping({"/register"})
	public ResponseEntity<UserRegisterRespDTO> userLogin(UserRegisterReqDTO userRegisterReq) throws UserRegistrationException {
		System.out.println("Registration Details: "+userRegisterReq.toString());
		return new ResponseEntity<>(userService.validateAndRegisterUser(userRegisterReq), HttpStatus.OK);
	}
	
}
