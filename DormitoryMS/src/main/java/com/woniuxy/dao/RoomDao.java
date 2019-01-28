package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.AllRoomInfoPojo;
import com.woniuxy.pojo.RoomPojo;

public interface RoomDao {

	@Insert("insert into room(r_address,r_type,r_population,r_sextype,r_rent,r_renttype,r_renttime,r_lid,r_state) values(#{r_address},#{r_type},#{r_population},#{r_sextype},#{r_rent},#{r_renttype},#{r_renttime},#{r_lid},#{r_state})")
	int insertRoom(RoomPojo roomPojo);

	@Select("select * from allroom where flag=0 limit #{pages},5")
	List<AllRoomInfoPojo> AllGoods(int pages);

	@Select("select COUNT(r_id) count from room")
	int selcountNum();

	@Select("select COUNT(ck_rid) from checkin where ck_rid=#{r_id} and flag=0")
	int selCheckPeople(int r_id);
	
	@Select("select * from allroom where r_address like '%${arg1}%' and r_state like '%${arg2}%' and r_sextype like '%${arg3}%' limit #{arg0},5")
	List<AllRoomInfoPojo> searchRoom(int page, String r_address, String r_state, String r_sextype);

	@Select("select COUNT(r_address like '%${arg0}%' and r_state like '%${arg1}%' and r_sextype like '%${arg2}%') from allroom where r_address like '%${arg0}%' and r_state like '%${arg1}%' and r_sextype like '%${arg2}%'")
	int selcountSarch(String r_address, String r_state, String r_sextype);

	@Select("select * from allroom where r_id=#{roomid}")
	AllRoomInfoPojo selRoomByid(int roomid);

	@Select("select * from allroom where r_state='正常'")
	List<AllRoomInfoPojo> selAllRoomCanLive();

	@Select("select r_id from room where r_address=#{arg0}")
	int selrid(String raddress);

	@Select("select r_population from room where r_id=#{arg0}")
	int selPopulation(int roomid);

	@Update("update room set r_state='损坏' where r_id=#{arg0}")
	int updateState(int rid);

	@Select("SELECT  COUNT(rt_roomid) FROM roomtool WHERE rt_solve='未处理' AND rt_roomid=#{arg0}")
	int selCountHandel(int rid);

	@Update("update room set r_state='正常' where r_id=#{arg0}")
	int updateStateCt(int rid);

	@Update("update room set flag=1 where r_id=#{arg0}")
	int delRoom(int rid);

	
	
	

}																																						












