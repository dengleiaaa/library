package com.woniuxy.pojo;

public class RolePojo {
	private int r_id;
	private String r_role;

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_role() {
		return r_role;
	}

	public void setR_role(String r_role) {
		this.r_role = r_role;
	}

	@Override
	public String toString() {
		return "RolePojo [r_id=" + r_id + ", r_role=" + r_role + "]";
	}

}
