package com.woniuxy.pojo;

public class AllStudentPojo {
	private int s_id;
	private String s_name;
	private String s_sex;
	private String s_tel;
	private String s_img;
	private int s_cid;
	private String ck_time;
	private String c_name;
	private String r_address;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public String getS_img() {
		return s_img;
	}

	public void setS_img(String s_img) {
		this.s_img = s_img;
	}

	public int getS_cid() {
		return s_cid;
	}

	public void setS_cid(int s_cid) {
		this.s_cid = s_cid;
	}

	

	public String getCk_time() {
		return ck_time;
	}

	public void setCk_time(String ck_time) {
		this.ck_time = ck_time;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}

	@Override
	public String toString() {
		return "AllStudentPojo [s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_tel=" + s_tel
				+ ", s_img=" + s_img + ", s_cid=" + s_cid + ", ck_time=" + ck_time + ", c_name=" + c_name
				+ ", r_address=" + r_address + "]";
	}

}
