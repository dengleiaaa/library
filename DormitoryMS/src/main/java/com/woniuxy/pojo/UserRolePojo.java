package com.woniuxy.pojo;

public class UserRolePojo {
	private int u_id;
	private String u_acc;
	private String u_pass;
	private String r_role;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_acc() {
		return u_acc;
	}

	public void setU_acc(String u_acc) {
		this.u_acc = u_acc;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	public String getR_role() {
		return r_role;
	}

	public void setR_role(String r_role) {
		this.r_role = r_role;
	}

	@Override
	public String toString() {
		return "UserRolePojo [u_id=" + u_id + ", u_acc=" + u_acc + ", u_pass=" + u_pass + ", r_role=" + r_role + "]";
	}

}
