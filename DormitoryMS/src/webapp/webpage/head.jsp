<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="page-header">
        <nav class="navbar page-header">
            <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
                <i class="fa fa-bars"></i>
            </a>

            <a class="navbar-brand" href="#">
                <img src="./imgs/logo2.jpg" alt="logo" width="200px" height="60px">
            </a>

            

            <ul class="navbar-nav ml-auto">
                

                <li class="nav-item dropdown">
                
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="./imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                        <span class="small ml-1 d-md-down-none"><% Object i = session.getAttribute("user");
						if(i==null){i="****";
						}else{
							i = session.getAttribute("user").toString().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
						}
						%><%=i %></span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-right">
                        <!-- <div class="dropdown-header">Account</div> -->

                       <!--  <a href="#" class="dropdown-item">
                            <i class="fa fa-user"></i> Profile
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-envelope"></i> Messages
                        </a>
 -->
                        <!-- <div class="dropdown-header">Settings</div>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-bell"></i> Notifications
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-wrench"></i> Settings
                        </a> -->

                        <a href="/DormitoryMS/logout" class="dropdown-item">
                            <i class="fa fa-lock"></i> 注销
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>