package com.woniuxy.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.woniuxy.pojo.UserPojo;
import com.woniuxy.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userservice;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
     	System.out.println("权限验证");

		int uid = userservice.selUidByUacc(principalCollection.toString());
		Set<String> roleSet = userservice.selRoleByuid(uid);
		//Set<String> permissionSet = userservice.selPerssiomByuid(uid);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roleSet);
		//info.setStringPermissions(permissionSet);
		return info;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userAcc = token.getPrincipal().toString();
		System.out.println(userAcc);
		UserPojo userPojo = userservice.Login(userAcc);
		System.out.println(userPojo);
		ByteSource by = ByteSource.Util.bytes(userPojo.getUserAcc());
		AuthenticationInfo info = new SimpleAuthenticationInfo(userPojo.getUserAcc(), userPojo.getUserPass(), by,
				getName());
		return info;
	}

}
