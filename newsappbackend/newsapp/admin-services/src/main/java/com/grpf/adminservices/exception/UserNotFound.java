package com.grpf.adminservices.exception;

public class UserNotFound {

	 private String message;

	public UserNotFound() {
		super();
	}

	public UserNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
