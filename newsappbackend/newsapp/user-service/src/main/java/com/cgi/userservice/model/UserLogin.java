package com.cgi.userservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLogin {
	@Id
	private String userId;
	private String password;
	public UserLogin() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + "]";
	}


}
