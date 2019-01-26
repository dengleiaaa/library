<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>房间管理</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    <link href="js/sweetalert.css" rel="stylesheet">

    
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/sweetalert.min.js"></script>
    <script src="./vendor/jquery/jquery.min.js"></script>
	<script src="./vendor/popper.js/popper.min.js"></script>
	<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="./vendor/chart.js/Chart.min.js"></script>
	<script src="./js/carbon.js"></script>
	<script src="./js/demo.js"></script>
    <script src="myjs/checkbox2.js"></script>
    <script src="myjs/addroom.js"></script>
    <script src="myjs/allroom.js"></script>
    <script src="myjs/searchroom.js"></script>
    <script src="myjs/roominfo.js"></script>
    <script src="myjs/deleteroom.js"></script>
    <script src="myjs/addtool.js"></script>
    <script src="myjs/roomtoolmotai.js"></script>
    <script src="myjs/handletool.js"></script>
    <script src="myjs/deletealert.js"></script>
    
<style type="text/css">
#tablewidth{
width: 1214px;
height: 377px;
}
#first {
	margin: 0px 40px 66px 125px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#tops {
	margin: -87px 40px 66px 188px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#down {
	margin: -86px 40px 66px 330px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#last {
	margin: -87px 40px 66px 411px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#page {
	margin: -87px 40px 66px 269px;
	font-weight: bold;
	color: #7D26CD;
}
inputwidth {
	width: 66px;
}
#roominfopeople{
border: solid red 0px;
width: 600px;
height: 260px;
margin: 0 auto;

}
#elec_table{
    position:relative;
    table-layout : fixed;
}
#table-body{
    overflow-y:auto;
    overflow-x:hidden;
    height:150px;
}
/*设置table-layout:fixed固定宽度，表头和表体需要对齐*/
table{
    table-layout:fixed;
}
/*设置单元格的宽度，可能会出现内容长需要换行的情况 使用white-space:normal，每个单元格都是一样的宽度*/
#elec_table td{
    width:20%;
    white-space:normal;
}
.theadstyle thead tr th{
    text-align:center;
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
                <div class="col-md-6" style="height: 6px;">
                    <div class="card" id="tablewidth">
                        <div class="card-header bg-light">
                            	学生信息
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover" id="allroom">
                                    
                                    
                                    <!-- <thead>
                                    <tr>
                                        <th>房间地址</th>
                                        <th>可容纳人数</th>
                                        <th>已住人数</th>
                                        <th>房租</th>
                                        <th>房间状态</th>
                                        <th>房东</th>
                                        <th>房东电话</th>
                                        <th>房间类型</th>
                                     </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">Samsung Galaxy S8</td>
                                        <td>31,589</td>
                                        <td>$800</td>
                                        <td>5%</td>
                                        <td>31,589</td>
                                        <td>$800</td>
                                        <td>5%</td>
                                     </tr>
                                    </tbody> -->
                                    
                                    
                                    
                                    
                                </table>
                            </div>
                        </div>
    

                    </div>
                    
                        <div id="fenye">
		<ul>
			<li id="first" onclick="firstpage()">首页</li>
			<li id="tops" onclick="shangpage()">上一页</li>
			<li id="page" onclick=""><span id="now"></span>/<span id="too"></span>
			<li id="down" onclick="xiapage()">下一页</li>
			<li id="last" onclick="lastpage()">末页</li>
		</ul>
	</div>
	</div>
	<div style="border: 0px red solid; width: 500px;height: 200px;margin: 439px 0px 0px -570px;">
     
     <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" style="margin: -33px 0px 0px 160px;">添加房间</button>
     <button type="button" class="btn btn-warning" style="margin: -33px 0px 2px 90px"  data-target="#deleteModal" id="roomq" onclick="deletealertroom()">删除房间</button>
     <button type="button" class="btn btn-danger"  data-target="#roomModal" style="margin: 116px 0px 0px -262px;" onclick="roominfo()" id="roomw">房间信息</button>
     <button type="button" class="btn btn-info" style="margin: 116px 0px 0px 91px;" data-target="#roomtoolModal" onclick="roomtoolmotai()" id="roome">房间设施</button>
      </div>          
                
                
                


                 <div class="col-md-6" style="margin-left: 70px;">
                    <div class="card" style="margin-top: 400px;height: 283px;">
                        <div class="card-header bg-light">
                            	查询房间信息
                        </div>

                        <div class="card-body">
                 
                               <div class="row">

                                    
                                        <div class="form-group" style="margin-left: 109px;width: 100px;">
                                            <label for="normal-input" class="form-control-label">房间地址</label>
                                            <input id="r_address" class="form-control" style="width: 166px;">
                                        </div>
                                    

                                     
                                        <div class="form-group" style="margin-left: 129px;width: 169px;">
                                            <label for="single-select">房间状态</label>
                                            <select id="r_state" class="form-control">
                                                <option>不限</option>
                                                <option>正常</option>
                                                <option>损坏</option>
                                                </select>
                                        
                                    </div>
                                    
                                    <div class="row">
                                    <!-- <div class="col-md-4" style="margin-left: 66px;"> -->
                                        <div class="form-group" style="margin-left: 123px;width: 169px;">
                                            <label for="single-select">可住房间</label>
                                            <select id="r_kezhu" class="form-control">
                                                <option>不限</option>
                                                <option>可住房间</option>
                                             </select>
                                        </div>
                                    
								
								<!-- <div class="col-md-4" style="margin-left: 58px;"> -->
                                     <div class="form-group" style="margin-left: 61px;width: 169px;">
                                            <label for="single-select">房间类型</label>
                                            <select id="r_sextype" class="form-control">
                                                <option>不限</option>
                                                <option>男生宿舍</option>
                                                <option>女生宿舍</option>
                                              </select>
                                        
                                    
                                    <button class="btn btn-outline-primary" style="margin: 23px 0 0 -57px;" onclick="searchroom(1)">查找</button>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </div>
</div>
</div>
</div>
<!-- 添加房间模态框（Modal） -->


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加房间信息</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">

<div class="row">

                                    <div class="col-md-4" style="margin-left: 34px;">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">房间地址</label>
                                            <input id="r_addressss" class="form-control" style="width: 190px;">
                                        </div>
                                    </div>

                                     
                                        <div class="form-group" style="margin-left: 58px;">
                                            <label for="normal-input" class="form-control-label">房间户型</label>
                                            <input id="r_type" class="form-control" style="width: 190px;">
                                        </div>
                                    
                             </div>  
<div class="row">
                                    <div class="col-md-4" style="margin-left: 34px;">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">可容纳人数</label>
                                            <input id="r_population" class="form-control" style="width: 190px;">
                                        </div>
                                    </div>
								
		
                                     <div class="form-group" style="margin-left: 58px;">
                                            <label for="single-select">房间类型</label>
                                            <select id="r_sextyper" class="form-control" style="width: 190px;">
                                                <option selected="selected">男生宿舍</option>
                                                <option>女生宿舍</option>
                                                </select>
                                        </div>
                                    
                                  </div>  
   <div class="row">
                                    <div class="col-md-4" style="margin-left: 36px;">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">房租</label>
                                            <input id="r_rent" class="form-control" style="width: 190px;">
                                        </div>
                                    </div>

                                    
                                        <div class="form-group" style="margin-left: 58px;">
                                            <label for="normal-input" class="form-control-label">支付方式</label>
                                            <input id="r_renttype" class="form-control" style="width: 190px;">
                                        </div>
                                    
                                 </div>   
<div class="row">
                                    <div class="col-md-4" style="margin-left: 36px;">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">房东</label>
                                            <input id="l_name" class="form-control" style="width: 190px;">
                                        </div>
                                    </div>
                                    
                                     
                                        <div class="form-group" style="margin-left: 58px;">
                                            <label for="normal-input" class="form-control-label">房东电话</label>
                                            <input id="l_tel" class="form-control" style="width: 190px;">
                                        </div>
                                   
                                 </div>   
<div class="row">
                                    <div class="col-md-4" style="margin-left: 36px;">
                                     <div class="form-group">
                                            <label for="single-select">房间状态</label>
                                            <select id="r_stater" class="form-control" style="width: 190px;">
                                                <option selected="selected">正常</option>
                                                <option>设施损坏</option>
                                                </select>
                                        </div>
		</div>
                                     
                                        <div class="form-group" style="margin-left: 58px;">
                                            <label for="normal-input" class="form-control-label">租房日期</label>
                                            <input type="date" id="r_renttime" class="form-control" style="width: 190px;">
                                        </div>
                                    
             </div>



     
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addroom()">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 房间信息模态框（Modal） -->
<div class="modal fade" id="roomModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 766px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">查看房间信息</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body" id="singleroom">
            	<div class="table-responsive" id="singleroomrrr">
                                
                                
                                <!-- <table class="table table-hover">
                                    
                                    <tbody>
                                    <tr>
                                        <td style="width: 116px;">房间地址：</td>
                                        <td style="width: 200px;">新南路10号</td>
                                        <td style="width: 116px;">房间户型：</td>
                                        <td style="width: 200px;">三室两厅</td>
                                    </tr>
                                    <tr>
                                        <td>可容纳人数：</td>
                                        <td>10</td>
                                        <td>已住人数：</td>
                                        <td>6</td>
                                    </tr>
                                    <tr>
                                        <td>房租：</td>
                                        <td>1600/月</td>
                                        <td>支付方式：</td>
                                        <td>季付</td>
                                    </tr>
                                   <tr>
                                        <td>房东：</td>
                                        <td>小明</td>
                                        <td>房东电话：</td>
                                        <td>13569874589</td>
                                    </tr>
                                    <tr>
                                        <td>房间状态：</td>
                                        <td>正常</td>
                                        <td>房间类型：</td>
                                        <td>男生宿舍</td>
                                    </tr>
                                    <tr>
                                        <td>租房日期：</td>
                                        <td>2019-12-29</td>
                                    </tr>
                                  </tbody>
                                </table> -->
                            
                            
                            </div>
                        
            
            <div id="roominfopeople">
            <div class="card-body" id="elec_table">
            
            <div class="table-head">
     		<table class="table theadstyle">
        		<thead>
             		<tr style="background: #ccc;">
                        <th>学生姓名</th>
                        <th>所在班级</th>
                        <th>联系电话</th>
                    </tr>
        		</thead>
     		</table>
    		</div>
            
            <div class="table-responsive" id="table-body">
                 <table class="table table-bordered" id="srvTable">
                      <!-- <tbody>
                         <tr>
                            <td>韦小宝</td>
                            <td class="text-nowrap">gt11</td>
                            <td>12356987458</td>
                          </tr>
                      </tbody> -->
                 </table>
             </div>
           </div>
         </div>
       
       
       
       
       
       
       </div>   
           <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 删除警告模态框（Modal） -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 195px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">确认</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             </div>
            <div class="modal-body">
            <label for="message-text" class="control-label">确定要删除房间？</label>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="deleteroom()">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 设施维护模态框（Modal） -->
<div class="modal fade" id="roomtoolModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <!-- <input type="hidden" value="" id=""> -->
    <div class="modal-dialog">
        <div class="modal-content" style="width: 700px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">房间设施维护</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             </div>
            <div class="modal-body">
            
            
            <div id="roomtoolinfo">
            <div class="card-body" id="elec_table" style="border: solid 1px grey;width: 666px;">
            
            <div class="table-head">
     		<table class="table theadstyle">
        		<thead>
             		<tr style="background: #ccc;">
                        <th style="width: 52px;">选择</th>
                        <th>损坏描述</th>
                        <th>损坏日期</th>
                        <th>是否解决</th>
                    </tr>
        		</thead>
     		</table>
    		</div>
            
            <div class="table-responsive" id="table-body">
                 <table class="table table-bordered" id="toolTable">
                       <!-- <tbody>
                         <tr>
                           <td style="width: 52px;"><input name='toolboxs' value="" type='checkbox'/></td>
                            <td>韦小宝</td>
                            <td class="text-nowrap">gt11</td>
                            <td>12356987458</td>
                          </tr>
                        
                      </tbody>  -->
                 </table>
             </div>
           </div>
         </div>
       
            <div class="form-group">
                 <label for="normal-input" class="form-control-label">损坏日期</label>
                  <input type="date" id="tooldate" class="form-control">
              </div>
            
            <div class="form-group">
                  <label for="textarea">损坏描述</label>
                  <textarea id="tooldesc" class="form-control" rows="6"></textarea>
             </div>
            
            
            
            
            
            </div>
            <div id="roomidhidden"></div>
            <div class="modal-footer">
            	<button type="button" class="btn btn-primary" onclick="addtool()">添加设施损坏记录</button>
            	<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#handleModal">处理已损坏设施</button>
             	<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 是否处理设施模态框（Modal） -->
<div class="modal fade" id="handleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="margin-top: 239px;margin-left: 100px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">确认</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             </div>
            <div class="modal-body">
            <label for="message-text" class="control-label"><a>房间设施真的维修好了吗？</a></label>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="handletool()">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



</body>
</html>