package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.AllRoomInfoPojo;
import com.woniuxy.pojo.RoomPojo;

public interface RoomService {

	String insertRoom(RoomPojo roomPojo);

	List<AllRoomInfoPojo> selAllRoom(int rpage);

	int selcountNum();

	int selCheckInPeople(int r_id);

	List<AllRoomInfoPojo> searchRoom(int page, String r_address, String r_state, String r_sextype);

	int selcountSarch(String r_address, String r_state, String r_sextype);

	AllRoomInfoPojo selRoomByid(int roomid);

	List<AllRoomInfoPojo> selAllRoomCanLive();

	int selridByrname(String raddress);

	int selrpopulationByrid(int roomid);

	int updateStateById(int rid);

	int selCountHandel(int rid);

	int updateStateCorrect(int rid);

	int delRoomByid(int rid);



	

}
