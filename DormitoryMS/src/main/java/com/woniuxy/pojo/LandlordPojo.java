package com.woniuxy.pojo;

public class LandlordPojo {

	private int l_id;
	private String l_name;
	private String l_tel;
	private int flag;

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getL_tel() {
		return l_tel;
	}

	public void setL_tel(String l_tel) {
		this.l_tel = l_tel;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "LandlordPojo [l_id=" + l_id + ", l_name=" + l_name + ", l_tel=" + l_tel + ", flag=" + flag + "]";
	}

}
