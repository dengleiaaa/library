package com.woniuxy.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.TeacherPojo;

public interface TeacherDao {

	@Select("select * from teacher where t_name=#{tea}")
	TeacherPojo FindTeaByName(String tea);

	@Update("update teacher set t_cid=#{arg1} where t_name=#{arg0}")
	int InsertCidByTname(String tname, int cid);

	

}
