package com.woniuxy.service;

import java.util.List;
import java.util.Set;

import com.woniuxy.pojo.RolePojo;
import com.woniuxy.pojo.UserPojo;
import com.woniuxy.pojo.UserRegistPojo;
import com.woniuxy.pojo.UserRolePojo;

public interface UserService{
	public UserPojo Login(String userAcc);

	public UserRegistPojo register(UserRegistPojo userPojo);

	public int insertUser(UserRegistPojo userPojo);

	public int selUidByUacc(String string);

	public Set<String> selRoleByuid(int uid);

	public Set<String> selPerssiomByuid(int uid);

	public int insertRole(int i, int uid);

	public List<UserRolePojo> selUserRole();

	public List<RolePojo> selAllRole();

	public int changeRoleByUid(int uid, int roleid);
}
