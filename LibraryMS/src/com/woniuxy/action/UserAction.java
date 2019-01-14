package com.woniuxy.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.interfacemapper.UserInterface;
import com.woniuxy.pojo.regiestUserVo;
import com.woniuxy.pojo.userVo;

public class UserAction extends ActionSupport {
	private UserInterface userService;
	private userVo userVo = new userVo();
	private regiestUserVo regiestUserVo = new regiestUserVo();
	private String results;
	private String username;
	private String password;
	private String acc;
	private String pass;
	private String passtwo;
	HttpSession session = ServletActionContext.getRequest().getSession();

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPasstwo() {
		return passtwo;
	}

	public void setPasstwo(String passtwo) {
		this.passtwo = passtwo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(UserInterface userService) {
		this.userService = userService;
	}

	public userVo getUserVo() {
		return userVo;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public void setUserVo(userVo userVo) {
		this.userVo = userVo;
	}

	public regiestUserVo getRegiestUserVo() {
		return regiestUserVo;
	}

	public void setRegiestUserVo(regiestUserVo regiestUserVo) {
		this.regiestUserVo = regiestUserVo;
	}

	public String login() {
		userVo.setUsername(username);
		userVo.setPassword(password);

		userVo uVos = userService.loginmapper(userVo);
		if (uVos != null) {
			results = "登录成功";
			session.setAttribute("user", username);

			System.out.println(results);
			return "cc";

		} else {
			results = "账号或密码错误";
			return "cc";
		}

	}

	public String regiest() {
		regiestUserVo.setAcc(acc);
		regiestUserVo.setPass(pass);
		regiestUserVo.setPasstwo(passtwo);
		System.out.println(regiestUserVo);
		if (regiestUserVo.getAcc() == null || regiestUserVo.getAcc() == "" || regiestUserVo.getPass() == null
				|| regiestUserVo.getPasstwo() == null) {
			results = "格式不正确";
			return "failed";
		}
		if (!regiestUserVo.getPass().equals(regiestUserVo.getPasstwo())) {
			results = "两次输入密码不一致";
			return "failed";
		}

		regiestUserVo regiestUserVo2 = userService.regiestmapper(regiestUserVo);
		if (regiestUserVo2 != null) {
			results = "账号已存在";
			return "failed";
		}
		int row = userService.insertUser(regiestUserVo);
		if (row > 0) {
			results = "注册成功";
			return "success";

		} else {
			results = "注册失败";
			return "failed";
		}

	}

	public String logoff() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null) {
			session.invalidate();
			return "success";
		} else {
			results = "已注销";
		}
		return "success";
	}

}
