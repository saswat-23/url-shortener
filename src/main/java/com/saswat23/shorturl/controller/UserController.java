package com.saswat23.shorturl.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	final String DEFAULT_REDIRECT_URL = "/surl/";
	
//	@PostMapping({"/login","/"})
//	public ResponseEntity<UserLoginRespDTO> userLogin(UserLoginReqDTO userLoginReq) throws UserRegistrationException {
//		System.out.println("UserLogin Details: "+userLoginReq.toString());
//		return new ResponseEntity<>(userService.validateUserLogin(userLoginReq), HttpStatus.OK);
//	}
	
	@GetMapping({"/login","/"})
	public ResponseEntity<?> userLogin(UserLoginReqDTO userLoginReq) {
//		HttpHeaders headers= new HttpHeaders();
		System.out.println("Redirect URL: "+userLoginReq);
		String redirectUrl = userLoginReq.getRedirectUrl();
//		URI uri = URI.create(StringUtils.isEmpty(redirectUrl)?DEFAULT_REDIRECT_URL:redirectUrl);
//		headers.setLocation(uri);
		
//		return ResponseEntity.created(uri)
//							.allow(HttpMethod.GET)
//							.build();
				//new ResponseEntity<>(headers,HttpStatus.PERMANENT_REDIRECT);
		
		return ResponseEntity.status(HttpStatus.SEE_OTHER)  // HTTP 303 status code
                .location(URI.create("/shorten/home"))  // Specify the redirect location (no controller-level path)
                .build();
		
	}
	
	
	@PostMapping({"/register"})
	public ResponseEntity<UserRegisterRespDTO> userLogin(UserRegisterReqDTO userRegisterReq) throws UserRegistrationException {
		System.out.println("Registration Details: "+userRegisterReq.toString());
		return new ResponseEntity<>(userService.validateAndRegisterUser(userRegisterReq), HttpStatus.OK);
	}
	
}
