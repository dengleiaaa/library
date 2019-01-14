package com.woniuxy.userservice;

import java.util.List;
import java.util.Map;

import com.woniuxy.interfacemapper.BookInterface;

import com.woniuxy.pojo.AllBookpojo;
import com.woniuxy.pojo.BorrowInfoPojo;
import com.woniuxy.pojo.BorrowPojo;

public class BookService implements BookInterface {
	private BookInterface mapper;

	public BookInterface getMapper() {
		return mapper;
	}

	public void setMapper(BookInterface mapper) {
		this.mapper = mapper;
	}

	public List<AllBookpojo> selAllBook(int pages) {
		List<AllBookpojo> list = mapper.selAllBook(pages);
		return list;
	}

	public int selcount() {
		int count = mapper.selcount();
		return count;
	}

	public List<AllBookpojo> selbookinfo(int bid) {
		List<AllBookpojo> list = mapper.selbookinfo(bid);
		return list;
	}

	public List<AllBookpojo> selbooktype(Map<String, Object> map) {
		List<AllBookpojo> list = mapper.selbooktype(map);
		return list;
	}

	public int seltypecount(int type) {
		int count = mapper.seltypecount(type);
		return count;
	}

	public List<AllBookpojo> selbookdel(int bid) {
		List<AllBookpojo> list = mapper.selbookdel(bid);
		return list;
	}

	public int updatadesc(Map<String, Object> descmap) {
		int row = mapper.updatadesc(descmap);
		return row;
	}

	public int updateauthor(Map<String, Object> authorcmap) {
		int row = mapper.updateauthor(authorcmap);
		return row;
	}

	public int selbooknum(int bid) {
		int num = mapper.selbooknum(bid);
		return num;
	}

	public int delbook(int bid) {
		int row = mapper.delbook(bid);
		return row;
	}

	public BorrowPojo selborrow(Map<String, Object> map) {
		BorrowPojo BorrowPojo = mapper.selborrow(map);
		return BorrowPojo;
	}

	public int insertBorrow(Map<String, Object> map) {
		int row = mapper.insertBorrow(map);
		return row;
	}

	public List<BorrowInfoPojo> selbooIbfoByuid(int uid) {
		List<BorrowInfoPojo> list = mapper.selbooIbfoByuid(uid);
		return list;
	}

	public int selbnum(int bid) {
		int bnum = mapper.selbnum(bid);
		return bnum;
	}

	public int updateBnum(Map<String, Object> map) {
		int row = mapper.updateBnum(map);
		return row;
	}

	public int delBorrowInfo(Map<String, Object> map) {
		int row = mapper.delBorrowInfo(map);
		return row;
	}

	public int addbook(Map<String, Object> map) {
		int row = mapper.addbook(map);
		return row;
	}

	public int addbooknum(int bid) {
		int row = mapper.addbooknum(bid);
		return row;
	}

	public List<AllBookpojo> serachbook(Map<String, Object> map) {
		List<AllBookpojo> list = mapper.serachbook(map);
		return list;
	}

	public int Serachcount(Map<String, Object> map) {
		int row = mapper.Serachcount(map);
		return row;
	}

}
