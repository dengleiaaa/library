package com.woniuxy.pojo;

public class TeacherPojo {
	private int tid;
	private String tname;
	private int tcid;
	private int flag;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getTcid() {
		return tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "StudentPojo [tid=" + tid + ", tname=" + tname + ", tcid=" + tcid + ", flag=" + flag + "]";
	}

}
