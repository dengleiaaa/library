package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.RoomToolPojo;

public interface RoomToolService {

	int insertRoomTool(String tooldesc, String tooldate, int rid,String solve);

	List<RoomToolPojo> selRoomtoolByid(int rid);

	int updateSolveByRtid(int rtid);

}
