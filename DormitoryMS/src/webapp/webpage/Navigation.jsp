<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="sidebar">
	<nav class="sidebar-nav">
		<ul class="nav">
			<li class="nav-title">导航</li>

			<li class="nav-item"><a href="main.jsp" class="nav-link active">
					<i class="icon icon-speedometer"></i> 宿舍管理系统
			</a></li>
			<shiro:hasAnyRoles name="管理员,学生,班级">
				<li class="nav-item nav-dropdown"><a href="#"
					class="nav-link nav-dropdown-toggle"> <i
						class="icon icon-target"></i> 资料管理 <i class="fa fa-caret-left"></i>
				</a>
			</shiro:hasAnyRoles>

			 <ul class="nav-dropdown-items"> 
				<shiro:hasAnyRoles name="管理员,学生">
					<li class="nav-item"><a href="student.jsp" class="nav-link">
							<i class="icon icon-target"></i> 学生管理
					</a></li>
				</shiro:hasAnyRoles>
				<shiro:hasAnyRoles name="管理员,班级">
					<li class="nav-item"><a href="classes.jsp" class="nav-link">
							<i class="icon icon-target"></i> 班级管理
					</a></li>
				</shiro:hasAnyRoles>
				<shiro:hasAnyRoles name="管理员">
					<li class="nav-item"><a href="accmt.jsp" class="nav-link">
							<i class="icon icon-target"></i> 账号管理
					</a></li>
				</shiro:hasAnyRoles>

			</ul>
			<!-- </li> -->
			<shiro:hasAnyRoles name="管理员,房间">
				<li class="nav-item nav-dropdown"><a href="#"
					class="nav-link nav-dropdown-toggle"> <i
						class="icon icon-energy"></i> 房间管理 <i class="fa fa-caret-left"></i>
				</a>

					<ul class="nav-dropdown-items">
						<li class="nav-item"><a href="room.jsp" class="nav-link">
								<i class="icon icon-energy"></i> 房间信息
						</a></li>

					</ul></li>
			</shiro:hasAnyRoles>


		</ul>
	</nav>
</div>
