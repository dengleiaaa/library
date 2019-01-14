package com.woniuxy.userservice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.woniuxy.interfacemapper.BookInterface;

import com.woniuxy.pojo.AllBookpojo;
import com.woniuxy.pojo.BorrowInfoPojo;
import com.woniuxy.pojo.BorrowPojo;
import com.woniuxy.utils.sqlSessionFactoryUtil;

public class BookService {
private BookInterface mapper;
	public List<AllBookpojo> selAllBook(int pages) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<AllBookpojo>list = mapper.selAllBook(pages);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;
	}
	public int selcount() {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int count = mapper.selcount();
		sqlSessionFactoryUtil.closeSqlsession();
		return count;
	}
	public List<AllBookpojo> selbookinfo(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<AllBookpojo>list = mapper.selbookinfo(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;
	}
	public List<AllBookpojo> selbooktype(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<AllBookpojo>list = mapper.selbooktype(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;
	}
	public int seltypecount(int type) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int count = mapper.seltypecount(type);
		sqlSessionFactoryUtil.closeSqlsession();
		return count;
		
	}
	public List<AllBookpojo> selbookdel(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<AllBookpojo>list = mapper.selbookdel(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;

	}
	public int updatadesc(Map<String, Object> descmap) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.updatadesc(descmap);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
		
	}
	public int updateauthor(Map<String, Object> authorcmap) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.updateauthor(authorcmap);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	
	public int selbooknum(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int num = mapper.selbooknum(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return num;
		
	}
	public int delbook(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.delbook(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	public BorrowPojo selborrow(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		BorrowPojo BorrowPojo = mapper.selborrow(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return BorrowPojo;
	}
	public int insertBorrow(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.insertBorrow(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	public List<BorrowInfoPojo> selbooIbfoByuid(int uid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<BorrowInfoPojo>list = mapper.selbooIbfoByuid(uid);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;
	}
	public int selbnum(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int bnum = mapper.selbnum(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return bnum;
	}
	public int updateBnum(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.updateBnum(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	public int delBorrowInfo(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.delBorrowInfo(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	public int addbook(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.addbook(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}
	public int addbooknum(int bid) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.addbooknum(bid);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}

	public List<AllBookpojo> serachbook(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		List<AllBookpojo>list = mapper.serachbook(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return list;
	}
	public int Serachcount(Map<String, Object> map) {
		SqlSession sqlsession = sqlSessionFactoryUtil.getSqlsession();
		mapper = sqlsession.getMapper(BookInterface.class);
		int row = mapper.Serachcount(map);
		sqlSessionFactoryUtil.closeSqlsession();
		return row;
	}


	
	

    
}
