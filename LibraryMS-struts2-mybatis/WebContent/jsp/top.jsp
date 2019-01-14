<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<s:if test="${empty sessionScope.account }">
	<nav id="top">
		<div class="container">
			<div class="row">
				<a href="jsp/mainpage.jsp"><img
					src="/WoniuShopDL/images/logo.png"></a>
				<ul class="top-link" class="link-6">
					<li><a href="jsp/login.jsp"><strong>登录</strong></a>&nbsp&nbsp&nbsp<a
						href="jsp/regist.jsp"><strong>注册</strong></a>
						&nbsp&nbsp&nbsp<strong><a>当前在线人数为：<%=application.getAttribute("onlinecount") %>人</a></strong>
				</ul>
			</div>
		</div>
</s:if>
<s:if test="${!empty sessionScope.account }">
	<nav id="top">
		<div class="container">
			<div class="row">
				<a href="jsp/mainpage.jsp"><img
					src="/WoniuShopDL/images/logo.png"></a>
				<ul class="top-link" class="link-6">
					<li><a><strong>尊敬的用户
						</strong></a>
						&nbsp&nbsp&nbsp<a href="jsp/cart.jsp"><strong>购物车</strong></a>
						&nbsp&nbsp&nbsp<a href="jsp/order.jsp"><strong>订单</strong></a>
						&nbsp&nbsp&nbsp<strong><a style="cursor:pointer;" onclick="loginoff()">注销</a></strong>
						&nbsp&nbsp&nbsp<strong><a href="jsp/changepassword.jsp">修改密码</a></strong>
						&nbsp&nbsp&nbsp<strong><a>当前在线人数为：<%-- <% Object i = session.getAttribute("account");
						if(i==null){i=0;
						}else{
							i = session.getAttribute("account");
						}
						%><%=application.getAttribute("onlinecount") %> --%>人</a></strong>
						
						</li>
				</ul>
			</div>
		</div>
</s:if>

</nav>
