package com.saswat23.shorturl.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.saswat23.shorturl.dto.UserLoginDTO;
import com.saswat23.shorturl.dto.UserRegistrationDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.model.UserModel;
import com.saswat23.shorturl.utils.AppUtils;

@Service
public class UserService {

	public void validateUserLogin(UserLoginDTO userLoginDTO) {
		
	}
	
	public UserModel validateAndRegisterUser(UserRegistrationDTO userRegDTO) throws UserRegistrationException {
		validateUserRegistrationData(userRegDTO);
		return new UserModel();
	}
	
	public void validateAndUpdateUserData() {
		
	}
	
	private void validateUserRegistrationData(UserRegistrationDTO userRegDTO) throws UserRegistrationException {
		
		if(userRegDTO.getUsername().isBlank()) {
			throw new UserRegistrationException("Provided username is blank.");
		}
		
		if(userRegDTO.getFirstName().isBlank()) {
			throw new UserRegistrationException("Provided FirstName is blank.");
		}
		
		if(userRegDTO.getLastName().isBlank()) {
			throw new UserRegistrationException("Provided LastName is blank.");
		}
		
		if(userRegDTO.getPassword().isBlank()) {
			throw new UserRegistrationException("Provided Password is blank.");
		}
		
		if(userRegDTO.getEmailId().isBlank()) {
			throw new UserRegistrationException("Provided EmailId is blank.");
		}
		else if( !Pattern.compile(AppUtils.EMAIL_VALIDATION_REGEX)
						.matcher(userRegDTO.getEmailId())
						.matches()) {
			throw new UserRegistrationException("Provided EmailId is invalid.");
		}
		
	}
}
