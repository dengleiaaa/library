package com.woniuxy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.pojo.AllRoomInfoPojo;
import com.woniuxy.pojo.AllStudentPojo;
import com.woniuxy.service.CheckInService;
import com.woniuxy.service.ClassService;
import com.woniuxy.service.RoomService;
import com.woniuxy.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {
	@Autowired
	private ClassService ClassService;
	@Autowired
	private StudentService StudentService;
	@Autowired
	private CheckInService CheckInService;
	@Autowired
	private RoomService RoomService;

	@RequestMapping("/addcheckinfo")
	public Map<String, Object> addCheckInfo(HttpServletRequest request, MultipartFile file, String sname, String ssex, String sclass,
			String stel, String sroom, String sdate) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if (file==null) {
			result = "请选择您的头像";
			map.put("result", result);
			return map;
		}
		
		AllStudentPojo allStudentPojo = StudentService.selStuTel(stel);
		if (allStudentPojo!=null) {
			result = "手机号已使用,请更换";
			map.put("result", result);
			return map;
		}
		String uuid = UUID.randomUUID().toString().trim();
		String fileN = file.getOriginalFilename();
		int index = fileN.indexOf(".");
		String fileName = uuid + fileN.substring(index);
		try {
			File fileMkdir = new File("D:\\imooc\\images");
			if (!fileMkdir.exists()) {
				fileMkdir.mkdir();
			}
			// 定义输出流 将文件保存在D盘 file.getOriginalFilename()为获得文件的名字
			FileOutputStream os = new FileOutputStream(fileMkdir.getPath() + "\\" + fileName);
			InputStream in = file.getInputStream();
			int b = 0;
			while ((b = in.read()) != -1) { // 读取文件
				os.write(b);
			}
			os.flush(); // 关闭流
			in.close();
			os.close();
		} catch (Exception e) {
			result = "上传头像失败";
			map.put("result", result);
			return map;
		}
		String stuImgPath = "/imgUrl/" + fileName;
		System.out.println(stuImgPath);
		int cid = ClassService.FindCidByCname(sclass);
		int row = StudentService.insertStu(sname, ssex, stel, cid, stuImgPath);
		if (row > 0) {
			int sid = StudentService.selSidByStel(stel);
			int roomid = RoomService.selridByrname(sroom);
			int checkpeople = RoomService.selCheckInPeople(roomid);
			int canlivepeople = RoomService.selrpopulationByrid(roomid);
			if (checkpeople == canlivepeople) {
				map.clear();
				result = "该房间人数已满,请选择其他房间";
				map.put("result", result);
				return map;
			}
			int checkRow = CheckInService.insertCheckinfo(sid, roomid, sdate);
			if (checkRow > 0) {
				map.clear();
				result = "添加成功";
				map.put("result", result);
				return map;
			}
		}
		return map;
	}

	@RequestMapping("/allstu")
	public Map<String, Object> allStu(int spage) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AllStudentPojo> list = StudentService.selAllStu(spage);
		int total = StudentService.selcountStu();

		map.put("allstu", list);
		map.put("allpage", total);
		map.put("currentpage", spage);

		return map;
	}

	@RequestMapping("/stuinfo")
	public Map<String, Object> studentinfo(int sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(sid);
		AllStudentPojo allStudentPojo = StudentService.selStuByid(sid);
		map.put("stuinfo", allStudentPojo);
		return map;
	}

	@RequestMapping("/stucheckout")
	public Map<String, Object> checkOut(int sid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int row = StudentService.updateCheckFlagBysid(sid);
		if (row > 0) {
			result = "退房成功";
		}
		map.put("result", result);
		return map;
	}

	@RequestMapping("/searchstu")
	public Map<String, Object> searchStudent(int page, String stuname, String stuclass, String sturoom) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(page + stuname + stuclass + sturoom);
		List<AllStudentPojo> list = StudentService.searchStu(page, stuname, stuclass, sturoom);
		int total = StudentService.selcountSearchStu(stuname, stuclass, sturoom);
		if (list.isEmpty()) {
			result = "当前查询条件没有符合的记录";
		}
		map.put("allstu", list);
		map.put("allpage", total);
		map.put("currentpage", page);
		map.put("result", result);
		return map;
	}

	@RequestMapping("/changeroommotai")
	public Map<String, Object> changeRoomMt(int sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		AllStudentPojo allStudentPojo = StudentService.selStuByid(sid);
		List<AllRoomInfoPojo> list = RoomService.selAllRoomCanLive();
		for (int i = 0; i < list.size(); i++) {
			int checkinpeople = RoomService.selCheckInPeople(list.get(i).getR_id());
			if (checkinpeople == list.get(i).getR_population()) {
				list.remove(i);

			}

		}
		map.put("allstu", allStudentPojo);
		map.put("listcanlive", list);

		return map;
	}
	
	@RequestMapping("/changeroom")
	public Map<String, Object> changeroom(int sid,int rid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int row  = CheckInService.changeRoomBySid(sid,rid);
		if (row > 0) {
		result = "换房成功";	
		}
		map.put("result", result);
		return map;
	}

}
