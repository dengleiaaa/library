package com.woniuxy.pojo;

public class UserRegistPojo {
	private int userId;
	private String userAcc;
	private String userPass;
	private String userPasstwo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAcc() {
		return userAcc;
	}

	public void setUserAcc(String userAcc) {
		this.userAcc = userAcc;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserPasstwo() {
		return userPasstwo;
	}

	public void setUserPasstwo(String userPasstwo) {
		this.userPasstwo = userPasstwo;
	}

	@Override
	public String toString() {
		return "UserRegistPojo [userId=" + userId + ", userAcc=" + userAcc + ", userPass=" + userPass + ", userPasstwo="
				+ userPasstwo + "]";
	}

}
