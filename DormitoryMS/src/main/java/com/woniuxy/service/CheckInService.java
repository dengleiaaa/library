package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.checkInPojo;

public interface CheckInService {

	int insertCheckinfo(int sid, int roomid, String sdate);

	List<checkInPojo> selCheckRoomByRid(int rid);

	int changeRoomBySid(int sid, int rid);

}
