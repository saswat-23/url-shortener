package com.saswat23.shorturl.dto;

public class UserLoginRespDTO {

	private String username;
	private String authToken;
//	private List<Roles> userRoles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public String toString() {
		return "UserLoginDTO [username=" + username + ", authToken=" + authToken + "]";
	}
	
	
	
}
