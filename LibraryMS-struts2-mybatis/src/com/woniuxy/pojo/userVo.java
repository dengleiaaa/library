package com.woniuxy.pojo;

import com.woniuxy.utils.MD5_Encoding;

public class userVo {
	private String username;
	private String password;

	public userVo() {
		super();
	}

	public userVo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = MD5_Encoding.upperMD5(password);
	}

	@Override
	public String toString() {
		return "userVo [username=" + username + ", password=" + password + "]";
	}

}
