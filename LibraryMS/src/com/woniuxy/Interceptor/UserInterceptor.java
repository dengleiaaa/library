package com.woniuxy.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String user = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println(user);
		if (user == null) {
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			System.out.println(actionSupport.toString());
			return actionSupport.LOGIN;
		} else {
			return invocation.invoke();
		}

	}

}
