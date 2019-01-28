package com.woniuxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.pojo.RolePojo;
import com.woniuxy.pojo.UserPojo;
import com.woniuxy.pojo.UserRegistPojo;
import com.woniuxy.pojo.UserRolePojo;
import com.woniuxy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	private List<String> list = new ArrayList<>();

	@RequestMapping("/login")
	public List<String> Login(HttpSession session,UserPojo userPojo, boolean rememberMe) {
		System.out.println(userPojo);
		System.out.println(rememberMe + "        ********************");
		// SecurityUtils是shiro提供的工具包，包含了subject的获取
		Subject subject = SecurityUtils.getSubject();

		// 判断当前subject是否认证过
		// 开始进行认证（登录）操作，将用户名和密码传递给UsernamePasswordToken
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(userPojo.getUserAcc(), userPojo.getUserPass());

			try {
				// 调用login进行认证
				subject.login(token);
				token.setRememberMe(rememberMe);
				session.setAttribute("user", userPojo.getUserAcc());
				System.out.println("登陆成功");
				list.clear();
				list.add("登陆成功");
				return list;
				// 找不到用户回抛出异常
			} catch (UnknownAccountException uae) {
				list.clear();
				list.add("用户名无法匹配");
				return list;
				// 密码匹配错误异常
			} catch (IncorrectCredentialsException ice) {
				list.clear();
				list.add("密码错误");
				return list;
				// 用户被锁异常
			} catch (LockedAccountException lae) {
				list.clear();
				list.add("账户被锁定异常");
				return list;
			}
			// 父异常。认证失败异常
			catch (AuthenticationException ae) {
				list.clear();
				list.add("异常不详：自己解决");
				return list;
			}
		} else {
			list.clear();
			list.add("您已经登录");
			return list;
		}

	}

	@RequestMapping("/register")
	public List<String> register(UserRegistPojo userPojo) {
		if (userPojo.getUserAcc() == null || userPojo.getUserAcc() == "" || userPojo.getUserPass() == null
				|| userPojo.getUserPass() == null) {
			list.clear();
			list.add("格式不正确");
			return list;
		}
		if (!userPojo.getUserPass().equals(userPojo.getUserPasstwo())) {
			list.clear();
			list.add("两次输入密码不一致");
			return list;
		}

		UserRegistPojo regiestUserVo = userService.register(userPojo);
		if (regiestUserVo != null) {
			list.clear();
			list.add("账号已存在");
			return list;
		} else {
			SimpleHash obj = new SimpleHash("MD5", userPojo.getUserPass(), userPojo.getUserAcc(), 1024);
			userPojo.setUserPass(obj.toString());
			int row = userService.insertUser(userPojo);
			if (row > 0) {
				int uid = userService.selUidByUacc(userPojo.getUserAcc());
				userService.insertRole(5, uid);
				list.clear();
				list.add("注册成功");
				return list;
			} else {
				list.clear();
				list.add("注册失败");
				return list;
			}

		}
	}

	@RequestMapping("/role")
	public Map<String, Object> findUserRole() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserRolePojo> list = userService.selUserRole();
		List<RolePojo> list2 = userService.selAllRole();
		map.put("userrole", list);
		map.put("allrole", list2);
		return map;
	}

	@RequestMapping("/changerole")
	public Map<String, Object> changerole(int uid, int roleid) {
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int row = userService.changeRoleByUid(uid, roleid);
		System.out.println(row);
		if (row > 0) {
			result = "更改角色成功";
		}
		map.put("result", result);
		return map;
	}

}
