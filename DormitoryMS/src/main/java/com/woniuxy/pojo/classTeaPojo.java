package com.woniuxy.pojo;

public class classTeaPojo {
	private int c_id;
	private String c_name;
	private String c_opentime;
	private int t_id;
	private String t_name;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_opentime() {
		return c_opentime;
	}

	public void setC_opentime(String c_opentime) {
		this.c_opentime = c_opentime;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	@Override
	public String toString() {
		return "classTeaPojo [c_id=" + c_id + ", c_name=" + c_name + ", c_opentime=" + c_opentime + ", t_id=" + t_id
				+ ", t_name=" + t_name + "]";
	}

}
