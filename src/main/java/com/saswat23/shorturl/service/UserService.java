package com.saswat23.shorturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saswat23.shorturl.dto.UserLoginReqDTO;
import com.saswat23.shorturl.dto.UserLoginRespDTO;
import com.saswat23.shorturl.dto.UserRegisterReqDTO;
import com.saswat23.shorturl.dto.UserRegisterRespDTO;
import com.saswat23.shorturl.exceptions.UserRegistrationException;
import com.saswat23.shorturl.helper.UserServiceHelper;
import com.saswat23.shorturl.model.UserModel;
import com.saswat23.shorturl.repo.UserRepo;

/**
 * @author saswa
 *
 */
/**
 * @author saswa
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/**
	 * @param userLoginReq
	 * @return
	 * @throws UserRegistrationException
	 */
	public UserLoginRespDTO validateUserLogin(UserLoginReqDTO userLoginReq) throws UserRegistrationException {
		
		// Validate Form Data for User Login
		UserServiceHelper.validateUserLoginData(userLoginReq);
		
		UserModel user = new UserModel();
		user.setUsername(userLoginReq.getUsername());
		user.setPassword(encodePassword(userLoginReq.getPassword()));
		
		UserLoginRespDTO userLoginResp = new UserLoginRespDTO();
		userLoginResp.setUsername(user.getUsername());
		userLoginResp.setAuthToken("SampleToken_pk3d9jafijf3");
//		userRepo.ge
		
		return userLoginResp;
	}
	
	/**
	 * @param userRegisterReq
	 * @return
	 * @throws UserRegistrationException
	 */
	public UserRegisterRespDTO validateAndRegisterUser(UserRegisterReqDTO userRegisterReq) throws UserRegistrationException {
		
		// Validate Form Data for User Registration
		UserServiceHelper.validateUserRegistrationData(userRegisterReq);
		
		UserModel user = new UserModel();
		user.setUsername(userRegisterReq.getUsername());
		user.setFirstName(userRegisterReq.getFirstName());
		user.setLastName(userRegisterReq.getLastName());
		user.setEmailId(userRegisterReq.getEmailId());
		user.setPassword(encodePassword(userRegisterReq.getPassword()));
		user.setEmailVerification("N");
		user.setStatus("active");
		
		// Handle exceptions occurring during DB entry
		try {
			user = userRepo.save(user);
		}
		catch(DataIntegrityViolationException ex) {
			throw new UserRegistrationException("Registration failed! "+ex.getRootCause().toString()
												.substring(ex.getRootCause().toString().indexOf("Detail: ")));
		}
		
		UserRegisterRespDTO userResp = new UserRegisterRespDTO(user.getUsername(), user.getEmailId(), "User Registered. Email verification is pending");
		
		return userResp;
	}
	
	/**
	 * 
	 */
	public void validateAndUpdateUserData() {
		
	}
	
	
	/**
	 * @param plainPassword
	 * @return
	 */
	public String encodePassword(String plainPassword) {
		return passwordEncoder.encode(plainPassword);
	}
	
}
