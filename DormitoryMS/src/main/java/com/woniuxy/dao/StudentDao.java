package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.AllStudentPojo;

public interface StudentDao {


	@Insert("insert student(s_name,s_sex,s_tel,s_img,s_cid) values(#{arg0},#{arg1},#{arg2},#{arg4},#{arg3})")
	int insertStu(String sname, String ssex, String stel, int cid, String stuImgPath);

	@Select("select s_id from student where s_tel=#{arg0}")
	int selSidByTel(String stel);

	@Select("select * from studentinfo where flag=0 limit #{arg0},5")
	List<AllStudentPojo> AllStu(int pages);

	@Select("select COUNT(s_id) from studentinfo where flag=0")
	int selcountStu();

	@Select("select * from studentinfo where s_id=#{arg0}")
	AllStudentPojo selStuBySid(int sid);

	@Update("update checkin set flag=1 where ck_sid=#{arg0}")
	int updateFlag(int sid);

	@Select("select * from studentinfo where r_id=#{arg0} and flag=0")
	List<AllStudentPojo> selStuByRid(int roomid);

	@Select("select * from studentinfo where s_name like '%${arg1}%' and c_name like '%${arg2}%' and r_address like '%${arg3}%' and flag=0 limit #{arg0},5")
	List<AllStudentPojo> searchStu(int pages, String stuname, String stuclass, String sturoom);

	@Select("select COUNT(s_name like '%${arg0}%' and c_name like '%${arg1}%' and r_address like '%${arg2}%' and flag=0 ) from studentinfo where s_name like '%${arg0}%' and c_name like '%${arg1}%' and r_address like '%${arg2}%' and flag=0 ")
	int selCountSearchStu(String stuname, String stuclass, String sturoom);

	@Select("select * from studentinfo where s_tel=#{arg0}")
	AllStudentPojo selTel(String stel);

	

}
