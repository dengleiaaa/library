package com.woniuxy.pojo;

public class AllRoomInfoPojo {
	private int r_id;
	private String r_address;
	private String r_type;
	private int r_population;
	private String r_sextype;
	private Double r_rent;
	private String r_renttype;
	private String r_renttime;
	private String r_state;
	private int l_id;
	private String l_name;
	private String l_tel;
	private int checkinpeople;

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

	public String getR_state() {
		return r_state;
	}

	public void setR_state(String r_state) {
		this.r_state = r_state;
	}

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

	public int getCheckinpeople() {
		return checkinpeople;
	}

	public void setCheckinpeople(int checkinpeople) {
		this.checkinpeople = checkinpeople;
	}

	@Override
	public String toString() {
		return "AllRoomInfoPojo [r_id=" + r_id + ", r_address=" + r_address + ", r_type=" + r_type + ", r_population="
				+ r_population + ", r_sextype=" + r_sextype + ", r_rent=" + r_rent + ", r_renttype=" + r_renttype
				+ ", r_renttime=" + r_renttime + ", r_state=" + r_state + ", l_id=" + l_id + ", l_name=" + l_name
				+ ", l_tel=" + l_tel + ", checkinpeople=" + checkinpeople + "]";
	}

}
