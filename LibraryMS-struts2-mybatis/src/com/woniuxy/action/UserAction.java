package com.woniuxy.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.woniuxy.pojo.regiestUserVo;
import com.woniuxy.pojo.userVo;
import com.woniuxy.userservice.UserService;

public class UserAction extends ActionSupport{
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	private userVo userVo = new userVo();
	private String results;
	private String username;
	private String password;

	private String acc;
	private String pass;
	private String passtwo;

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

	private static UserService userservice = new UserService();

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

	private regiestUserVo regiestUserVo = new regiestUserVo();

	public regiestUserVo getRegiestUserVo() {
		return regiestUserVo;
	}

	public void setRegiestUserVo(regiestUserVo regiestUserVo) {
		this.regiestUserVo = regiestUserVo;
	}

	public String login() {
		userVo.setUsername(username);
		userVo.setPassword(password);

		userVo uVos = userservice.loginmapper(userVo);
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

		regiestUserVo regiestUserVo2 = userservice.regiestmapper(regiestUserVo);
		if (regiestUserVo2 != null) {
			results = "账号已存在";
			return "failed";
		}
		int row = userservice.insertUser(regiestUserVo);
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
	if (session!=null) {
		session.invalidate();
		return "success";
	}else {
		results = "已注销";
	}
	return "success";
}

}
