package com.woniuxy.pojo;

public class UserPojo {
	private int userId;
	private String userAcc;
	private String userPass;

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

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userAcc=" + userAcc + ", userPass=" + userPass + "]";
	}

}
