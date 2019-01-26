package com.woniuxy.pojo;

public class ClassPojo {
	private int cid;
	private String cname;
	private String openTime;
	private int flag;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "ClassPojo [cid=" + cid + ", cname=" + cname + ", openTime=" + openTime + ", flag=" + flag + "]";
	}

}
