<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>账号管理</title>
      
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    <link href="js/sweetalert.css" rel="stylesheet">
     <script src="js/jquery-3.3.1.js"></script>
     <script src="js/sweetalert.min.js"></script> 
     <script src="myjs/role.js"></script> 
     <script src="myjs/changerole.js"></script> 
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
<jsp:include page="head.jsp"></jsp:include>
    


    <div class="main-container">
    <jsp:include page="Navigation.jsp"></jsp:include>


        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-0">


                                <div class="row p-5">
                                    <div class="col-md-12">
                                        <table class="table table-bordered" id="roletable">
                                            
                                            <!-- <thead>
                                            <tr>
                                            <th style="width: 53px;">选择</th>
                                                <th style="width: 20px;">ID</th>
                                                <th style="width: 60px;">账号</th>
                                                <th style="width: 60px;">密码</th>
                                                <th>拥有的权限</th>
                                                <th style="width: 20px;">禁用</th>
                                                <th style="width: 160px;">角色</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                            <td><input type="checkbox" name="box" value=""></td>
                                                <td>123</td>
                                                <td>17358546632</td>
                                                <td>817f2786d523d1c2fc0a66f21d03986d</td>
                                                <td>admin</td>
                                                <td><button class="btn btn-outline-info" style="margin-left: 1px;">禁用</button></td>
                                                <td>
                                              	  <div class="form-group">
                                           			 <select id="single-select" class="form-control">
                                                		<option>1</option>
                                                		<option>2</option>
                                                		<option>3</option>
                                                		<option>4</option>
                                                		<option>5</option>
                                            		</select>
                                        		 </div>
                                        		</td>
                                             </tr> 
                                             </tbody>-->
                                            
                                             
                                            
                                             
                                             
                                            
                                            
                                            
                                        </table>
                                    </div>
                                </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            
            <button class="btn btn-danger" style="margin: 136px 0 0 550px;" onclick="changerole()">提交更改</button>
            
            </div>
        </div>
    </div>

<script src="./vendor/jquery/jquery.min.js"></script>
<script src="./vendor/popper.js/popper.min.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="./vendor/chart.js/Chart.min.js"></script>
<script src="./js/carbon.js"></script>
<script src="./js/demo.js"></script>
</body>
</html>