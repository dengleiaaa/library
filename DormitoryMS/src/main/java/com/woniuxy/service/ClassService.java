package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.pojo.ClassPojo;
import com.woniuxy.pojo.TeacherPojo;
import com.woniuxy.pojo.classTeaPojo;

public interface ClassService {
	public String addClass(String name, String time);

	public int FindCidByCname(String cname);

	public List<ClassPojo> selAllClass();

	public List<classTeaPojo> selAllClass(int cpage);

	public int selcountNum();

	public List<AllStudentPojo> selStuByCid(int cid);

	public List<TeacherPojo> selAllTea();

}
