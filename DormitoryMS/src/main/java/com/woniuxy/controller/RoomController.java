package com.woniuxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.woniuxy.pojo.AllRoomInfoPojo;
import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.pojo.ClassPojo;
import com.woniuxy.pojo.LandlordPojo;
import com.woniuxy.pojo.RoomPojo;
import com.woniuxy.pojo.checkInPojo;
import com.woniuxy.service.CheckInService;
import com.woniuxy.service.ClassService;
import com.woniuxy.service.LandLordService;
import com.woniuxy.service.RoomService;
import com.woniuxy.service.StudentService;

@RestController
@RequestMapping("/room")
public class RoomController {
	List<String> List = new ArrayList<String>();
	@Autowired
	private LandLordService LandLordService;
	@Autowired
	private RoomService RoomService;
	@Autowired
	private ClassService ClassService;
	@Autowired
	private CheckInService CheckInService;
	@Autowired
	private StudentService StudentService;

	@RequestMapping("/addroom")
	public Map<String, Object> addRoom(RoomPojo roomPojo, LandlordPojo landlordPojo) {
		Map<String, Object> map = new HashMap<>();
		String result = "";
		List<LandlordPojo> landlordPojo1 = LandLordService.selTel(landlordPojo);

		if (!landlordPojo1.isEmpty()) {
			map.put("result", "电话重复,请重新输入");
			return map;
		}
		result = LandLordService.addLandlord(landlordPojo);

		if (result.equals("添加成功")) {
			int lid = LandLordService.selLidByLname(landlordPojo);
			roomPojo.setR_lid(lid);
			result = RoomService.insertRoom(roomPojo);
		}
		map.put("result", result);
		return map;

	}

	@RequestMapping("/roominfo")
	public Map<String, Object> roomInfo(int rpage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AllRoomInfoPojo> list = RoomService.selAllRoom(rpage);

		int total = RoomService.selcountNum();
		for (int i = 0; i < list.size(); i++) {
			int checkinpeople = RoomService.selCheckInPeople(list.get(i).getR_id());
			list.get(i).setCheckinpeople(checkinpeople);
		}
		map.put("allroom", list);
		map.put("allpage", total);
		map.put("currentpage", rpage);
		return map;
	}

	@RequestMapping("/searchroom")
	public Map<String, Object> searchRoom(int page, String r_address, String r_state, String r_kezhu,
			String r_sextype) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = "";
		if (r_state.equals("不限")) {
			r_state = "";
		}
		if (r_sextype.equals("不限")) {
			r_sextype = "";
		}

		List<AllRoomInfoPojo> list1 = RoomService.searchRoom(page, r_address, r_state, r_sextype);
		int total = RoomService.selcountSarch(r_address, r_state, r_sextype);
		for (int i = 0; i < list1.size(); i++) {
			int checkinpeople = RoomService.selCheckInPeople(list1.get(i).getR_id());
			list1.get(i).setCheckinpeople(checkinpeople);
		}
		if (r_kezhu.equals("可住房间")) {
			for (int i = 0; i < list1.size(); i++) {
				int checkinpeople = RoomService.selCheckInPeople(list1.get(i).getR_id());
				if (checkinpeople == list1.get(i).getR_population()) {
					list1.remove(i);
					System.out.println(list1.size());
				}
			}
//			Iterator<AllRoomInfoPojo>iterator = list1.iterator();
//			while (iterator.hasNext()) {
//				int checkinpeople = RoomService.selCheckInPeople(iterator.next().getR_id());
//				if (checkinpeople == iterator.next().getR_population()) {
//					iterator.remove();
//				}
//			}

		}
		if (list1.isEmpty()) {
			result = "当前查询条件没有符合的记录";
		}
		map.put("currentpage", page);
		map.put("allpage", total);
		map.put("searchroom", list1);
		map.put("result", result);

		return map;
	}

	@RequestMapping("/singleroom")
	public Map<String, Object> findRoomByid(int roomid) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(roomid);
		AllRoomInfoPojo allRoomInfoPojo = RoomService.selRoomByid(roomid);
		int checkinpeople = RoomService.selCheckInPeople(roomid);
		allRoomInfoPojo.setCheckinpeople(checkinpeople);
		int handelNum = RoomService.selCountHandel(roomid);
		if (handelNum == 0) {
			RoomService.updateStateCorrect(roomid);
		}
		List<AllStudentPojo> list = StudentService.selCheckStuByRid(roomid);
		map.put("stu", list);
		map.put("singroom", allRoomInfoPojo);
		return map;
	}

	@RequestMapping("/checkinfomotai")
	public Map<String, Object> checkinfomotai() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassPojo> classPojosliList = ClassService.selAllClass();
		List<AllRoomInfoPojo> list = RoomService.selAllRoomCanLive();
		for (int i = 0; i < list.size(); i++) {
			int checkinpeople = RoomService.selCheckInPeople(list.get(i).getR_id());
			if (checkinpeople == list.get(i).getR_population()) {
				list.remove(i);
			}
		}

		map.put("listcanlive", list);
		map.put("classs", classPojosliList);
		return map;
	}

	@RequestMapping("/deleteroom")
	public Map<String, Object> deleteRoom(int rid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int handelNum = RoomService.selCountHandel(rid);
		if (handelNum == 0) {
			RoomService.updateStateCorrect(rid);
		}
		List<checkInPojo> checkInPojo = CheckInService.selCheckRoomByRid(rid);
		if (!checkInPojo.isEmpty()) {
			result = "该房间还有人住,不能删除";
			map.put("result", result);
			return map;
		} else {
			int row = RoomService.delRoomByid(rid);
			if (row > 0) {
				result = "删除成功";
				map.put("result", result);
				return map;
			}
		}

		map.put("result", result);
		return map;
	}

}
