package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.CheckInDao;
import com.woniuxy.pojo.checkInPojo;
import com.woniuxy.service.CheckInService;

@Service
public class CheckInServiceImpl implements CheckInService {
	@Autowired
	private CheckInDao CheckInDao;

	@Transactional
	@Override
	public int insertCheckinfo(int sid, int roomid, String sdate) {
		int row = CheckInDao.insertCheckinfo(sid, roomid, sdate);
		return row;
	}

	@Transactional
	@Override
	public List<checkInPojo> selCheckRoomByRid(int rid) {
		List<checkInPojo> checkInPojo = CheckInDao.selRoomByRid(rid);
		return checkInPojo;
	}

	@Transactional
	@Override
	public int changeRoomBySid(int sid, int rid) {
		int row = CheckInDao.updateCheckInfoBySid(sid,rid);
		return row;
	}
}
