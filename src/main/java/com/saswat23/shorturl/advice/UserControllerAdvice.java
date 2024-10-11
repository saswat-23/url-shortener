package com.saswat23.shorturl.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saswat23.shorturl.exceptions.UserRegistrationException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserRegistrationException.class)
	public Map<String, String> userRegistrationValidation(UserRegistrationException ure) {
		Map<String, String> exMap = new HashMap<>();
		exMap.put("error", ure.getMessage());
		return exMap;
	}
	
}
