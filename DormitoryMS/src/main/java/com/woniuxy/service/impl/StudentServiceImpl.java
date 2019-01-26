package com.woniuxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.StudentDao;
import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao StudentDao;

	@Transactional
	@Override
	public int insertStu(String sname, String ssex, String stel, int cid, String stuImgPath) {
		int row = StudentDao.insertStu(sname, ssex, stel, cid, stuImgPath);
		return row;
	}

	@Transactional
	@Override
	public int selSidByStel(String stel) {
		int sid = StudentDao.selSidByTel(stel);
		return sid;
	}

	@Transactional
	@Override
	public List<AllStudentPojo> selAllStu(int spage) {
		List<AllStudentPojo> abklist = new ArrayList<>();
		int pages = (spage * 5 - 5);
		abklist = StudentDao.AllStu(pages);
		return abklist;
	}

	@Transactional
	@Override
	public int selcountStu() {
		int total = StudentDao.selcountStu();
		if (total % 5 == 0) {
			total = total / 5;
		} else {
			total = total / 5 + 1;
		}
		return total;
	}

	@Transactional
	@Override
	public AllStudentPojo selStuByid(int sid) {
		AllStudentPojo allStudentPojo = StudentDao.selStuBySid(sid);
		return allStudentPojo;
	}

	@Transactional
	@Override
	public int updateCheckFlagBysid(int sid) {
		int row = StudentDao.updateFlag(sid);
		return row;
	}

	@Transactional
	@Override
	public List<AllStudentPojo> selCheckStuByRid(int roomid) {
		List<AllStudentPojo> list = StudentDao.selStuByRid(roomid);
		return list;
	}

	@Transactional
	@Override
	public List<AllStudentPojo> searchStu(int page, String stuname, String stuclass, String sturoom) {
		List<AllStudentPojo> abklist = new ArrayList<>();
		int pages = (page * 5 - 5);
		abklist = StudentDao.searchStu(pages,stuname,stuclass,sturoom);
		return abklist;
	}

	@Transactional
	@Override
	public int selcountSearchStu(String stuname, String stuclass, String sturoom) {
		int total = StudentDao.selCountSearchStu(stuname,stuclass,sturoom);
		if (total % 5 == 0) {
			total = total / 5;
		} else {
			total = total / 5 + 1;
		}
		return total;
	}

	@Override
	public AllStudentPojo selStuTel(String stel) {
		AllStudentPojo studentPojo = StudentDao.selTel(stel);
		return studentPojo;
	}

}
