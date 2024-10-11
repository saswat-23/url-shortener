package com.saswat23.shorturl.service;

import org.springframework.stereotype.Service;

import com.saswat23.shorturl.dto.UserLoginDTO;
import com.saswat23.shorturl.dto.UserRegistrationDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.model.UserModel;

@Service
public class UserService {

	public void validateUserLogin(UserLoginDTO userLoginDTO) {
		
	}
	
	public UserModel validateAndRegisterUser(UserRegistrationDTO userRegDTO) throws UserRegistrationException {
		return new UserModel();
	}
	
	public void validateAndUpdateUserData() {
		
	}
	
}
