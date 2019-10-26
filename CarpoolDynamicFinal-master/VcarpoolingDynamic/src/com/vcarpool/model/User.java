package com.vcarpool.model;

/*
@author hemanth;
*/

public class User {

	public User() {
		
	}

	private int userId;
	private String userName;
	private String password;

	private String type;
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", type=" + type
				+ ", email=" + email + "]";
	}

	public User(String userName, String password, String type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
