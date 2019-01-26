package com.woniuxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.pojo.RoomToolPojo;
import com.woniuxy.service.RoomService;
import com.woniuxy.service.RoomToolService;

@RestController
@RequestMapping("/roomtool")
public class RoomToolController {
	@Autowired
	private RoomToolService RoomToolService;
	@Autowired
	private RoomService RoomService;

	@RequestMapping("/addtool")
	public Map<String, Object> addtool(int rid, String tooldate, String tooldesc) {
		String result = "";
		String solve = "未处理";
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(rid + tooldate + tooldesc);
		if (tooldate == null || tooldate == "" || tooldesc == null || tooldesc == "") {
			result = "请输入后在提交";
			map.put("result", result);
			return map;
		}
		int row = RoomToolService.insertRoomTool(tooldesc, tooldate, rid, solve);
		if (row > 0) {
			int row1 = RoomService.updateStateById(rid);
			if (row1>0) {
				result = "添加成功";
				map.put("result", result);
				return map;
			}
		}
		return map;
	}
	@RequestMapping("/roomtoolmotai")
	public Map<String, Object> roomToolMotai(int rid) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<RoomToolPojo>list = RoomToolService.selRoomtoolByid(rid);
		map.put("roomtool", list);
		return map;
		
		
	}
	@RequestMapping("/handletool")
	public Map<String, Object> handletool(int rid,int rtid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int handelNum = RoomService.selCountHandel(rid);
		if (handelNum==0) {
			RoomService.updateStateCorrect(rid);
		}
		int row = RoomToolService.updateSolveByRtid(rtid);
		if (row>0) {
			int handelNu = RoomService.selCountHandel(rid);
			if (handelNu==0) {
				RoomService.updateStateCorrect(rid);
			}
			result = "处理成功";
			map.put("result", result);
			return map;
			
		}
		return map;
		
		
	}
}
