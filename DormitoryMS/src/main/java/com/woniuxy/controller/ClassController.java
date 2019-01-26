package com.woniuxy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.pojo.TeacherPojo;
import com.woniuxy.pojo.classTeaPojo;
import com.woniuxy.service.ClassService;
import com.woniuxy.service.TeacherService;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService ClassService;
	@Autowired
	private TeacherService TeacherService;

	@RequestMapping("/addclass")
	public Map<String, Object> addClass(String name, String tea, String time) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = "";
		int row = TeacherService.findTeaByName(tea);
		if (row == 1) {
			result = ClassService.addClass(name, time);
		} else {
			result = "没有这个老师";
			map.put("result", result);
			return map;
		}
		if (result.equals("添加成功")) {
			int cid = ClassService.FindCidByCname(name);
			int tearow = TeacherService.InsertTcid(tea, cid);
			if (tearow > 0) {
				result = "添加成功";
				map.put("result", result);
				return map;
			}
		}

		result = "添加失败";
		map.put("result", result);
		return map;

	}

	@RequestMapping("/allclass")
	public Map<String, Object> allClass(int cpage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<classTeaPojo> list = ClassService.selAllClass(cpage);
		int total = ClassService.selcountNum();

		map.put("allclass", list);
		map.put("allpage", total);
		map.put("currentpage", cpage);

		return map;
	}

	@RequestMapping("/deleteclass")
	public Map<String, Object> deleteClass(int cid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		List<AllStudentPojo> list = ClassService.selStuByCid(cid);
		if (!list.isEmpty()) {
			result = "该班级还有学生,不能删除";
			map.put("result", result);
			return map;
		} else {
			result = "删除成功";
			map.put("result", result);
			return map;
		}

	}

	@RequestMapping("/addclassmotai")
	public Map<String, Object> addclassMotai() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<TeacherPojo>list = ClassService.selAllTea();
		
		map.put("tea", list);
		
		
		return map;
	}
}
