package com.woniuxy.interfacemapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.AllBookpojo;
import com.woniuxy.pojo.BorrowInfoPojo;
import com.woniuxy.pojo.BorrowPojo;

public interface BookInterface {
     
	
	@Select("select * from book_type limit #{pages},8")  
	public List<AllBookpojo> selAllBook(int pages);

	@Select("select COUNT(bid) count  from book")
	public int selcount();
	
	@Select("select * from book_type where bid=#{bid}")
	public List<AllBookpojo> selbookinfo(int bid);

	@Select("select * from book_type where tid=#{type} limit #{pages},8")
	public List<AllBookpojo> selbooktype(Map<String, Object> map);

	@Select("select COUNT(btype) c  from book where btype=#{type}")
	public int seltypecount(int type);

	@Select("select * from book_type where bid=#{bid}") 
	public List<AllBookpojo> selbookdel(int bid);

	@Update("update book set bdesc=#{desc} where bid=#{bid}")
	public int updatadesc(Map<String, Object> descmap);

	@Update("update book set bauthor=#{author} where bid=#{bid}")
	public int updateauthor(Map<String, Object> authorcmap);

	@Select("select bnum from book where bid=#{bid}") 
	public int selbooknum(int bid);

	@Delete("delete from book where bid=#{bid}")
	public int delbook(int bid);

	@Select("select * from borrow where borbid=#{bid} and boruid=#{uid}") 
	public BorrowPojo selborrow(Map<String, Object> map);

	@Insert("insert into borrow(borid,boruid,borbid) values(#{bNum},#{uid},#{bid})")
	public int insertBorrow(Map<String, Object> map);

	@Select("select * from boorow_info where boruid=#{uid}") 
	public List<BorrowInfoPojo> selbooIbfoByuid(int uid);

	@Select("select bnum from book where bid=#{bid}")
	public int selbnum(int bid);

	@Update("update book set bnum=#{booknum} where bid=#{bid}")
	public int updateBnum(Map<String, Object> map);

	@Delete("delete from borrow where borbid=#{bid} and boruid=#{uid}")
	public int delBorrowInfo(Map<String, Object> map);

	@Insert("insert into book(bname,bauthor,bdesc,bprice,bpress,bpdate,bnum,btype) values(#{q},#{w},#{e},#{r},#{t},#{y},#{u},#{i})")
	public int addbook(Map<String, Object> map);

	@Update("update book set bnum=bnum+1 where bid=#{bid}")
	public int addbooknum(int bid);

	@Select("select * from book_type where bname like '%${serachbook}%' or bauthor like '%${serachbook}%' limit #{pages},8")
	public List<AllBookpojo> serachbook(Map<String, Object> map);

	@Select("select COUNT(bauthor like '%${serachbook}%' or bname like '%${serachbook}%') from book_type where bauthor like '%${serachbook}%' or bname like '%${serachbook}%'")
	public int Serachcount(Map<String, Object> map);

}
