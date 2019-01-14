package com.woniuxy.pojo;

public class AllBookpojo {
	private int bid;
	private String bname;
	private String bauthor;
	private String bdesc;
	private Double bprice;
	private String bpress;
	private String bpdate;
	private int bnum;
	private String tname;
    private int totalpage;
	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public AllBookpojo() {
		super();
	}

	public AllBookpojo(int bid, String bname, String bauthor, String bdesc, Double bprice, String bpress, String bpdate,
			int bnum, String tname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bdesc = bdesc;
		this.bprice = bprice;
		this.bpress = bpress;
		this.bpdate = bpdate;
		this.bnum = bnum;
		this.tname = tname;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public String getBpress() {
		return bpress;
	}

	public void setBpress(String bpress) {
		this.bpress = bpress;
	}

	public String getBpdate() {
		return bpdate;
	}

	public void setBpdate(String bpdate) {
		this.bpdate = bpdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtype() {
		return tname;
	}

	public void setBtype(String tname) {
		this.tname = tname;
	}

}
