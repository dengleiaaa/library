package com.woniuxy.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.RolePojo;
import com.woniuxy.pojo.UserPojo;
import com.woniuxy.pojo.UserRegistPojo;
import com.woniuxy.pojo.UserRolePojo;

public interface UserDao {
	@Select("select u_acc userAcc,u_pass userPass from user where u_acc=#{userAcc}")
	public UserPojo SelLogin(String userAcc);

	@Select("select u_acc userAcc from user where u_acc=#{userAcc}")
	public UserRegistPojo register(UserRegistPojo userPojo);

	@Insert("insert into user(u_acc,u_pass) values(#{userAcc},#{userPass})")
	public int insertUser(UserRegistPojo userPojo);

	@Select("select u_id from user where u_acc=#{arg0}")
	public int selUid(String uacc);

	@Select("select r_role from userper where u_id=#{arg0}")
	public Set<String> selRole(int uid);

	@Select("select p_permission from userper where u_id=#{arg0}")
	public Set<String> selPermission(int uid);

	@Insert("insert into authority(ua_uid,ua_rid) values(#{arg1},#{arg0})")
	public int insertRole(int i, int uid);

	@Select("select * from userper")
	public List<UserRolePojo> selAllUserRole();
	
	@Select("select * from role")
	public List<RolePojo> selAllRole();

	@Update("update authority set ua_rid=#{arg1} where ua_uid=#{arg0}")
	public int ChangeRole(int uid, int roleid);
}
