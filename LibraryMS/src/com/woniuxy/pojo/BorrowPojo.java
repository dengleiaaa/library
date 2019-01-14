package com.woniuxy.pojo;

public class BorrowPojo {
	private String borid;
	private int boruid;
	private int borbid;
	private String bortime;

	public BorrowPojo() {
		super();
	}

	public BorrowPojo(String borid, int boruid, int borbid, String bortime) {
		super();
		this.borid = borid;
		this.boruid = boruid;
		this.borbid = borbid;
		this.bortime = bortime;
	}

	public String getBorid() {
		return borid;
	}

	public void setBorid(String borid) {
		this.borid = borid;
	}

	public int getBoruid() {
		return boruid;
	}

	public void setBoruid(int boruid) {
		this.boruid = boruid;
	}

	public int getBorbid() {
		return borbid;
	}

	public void setBorbid(int borbid) {
		this.borbid = borbid;
	}

	public String getBortime() {
		return bortime;
	}

	public void setBortime(String bortime) {
		this.bortime = bortime;
	}

}
