<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav id="top">
	<div class="container">
		<div class="row">
			<a href="booktype.jsp"><img src="../image/libary1.jpg"
				height="100px" width="239px"></a>
			<ul class="top-link" class="link-6">
				<li>
				<a style="font-size: 20px; color: #CD1076;"><strong>欢迎您使用图书管理系统</strong></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a class='btn btn-info' data-toggle='modal' data-target='#loginModal' style="background-color: green;" onclick="borrowinfo()"><strong>借阅信息</strong></a> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				&nbsp&nbsp&nbsp<a class='btn btn-info' data-toggle='modal' data-target='#addbookModal' style="background-color: green;"><strong>添加图书</strong></a> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				&nbsp&nbsp&nbsp<a class='btn btn-info' style="background-color: red;" onclick="logoff()"><strong>退出系统</strong></a> 
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			</ul>
		</div>
	</div>
</nav>


