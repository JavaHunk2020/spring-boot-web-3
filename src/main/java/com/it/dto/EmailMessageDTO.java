package com.it.dto;

public class EmailMessageDTO {
	private String toEmail;
	private String username;
	private String subject;

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailMessageDTO [toEmail=" + toEmail + ", username=" + username + ", subject=" + subject + "]";
	}

}
