package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.RoomToolPojo;

public interface RoomToolDao {

	@Insert("insert into roomtool(rt_name,rt_time,rt_roomid,rt_solve) values(#{arg0},#{arg1},#{arg2},#{arg3})")
	int insertRoomTool(String tooldesc, String tooldate, int rid,String solve);

	@Select("select * from roomtool where rt_roomid=#{arg0}")
	List<RoomToolPojo> selRoomtool(int rid);

	@Update("update roomtool set rt_solve='已处理' where rt_id=#{arg0}")
	int updateSolve(int rtid);

}
