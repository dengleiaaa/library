package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.LandLordDao;
import com.woniuxy.pojo.LandlordPojo;
import com.woniuxy.service.LandLordService;

@Service
public class LandLordServiceImpl implements LandLordService {
	@Autowired
	private LandLordDao LandLordDao;

	@Transactional
	@Override
	public String addLandlord(LandlordPojo landlordPojo) {
		String result = "添加失败";
		if (landlordPojo.getL_name() == null || landlordPojo.getL_name() == "" || landlordPojo.getL_tel() == null
				|| landlordPojo.getL_tel() == "") {
			return result;
		}
		int row = LandLordDao.InsertLandlord(landlordPojo);
		if (row > 0) {
			result = "添加成功";
			return result;
		}
		return result;
	}

	@Transactional
	@Override
	public int selLidByLname(LandlordPojo landlordPojo) {
		int lid = LandLordDao.selLid(landlordPojo);
		return lid;
	}

	@Transactional
	@Override
	public List<LandlordPojo> selTel(LandlordPojo landlordPojo) {
		List<LandlordPojo> landlordPojo1 = LandLordDao.selTel(landlordPojo);
		return landlordPojo1;
	}

}
