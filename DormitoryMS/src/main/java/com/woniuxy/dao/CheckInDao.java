package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.checkInPojo;

public interface CheckInDao {


	@Insert("insert into checkin(ck_sid,ck_rid,ck_time) values(#{arg0},#{arg1},#{arg2})")
	int insertCheckinfo(int sid, int roomid, String sdate);

	@Select("select * from checkin where ck_rid=#{arg0} and flag=0")
	List<checkInPojo> selRoomByRid(int rid);

	@Update("update checkin set ck_rid=#{arg1} where ck_sid=#{arg0}")
	int updateCheckInfoBySid(int sid, int rid);

	

}
