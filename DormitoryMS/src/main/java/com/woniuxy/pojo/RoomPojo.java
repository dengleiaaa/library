package com.woniuxy.pojo;

public class RoomPojo {
	private int r_id;
	private String r_address;
	private String r_type;
	private int r_population;
	private String r_sextype;
	private Double r_rent;
	private String r_renttype;
	private String r_renttime;
	private int r_lid;
	private String r_state;
	private int flag;

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public int getR_population() {
		return r_population;
	}

	public void setR_population(int r_population) {
		this.r_population = r_population;
	}

	public String getR_sextype() {
		return r_sextype;
	}

	public void setR_sextype(String r_sextype) {
		this.r_sextype = r_sextype;
	}

	public Double getR_rent() {
		return r_rent;
	}

	public void setR_rent(Double r_rent) {
		this.r_rent = r_rent;
	}

	public String getR_renttype() {
		return r_renttype;
	}

	public void setR_renttype(String r_renttype) {
		this.r_renttype = r_renttype;
	}

	public String getR_renttime() {
		return r_renttime;
	}

	public void setR_renttime(String r_renttime) {
		this.r_renttime = r_renttime;
	}

	public int getR_lid() {
		return r_lid;
	}

	public void setR_lid(int r_lid) {
		this.r_lid = r_lid;
	}

	public String getR_state() {
		return r_state;
	}

	public void setR_state(String r_state) {
		this.r_state = r_state;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "RoomPojo [r_id=" + r_id + ", r_address=" + r_address + ", r_type=" + r_type + ", r_population="
				+ r_population + ", r_sextype=" + r_sextype + ", r_rent=" + r_rent + ", r_renttype=" + r_renttype
				+ ", r_renttime=" + r_renttime + ", r_lid=" + r_lid + ", r_state=" + r_state + ", flag=" + flag + "]";
	}

}
