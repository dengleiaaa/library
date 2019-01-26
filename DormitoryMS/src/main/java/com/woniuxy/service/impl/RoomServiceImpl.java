package com.woniuxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.RoomDao;
import com.woniuxy.pojo.AllRoomInfoPojo;
import com.woniuxy.pojo.RoomPojo;
import com.woniuxy.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao RoomDao;

	@Transactional
	@Override
	public String insertRoom(RoomPojo roomPojo) {
		String result = "添加失败";
		int row = RoomDao.insertRoom(roomPojo);
		if (row > 0) {
			result = "添加成功";
			return result;
		}
		return result;
	}

	@Transactional
	@Override
	public List<AllRoomInfoPojo> selAllRoom(int rpage) {

		List<AllRoomInfoPojo> abklist = new ArrayList<>();
		int pages = (rpage * 5 - 5);
		abklist = RoomDao.AllGoods(pages);
		return abklist;

	}

	@Transactional
	@Override
	public int selcountNum() {
		int total = RoomDao.selcountNum();
		if (total % 5 == 0) {
			total = total / 5;
		} else {
			total = total / 5 + 1;
		}
		return total;
	}

	@Transactional
	@Override
	public int selCheckInPeople(int r_id) {
		int checkPeople = RoomDao.selCheckPeople(r_id);
		return checkPeople;
	}

	@Transactional
	@Override
	public List<AllRoomInfoPojo> searchRoom(int page, String r_address, String r_state, String r_sextype) {
		List<AllRoomInfoPojo> abklist = new ArrayList<>();
		int pages = (page * 5 - 5);
		abklist = RoomDao.searchRoom(pages, r_address, r_state, r_sextype);
		return abklist;
	}

	@Transactional
	@Override
	public int selcountSarch(String r_address, String r_state, String r_sextype) {
		int total = RoomDao.selcountSarch(r_address, r_state, r_sextype);
		if (total % 5 == 0) {
			total = total / 5;
		} else {
			total = total / 5 + 1;
		}
		return total;
	}

	@Transactional
	@Override
	public AllRoomInfoPojo selRoomByid(int roomid) {
		AllRoomInfoPojo allRoomInfoPojo = RoomDao.selRoomByid(roomid);

		return allRoomInfoPojo;
	}

	@Transactional
	@Override
	public List<AllRoomInfoPojo> selAllRoomCanLive() {
		List<AllRoomInfoPojo> abklist = RoomDao.selAllRoomCanLive();
		return abklist;
	}

	@Transactional
	@Override
	public int selridByrname(String raddress) {
		int cid = RoomDao.selrid(raddress);
		return cid;
	}

	@Transactional
	@Override
	public int selrpopulationByrid(int roomid) {
		int people = RoomDao.selPopulation(roomid);
		return people;
	}

	@Transactional
	@Override
	public int updateStateById(int rid) {
		int row = RoomDao.updateState(rid);
		return row;
	}

	@Transactional
	@Override
	public int selCountHandel(int rid) {
		int countHandel = RoomDao.selCountHandel(rid);
		return countHandel;
	}

	@Transactional
	@Override
	public int updateStateCorrect(int rid) {
		int row = RoomDao.updateStateCt(rid);
		return row;
	}
	@Transactional
	@Override
	public int delRoomByid(int rid) {
		int row = RoomDao.delRoom(rid);
		return row;
	}

}
