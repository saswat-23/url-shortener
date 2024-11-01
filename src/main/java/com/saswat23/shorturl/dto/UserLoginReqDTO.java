package com.saswat23.shorturl.dto;

public class UserLoginReqDTO {

	private String username;
	private String password;
	private String redirectUrl;
	
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
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	@Override
	public String toString() {
		return "UserLoginReqDTO [username=" + username + ", password=" + password + ", redirectUrl=" + redirectUrl
				+ "]";
	}
	
}
