package com.grpf.adminservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="adminDetails")
public class AdminRegister {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="adminid")
	private int adminId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="emailid")
	private String emailId;
	
	private String password;


	public AdminRegister() {
		super();
	}

	public AdminRegister(int adminId, String userName, String emailId, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "AdminRegister [adminId=" + adminId + ", userName=" + userName + ", emailId=" + emailId + ", password="
				+ password + "]";
	}
		

}
