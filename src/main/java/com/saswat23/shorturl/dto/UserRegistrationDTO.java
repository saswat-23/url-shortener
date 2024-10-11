package com.saswat23.shorturl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRegistrationDTO {

	@NotBlank(message = "Please provide First Name. It can't be empty.")
	private String firstName;
	
	@NotNull(message = "Please provide Last Name. It can't be empty.")
	private String lastName;
	
	@Email(message = "Please provide a valid Email-Id.")
	private String emailId;
	
	@NotBlank(message = "Please provide an UserName. It can't be empty.")
	private String username;
	
	@NotBlank(message = "Please provide a password. It can't be empty.")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserRegistrationDTO [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
