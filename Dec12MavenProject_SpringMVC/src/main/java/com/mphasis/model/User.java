package com.mphasis.model;

public class User {
	
	private String uname;
	private String pwd;
	private String role;
	private String email;
	private String mobile;
	public User() {
		super();
	}
	
	

	public User(String uname, String pwd, String role, String email, String mobile) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.role = role;
		this.email = email;
		this.mobile = mobile;
	}



	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	@Override
	public String toString() {
		return "User [uname=" + uname + ", pwd=" + pwd + ", role=" + role + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}



	
	

}
