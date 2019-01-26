package com.woniuxy.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserDao;
import com.woniuxy.pojo.RolePojo;
import com.woniuxy.pojo.UserPojo;
import com.woniuxy.pojo.UserRegistPojo;
import com.woniuxy.pojo.UserRolePojo;
import com.woniuxy.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao UserDao;

	@Transactional
	@Override
	public UserPojo Login(String userAcc) {
		UserPojo userPojo = UserDao.SelLogin(userAcc);
		return userPojo;
	}

	@Transactional
	@Override
	public UserRegistPojo register(UserRegistPojo userPojo) {
		UserRegistPojo userRegistPojo = UserDao.register(userPojo);
		return userRegistPojo;

	}

	@Transactional
	@Override
	public int insertUser(UserRegistPojo userPojo) {
		int row = UserDao.insertUser(userPojo);
		return row;
	}

	@Transactional
	@Override
	public int selUidByUacc(String Uacc) {
		int uid = UserDao.selUid(Uacc);
		return uid;
	}

	@Transactional
	@Override
	public Set<String> selRoleByuid(int uid) {
		Set<String> roleset = UserDao.selRole(uid);
		return roleset;
	}

	@Transactional
	@Override
	public Set<String> selPerssiomByuid(int uid) {
		Set<String> permissionset = UserDao.selPermission(uid);
		return permissionset;
	}

	@Transactional
	@Override
	public int insertRole(int i, int uid) {
		int row = UserDao.insertRole(i, uid);
		return row;
	}

	@Transactional
	public List<UserRolePojo> selUserRole() {
		List<UserRolePojo> list = UserDao.selAllUserRole();
		return list;
	}

	@Transactional
	@Override
	public List<RolePojo> selAllRole() {
		List<RolePojo> list = UserDao.selAllRole();
		return list;
	}

	@Transactional
	@Override
	public int changeRoleByUid(int uid, int roleid) {
		int row = UserDao.ChangeRole(uid, roleid);
		return row;
	}

}
