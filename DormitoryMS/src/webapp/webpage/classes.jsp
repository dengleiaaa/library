<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>班级管理</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    
     <link href="js/sweetalert.css" rel="stylesheet">
     <script src="js/sweetalert.min.js"></script>  
    
    <script src="js/jquery-3.3.1.js"></script>
    <script src="myjs/checkbox3.js"></script>
    <script src="myjs/addclass.js"></script>
    <script src="myjs/allclass.js"></script>
    <script src="myjs/deleteclass.js"></script>
    <script src="myjs/addclassmotai.js"></script>
<style type="text/css">
#tablewidth{
width: 1214px;
height: 398px;
}
#first {
	margin: -33px 40px 66px 440px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#tops {
	margin: -87px 40px 66px 508px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#down {
	margin: -86px 40px 66px 636px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#last {
	margin: -87px 40px 66px 711px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#page {
	margin: -87px 40px 66px 588px;
	font-weight: bold;
	color: #7D26CD;
}
inputwidth {
	width: 66px;
}

tr.focus{
    background-color:#3CB371;
}
</style>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="head.jsp"></jsp:include>

    <div class="main-container">
    <jsp:include page="Navigation.jsp"></jsp:include>

        <div class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card" id="tablewidth">
                        <div class="card-header bg-light">
                            	学生信息
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover" id="tUsers">
                                   
                                   <!--  <thead>
                                    <tr>
                                    	<th>选择</th>
                                        <th>班级名称</th>
                                        <th>开班时间</th>
                                        <th>带班老师</th>
                                        </tr>
                                    </thead>
                                    
                                    
                                    <tbody>
                                    <tr>
                                    	<td><input name="boxs" type="checkbox" value=""/></td>
                                        <td>1</td>
                                        <td class="text-nowrap">Samsung Galaxy S8</td>
                                        <td>31,589</td>
                                        </tr>
                                    <tr>
									</tbody> -->
                                
                                
                                
                                
                                </table>
                            </div>
                        </div>
     <div id="fenye">
		<ul style="height: 0;">
			<li id="first" onclick="firstpage()">首页</li>
			<li id="tops" onclick="shangpage()">上一页</li>
			<li id="page" onclick=""><span id="now">1</span>/<span id="too">3</span>
			<li id="down" onclick="xiapage()">下一页</li>
			<li id="last" onclick="lastpage()">末页</li>
		</ul>
	</div>
                    </div>
     <button class="btn btn-info" data-toggle="modal" data-target="#myModal" style="margin: 39px 0px 0px 449px;"onclick="addclassmotai()">添加班级</button>
     <button type="button" class="btn btn-warning" style="margin: -59px 0px 0px 719px;" onclick="deleteclass()">删除班级</button>

            </div>
        </div>
    </div>
</div>
</div>


<!-- 班级添加模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin: 109px auto;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">班级添加</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                
            </div>
            <div class="modal-body">
            
            
            <div class="form-group">
                     <label for="normal-input" class="form-control-label">班级名称</label>
                     <input id="classesname" class="form-control" value="">
              </div>
            
            <div class="form-group">
            
            <div class="form-group" id="addclassmotai">
                                            <label for="single-select">带班老师</label>
                                            <select id="classestea" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
            
                  <!--  <label for="normal-input" class="form-control-label">带班老师</label>
                    <input id="classestea" class="form-control" value=""> -->
             </div>
            
            <div class="form-group">
                   <label for="normal-input" class="form-control-label">开班时间</label>
                    <input id="classestime" class="form-control" value="" type="date">
             </div>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addclass()">提交</button>
            </div>
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