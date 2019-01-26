package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.woniuxy.pojo.LandlordPojo;

public interface LandLordDao {

	@Insert("insert into landlord(l_name,l_tel) values(#{l_name},#{l_tel})")
	int InsertLandlord(LandlordPojo landlordPojo);

	@Select("select l_id from landlord where l_tel=#{l_tel}")
	int selLid(LandlordPojo landlordPojo);

	@Select("select * from landlord where l_tel=#{l_tel}")
	List<LandlordPojo> selTel(LandlordPojo landlordPojo);

}

