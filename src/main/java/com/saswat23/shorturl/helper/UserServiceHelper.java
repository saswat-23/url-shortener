package com.saswat23.shorturl.helper;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.saswat23.shorturl.dto.UserLoginReqDTO;
import com.saswat23.shorturl.dto.UserRegisterReqDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.utils.AppUtils;

public class UserServiceHelper {

	public static void validateUserRegistrationData(UserRegisterReqDTO userRegReq) throws UserRegistrationException {
		
		if(StringUtils.isEmpty(userRegReq.getUsername())) {
			throw new UserRegistrationException("Please provide an username");
		}
		
		if(StringUtils.isEmpty(userRegReq.getFirstName())) {
			throw new UserRegistrationException("Please provide First Name");
		}
		
		if(StringUtils.isEmpty(userRegReq.getLastName())) {
			throw new UserRegistrationException("Please provide Last Name.");
		}
		
		if(StringUtils.isEmpty(userRegReq.getPassword())) {
			throw new UserRegistrationException("Please provide a password");
		}
		
		if(StringUtils.isEmpty(userRegReq.getEmailId())) {
			throw new UserRegistrationException("Please provide an EmailId");
		}
		else if( !Pattern.compile(AppUtils.EMAIL_VALIDATION_REGEX)
						.matcher(userRegReq.getEmailId())
						.matches()) {
			throw new UserRegistrationException("Provided EmailId is invalid.");
		}
	}
	
	public static void validateUserLoginData(UserLoginReqDTO userLoginReq) throws UserRegistrationException {
		
		if(StringUtils.isEmpty(userLoginReq.getUsername())) {
			throw new UserRegistrationException("Please provide an username");
		}
		
		if(StringUtils.isEmpty(userLoginReq.getPassword())) {
			throw new UserRegistrationException("Please provide a password");
		}
	}
}
