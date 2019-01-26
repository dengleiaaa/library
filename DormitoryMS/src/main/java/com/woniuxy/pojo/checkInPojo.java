package com.woniuxy.pojo;

public class checkInPojo {
	private int ck_id;
	private int ck_sid;
	private int ck_rid;
	private String ck_time;
	private int flag;

	public int getCk_id() {
		return ck_id;
	}

	public void setCk_id(int ck_id) {
		this.ck_id = ck_id;
	}

	public int getCk_sid() {
		return ck_sid;
	}

	public void setCk_sid(int ck_sid) {
		this.ck_sid = ck_sid;
	}

	public int getCk_rid() {
		return ck_rid;
	}

	public void setCk_rid(int ck_rid) {
		this.ck_rid = ck_rid;
	}

	public String getCk_time() {
		return ck_time;
	}

	public void setCk_time(String ck_time) {
		this.ck_time = ck_time;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "checkInPojo [ck_id=" + ck_id + ", ck_sid=" + ck_sid + ", ck_rid=" + ck_rid + ", ck_time=" + ck_time
				+ ", flag=" + flag + "]";
	}

}
