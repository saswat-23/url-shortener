package com.saswat23.shorturl.dto;

public class UserRegisterRespDTO {

	private String emailId;
	private String username;
	private String respMsg;

	public UserRegisterRespDTO(String emailId, String username, String respMsg) {
		this.emailId = emailId;
		this.username = username;
		this.respMsg = respMsg;
	}

	public UserRegisterRespDTO() {}
	
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
	
	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	@Override
	public String toString() {
		return "UserRegisterRespDTO [emailId=" + emailId + ", username=" + username + ", respMsg=" + respMsg + "]";
	}
	
}
