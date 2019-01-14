package com.woniuxy.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.pojo.AllBookpojo;
import com.woniuxy.pojo.BorrowInfoPojo;
import com.woniuxy.pojo.BorrowPojo;
import com.woniuxy.userservice.BookService;
import com.woniuxy.userservice.UserService;

public class BookAction extends ActionSupport {
	private List<AllBookpojo> abklist;
	private List<BorrowInfoPojo> bInfoPojos;

	public List<BorrowInfoPojo> getbInfoPojos() {
		return bInfoPojos;
	}

	public void setbInfoPojos(List<BorrowInfoPojo> bInfoPojos) {
		this.bInfoPojos = bInfoPojos;
	}

	private String page;
	BookService bookService = new BookService();
	UserService userService = new UserService();
	private String countpage;
	private int bid;
	private String desc;
	private String author;
	private String result;
	private String serachbook;

	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	private String w;
	private String e;
	private double r;
	private String t;
	private String y;
	private int u;
	private int i;

	public String getSerachbook() {
		return serachbook;
	}

	public void setSerachbook(String serachbook) {
		this.serachbook = serachbook;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getCountpage() {
		return countpage;
	}

	public void setCountpage(String countpage) {
		this.countpage = countpage;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<AllBookpojo> getAbklit() {
		return abklist;
	}

	public void setAbklit(List<AllBookpojo> abklist) {
		this.abklist = abklist;
	}

	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String allbook() {
		int pages = (Integer.parseInt(page) * 8 - 8);
		abklist = bookService.selAllBook(pages);
		int total = bookService.selcount();
		if (total % 8 == 0) {
			total = total / 8;
		} else {
			total = total / 8 + 1;
		}
		countpage = total + "";
		return "success";
	}

	public String bookinfo() {
		abklist = bookService.selbookinfo(bid);
		return "success";
	}

	public String booktype() {
		int pages = (Integer.parseInt(page) * 8 - 8);
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("pages", pages);
		abklist = bookService.selbooktype(map);

		int total = bookService.seltypecount(type);
		if (total % 8 == 0) {
			total = total / 8;
		} else {
			total = total / 8 + 1;
		}
		countpage = total + "";
		return "success";
	}

	public String alterinfo() {
		abklist = bookService.selbookdel(bid);
		return "success";
	}

	public String alterbook() {
		System.out.println(bid + desc + author);
		if (desc == null && author == null) {
			result = "输入不正确";
			return "failed";
		}
		if (desc == "" && author == "") {
			result = "输入不正确";
			return "failed";
		}
		if (desc != null && desc != "") {
			Map<String, Object> descmap = new HashMap<>();
			descmap.put("bid", bid);
			descmap.put("desc", desc);
			int row = bookService.updatadesc(descmap);
			if (row > 0) {
				result = "修改成功";
			}
		}

		if (author != null && author != "") {
			Map<String, Object> authorcmap = new HashMap<>();
			authorcmap.put("bid", bid);
			authorcmap.put("author", author);
			int row = bookService.updateauthor(authorcmap);
			if (row > 0) {
				result = "修改成功";
			}
		}
		return "success";
	}

	public String delbook() {
		System.out.println(bid);
		int num = bookService.selbooknum(bid);
		if (num >= 0) {
			int row = bookService.delbook(bid);
			if (row > 0) {
				result = "删除成功";
			} else {
				result = "删除失败";
			}
		} else {
			result = "删除失败";
		}
		return "success";
	}

	public String borrow() {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (username == null) {
			result = "请登陆后在操作";
			return "success";
		}
		int uid = userService.selidByAcc(username);
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("uid", uid);
		BorrowPojo borrowPojos = bookService.selborrow(map);
		int booknum = bookService.selbnum(bid);
		if (booknum == 0) {
			result = "该书已借完";
			return "success";
		}
		if (borrowPojos == null) {
			String d = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
			String bNum = d + uid + "";
			map.put("bNum", bNum);
			int row = bookService.insertBorrow(map);
			map.put("bid", bid);
			map.put("booknum", booknum - 1);

			int row1 = bookService.updateBnum(map);
			if (row > 0 && row1 > 0) {
				result = "借阅成功";
			}
		} else {
			result = "您已经借阅过本书,请归还后再借阅";
		}
		return "success";
	}

	public String borrowinfo() {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println(username);
		if (username == null) {
			result = "请登陆后在操作";
			return "success";
		}
		int uid = userService.selidByAcc(username);
		System.out.println(username);
		bInfoPojos = bookService.selbooIbfoByuid(uid);
		if (bInfoPojos.isEmpty()) {
			result = "您还没有借阅书籍";
			return "success";
		}

		System.out.println(bInfoPojos);
		return "success";
	}

	public String returnbook() {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
		int uid = userService.selidByAcc(username);
		Map<String, Object> map = new HashMap<>();
		map.put("bid", bid);
		map.put("uid", uid);

		int row = bookService.delBorrowInfo(map);
		int row2 = bookService.addbooknum(bid);
		if (row > 0 && row2 > 0) {
			result = "还书成功";
			return "success";
		}
		return "success";
	}

	public String addbook() {
		if (q == null || q == "" || w == null || w == "" || e == null || e == "" || r == 0.0 || r <= 0 || t == null
				|| t == "" || y == null || y == "" && u <= 0 || i <= 0) {
			result = "格式不正确";
			return "success";
		}
//		if (i!=1 || i!=2|| i!=3|| i!=4) {
//			result = "图书类型不正确";
//			return "success";
//		}
		Map<String, Object> map = new HashMap<>();
		map.put("q", q);
		map.put("w", w);
		map.put("e", e);
		map.put("r", r);
		map.put("t", t);
		map.put("y", y);
		map.put("u", u);
		map.put("i", i);
		int row = bookService.addbook(map);
		if (row > 0) {
			result = "新增成功";
		}
		return "success";
	}

	public String serachbook() {
		if (serachbook == null || serachbook == "") {
			result = "请输入查询条件";
			return "success";
		}
		int pages = (Integer.parseInt(page) * 8 - 8);
		Map<String, Object> map = new HashMap<>();
		map.put("serachbook", serachbook);
		map.put("pages", pages);
		abklist = bookService.serachbook(map);
		if (abklist.isEmpty()) {
			result = "没找到";
			return "success";
		}
		int total = bookService.Serachcount(map);
		if (total % 8 == 0) {
			total = total / 8;
		} else {
			total = total / 8 + 1;
		}
		countpage = total + "";
//		if (abklist.isEmpty()) {
//			if (bookService.serachbookByName(map).isEmpty()) {
//
//			} else {
//				abklist = bookService.serachbookByName(map);
//
//				return "success";
//			}
//		} else {
//			if (bookService.serachbookByName(map).isEmpty()) {
//				return "success";
//			} else {
//				abklist.addAll(bookService.serachbookByName(map));
//
//			}
//		}

		return "success";

	}

}
