package com.woniuxy.pojo;

public class BorrowInfoPojo {
	private int borbid;
	private int boruid;
	private String bname;
	private String bauthor;
	private String bdesc;
	private String tname;
	private String borid;
	private String bortime;

	public BorrowInfoPojo() {
		super();
	}

	public BorrowInfoPojo(int borbid, int boruid, String bname, String bauthor, String bdesc, String tname, String borid,
			String bortime) {
		super();
		this.borbid = borbid;
		this.boruid = boruid;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bdesc = bdesc;
		this.tname = tname;
		this.borid = borid;
		this.bortime = bortime;
	}

	public int getBorbid() {
		return borbid;
	}

	public void setBorbid(int borbid) {
		this.borbid = borbid;
	}

	public int getBoruid() {
		return boruid;
	}

	public void setBoruid(int boruid) {
		this.boruid = boruid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBdesc() {
		return bdesc;
	}

	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getBorid() {
		return borid;
	}

	public void setBorid(String borid) {
		this.borid = borid;
	}

	public String getBortime() {
		return bortime;
	}

	public void setBortime(String bortime) {
		this.bortime = bortime;
	}

}
