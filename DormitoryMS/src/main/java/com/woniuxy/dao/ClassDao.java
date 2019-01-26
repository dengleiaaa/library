package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.pojo.ClassPojo;
import com.woniuxy.pojo.TeacherPojo;
import com.woniuxy.pojo.classTeaPojo;

public interface ClassDao {

	@Insert("insert into classes(c_name,c_opentime) values(#{arg0},#{arg1})")
	int InsertClass(String name, String time);

	@Select("select c_id from classes where c_name=#{cname}")
	int SelCid(String cname);

	@Select("select c_id cid,c_name cname,c_opentime openTime,flag flag from classes")
	List<ClassPojo> selAllclass();

	@Select("select * from classtea limit #{arg0},5")
	List<classTeaPojo> selAllClass(int pages);

	@Select("select COUNT(c_id) count from classtea")
	int selcountNum();

	@Select("select * from student where s_cid=#{arg0} and flag=0")
	List<AllStudentPojo> selStu(int cid);

	@Select("select t_id tid,t_name tname,t_cid tcid,flag from teacher")
	List<TeacherPojo> selAllTea();

}
