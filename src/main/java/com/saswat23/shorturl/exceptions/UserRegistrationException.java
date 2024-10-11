package com.saswat23.shorturl.exceptions;

public class UserRegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8103246933471799206L;
	
	public UserRegistrationException() {
        super();
    }
	
	public UserRegistrationException(String message) {
        super(message);
    }
	
	public UserRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserRegistrationException(Throwable cause) {
        super(cause);
    }
	
}
