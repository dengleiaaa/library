package com.woniuxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.ClassDao;
import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.pojo.ClassPojo;
import com.woniuxy.pojo.TeacherPojo;
import com.woniuxy.pojo.classTeaPojo;
import com.woniuxy.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao ClassDao;

	@Transactional
	@Override
	public String addClass(String name, String time) {
		String result = "添加失败";
		int row = ClassDao.InsertClass(name, time);
		if (row > 0) {
			result = "添加成功";
		}
		return result;
	}

	@Transactional
	@Override
	public int FindCidByCname(String cname) {
		int cid = ClassDao.SelCid(cname);
		return cid;
	}

	@Transactional
	@Override
	public List<ClassPojo> selAllClass() {
		List<ClassPojo> list = ClassDao.selAllclass();
		return list;
	}

	@Transactional
	@Override
	public List<classTeaPojo> selAllClass(int cpage) {
		List<classTeaPojo> abklist = new ArrayList<>();
		int pages = (cpage * 5 - 5);
		abklist = ClassDao.selAllClass(pages);
		return abklist;
	}

	@Transactional
	@Override
	public int selcountNum() {
		int total = ClassDao.selcountNum();
		if (total % 5 == 0) {
			total = total / 5;
		} else {
			total = total / 5 + 1;
		}
		return total;
	}

	@Transactional
	@Override
	public List<AllStudentPojo> selStuByCid(int cid) {
		List<AllStudentPojo> list = ClassDao.selStu(cid);
		return list;
	}

	@Transactional
	@Override
	public List<TeacherPojo> selAllTea() {
		List<TeacherPojo> list = ClassDao.selAllTea();
		return list;
	}

}
