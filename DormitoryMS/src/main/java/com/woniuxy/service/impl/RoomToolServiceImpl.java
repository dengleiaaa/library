package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoomToolDao;
import com.woniuxy.pojo.RoomToolPojo;
import com.woniuxy.service.RoomToolService;

@Service
public class RoomToolServiceImpl implements RoomToolService {
	@Autowired
	private RoomToolDao RoomToolDao;

	@Transactional
	@Override
	public int insertRoomTool(String tooldesc, String tooldate, int rid, String solve) {
		int row = RoomToolDao.insertRoomTool(tooldesc, tooldate, rid, solve);
		return row;
	}

	@Transactional
	@Override
	public List<RoomToolPojo> selRoomtoolByid(int rid) {
		List<RoomToolPojo> list = RoomToolDao.selRoomtool(rid);
		return list;
	}

	@Transactional
	@Override
	public int updateSolveByRtid(int rtid) {
		int row = RoomToolDao.updateSolve(rtid);
		return row;
	}
}
