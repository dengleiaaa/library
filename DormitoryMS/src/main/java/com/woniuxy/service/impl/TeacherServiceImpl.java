package com.woniuxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.TeacherDao;
import com.woniuxy.pojo.TeacherPojo;
import com.woniuxy.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao TeacherDao;

	@Transactional
	@Override
	public int findTeaByName(String tea) {
		int row = 0;
		TeacherPojo TeacherPojo = TeacherDao.FindTeaByName(tea);
		if (TeacherPojo != null) {
			row = 1;
			return row;
		}
		return row;
	}

	@Transactional
	@Override
	public int InsertTcid(String tname, int cid) {
		int row = TeacherDao.InsertCidByTname(tname, cid);
		return row;
	}

}
