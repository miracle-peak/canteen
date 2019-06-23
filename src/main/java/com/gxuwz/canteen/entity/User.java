package com.gxuwz.canteen.entity;

public class User {
	private int userId;
	private String userName;
	private String utype;
	private String password;
	
	public User() {
		super();
	}

	public User(int userId, String userName, String utype, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.utype = utype;
		this.password = password;
	}

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
	
	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
