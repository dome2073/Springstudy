package com.bitcamp.mvc0726;

public class LoginInfo {
	private String id;
	private String pw;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public LoginInfo() {
		
	}
		
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", pw=" + pw + "]";
	}

	public LoginInfo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
}
