package com.woniuxy.pojo;

public class RoomToolPojo {
	private int rt_id;
	private String rt_name;
	private String rt_time;
	private int rt_roomid;
	private String rt_solve;

	public int getRt_id() {
		return rt_id;
	}

	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}

	public String getRt_name() {
		return rt_name;
	}

	public void setRt_name(String rt_name) {
		this.rt_name = rt_name;
	}

	public String getRt_time() {
		return rt_time;
	}

	public void setRt_time(String rt_time) {
		this.rt_time = rt_time;
	}

	public int getRt_roomid() {
		return rt_roomid;
	}

	public void setRt_roomid(int rt_roomid) {
		this.rt_roomid = rt_roomid;
	}

	public String getRt_solve() {
		return rt_solve;
	}

	public void setRt_solve(String rt_solve) {
		this.rt_solve = rt_solve;
	}

	@Override
	public String toString() {
		return "RoomToolPojo [rt_id=" + rt_id + ", rt_name=" + rt_name + ", rt_time=" + rt_time + ", rt_roomid="
				+ rt_roomid + ", rt_solve=" + rt_solve + "]";
	}

}
