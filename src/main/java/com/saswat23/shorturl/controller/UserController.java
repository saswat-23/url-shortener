package com.saswat23.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.saswat23.shorturl.dto.UserLoginReqDTO;
import com.saswat23.shorturl.dto.UserRegisterReqDTO;
import com.saswat23.shorturl.dto.UserRegisterRespDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	
//	@PostMapping({"/login","/"})
//	public ResponseEntity<UserLoginRespDTO> userLogin(UserLoginReqDTO userLoginReq) throws UserRegistrationException {
//		System.out.println("UserLogin Details: "+userLoginReq.toString());
//		return new ResponseEntity<>(userService.validateUserLogin(userLoginReq), HttpStatus.OK);
//	}
	
	@GetMapping({"/dashboard"})
	public String userDashboard() {
		return "This is User Dashboard API...";
	}
	
	@GetMapping({"/login","/"})
	public RedirectView userLogin(UserLoginReqDTO userLoginReq) {
		System.out.println("DTO Redirect URL: "+userLoginReq);
		String redirectUrl = contextPath+"/user"+"/dashboard";

		System.out.println("Generate Redirection URL: "+redirectUrl);
		return new RedirectView(redirectUrl);
		
	}
	
	
	@PostMapping({"/register"})
	public ResponseEntity<UserRegisterRespDTO> registerNewUser(@RequestBody UserRegisterReqDTO userRegisterReq) throws UserRegistrationException {
		System.out.println("Registration Details: "+userRegisterReq.toString());
		return new ResponseEntity<>(userService.validateAndRegisterUser(userRegisterReq), HttpStatus.OK);
	}
	
}
