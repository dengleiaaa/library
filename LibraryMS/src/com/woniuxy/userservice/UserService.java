package com.woniuxy.userservice;

import com.woniuxy.interfacemapper.UserInterface;
import com.woniuxy.pojo.regiestUserVo;
import com.woniuxy.pojo.userVo;

public class UserService implements UserInterface {
	private UserInterface mapper;

	public UserInterface getMapper() {
		return mapper;
	}

	public void setMapper(UserInterface mapper) {
		this.mapper = mapper;
	}

	public userVo loginmapper(userVo userVo) {
		userVo uVo = mapper.loginmapper(userVo);
		return uVo;
	}

	@Override
	public regiestUserVo regiestmapper(regiestUserVo regiestUserVo) {
		regiestUserVo regiestUserVo2 = mapper.regiestmapper(regiestUserVo);
		return regiestUserVo2;
	}

	@Override
	public int insertUser(regiestUserVo regiestUserVo) {
		int row = mapper.insertUser(regiestUserVo);
		return row;
	}

	public int selidByAcc(String username) {
		int uid = mapper.selidByAcc(username);
		return uid;
	}

}
