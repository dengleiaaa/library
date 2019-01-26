package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.LandlordPojo;

public interface LandLordService {
	public String addLandlord(LandlordPojo landlordPojo);

	public int selLidByLname(LandlordPojo landlordPojo);

	public List<LandlordPojo> selTel(LandlordPojo landlordPojo);
}
