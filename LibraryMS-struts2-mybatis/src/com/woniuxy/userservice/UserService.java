package com.woniuxy.userservice;

import org.apache.ibatis.session.SqlSession;
import com.woniuxy.interfacemapper.UserInterface;
import com.woniuxy.pojo.regiestUserVo;
import com.woniuxy.pojo.userVo;
import com.woniuxy.utils.sqlSessionFactoryUtil;

public class UserService implements UserInterface {
	private UserInterface mapper;

	public userVo loginmapper(userVo userVo) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(UserInterface.class);
		userVo uVo = mapper.loginmapper(userVo);
		sqlSessionFactoryUtil.closeSqlsession();
		return uVo;
	}

	@Override
	public regiestUserVo regiestmapper(regiestUserVo regiestUserVo) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(UserInterface.class);
		regiestUserVo regiestUserVo2 = mapper.regiestmapper(regiestUserVo);
		sqlSessionFactoryUtil.closeSqlsession();
		return regiestUserVo2;
	}

	@Override
	public int insertUser(regiestUserVo regiestUserVo) {
		int row = 0;
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(UserInterface.class);
		row = mapper.insertUser(regiestUserVo);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}

	public int selidByAcc(String username) {
		
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(UserInterface.class);
		int uid = mapper.selidByAcc(username);
		sqlSessionFactoryUtil.closeSqlsession();
		return uid;
	}

}
