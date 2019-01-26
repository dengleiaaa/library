package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.AllStudentPojo;

public interface StudentService {

	int insertStu(String sname, String ssex, String stel, int cid, String stuImgPath);

	int selSidByStel(String stel);

	List<AllStudentPojo> selAllStu(int spage);

	int selcountStu();

	AllStudentPojo selStuByid(int sid);

	int updateCheckFlagBysid(int sid);

	List<AllStudentPojo> selCheckStuByRid(int roomid);

	List<AllStudentPojo> searchStu(int page, String stuname, String stuclass, String sturoom);

	int selcountSearchStu(String stuname, String stuclass, String sturoom);

	AllStudentPojo selStuTel(String stel);
}
