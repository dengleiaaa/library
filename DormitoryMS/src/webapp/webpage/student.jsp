<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生管理</title>
    <link rel="stylesheet" href="./vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="./vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="./css/styles.css">
    <link href="js/sweetalert.css" rel="stylesheet">
    
    
    <script src="js/sweetalert.min.js"></script>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="myjs/checkbox.js"></script>
    <script src="myjs/checkinfomotai.js"></script>
    <script src="myjs/addcheckinfo.js"></script>
    <script src="myjs/allstudent.js"></script>
    <script src="myjs/studentinfo.js"></script>
    <script src="myjs/checkout.js"></script>
    <script src="myjs/searchstudent.js"></script>
    <script src="myjs/changeroommotai.js"></script>
    <script src="myjs/changeroom.js"></script>
    <script src="myjs/deletealert.js"></script>

<style type="text/css">
#tablewidth{
width: 1214px;
height: 366px;
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
#stuimg{
border: solid red 0px;
margin: 10px auto;
width:150px;
height: 150px;
}
#myImg img{
            width: 150px;
            height: 150px;
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
                                <table class="table table-hover" id="allstudent">
                                    
                                    <!-- <thead>
                                    <tr>
                                    <th>选择</th>
                                        <th>学生姓名</th>
                                        <th>性别</th>
                                        <th>班级</th>
                                        <th>所在房间</th>
                                        <th>联系电话</th>
                                     </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    <td><input  name="boxs" type="checkbox"/></td>
                                        <td>1</td>
                                        <td class="text-nowrap">Samsung Galaxy S8</td>
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
		<ul style="height: 0;">
			<li id="first" onclick="firstpage()">首页</li>
			<li id="tops" onclick="shangpage()">上一页</li>
			<li id="page" onclick=""><span id="now">1</span>/<span id="too">3</span>
			<li id="down" onclick="xiapage()">下一页</li>
			<li id="last" onclick="lastpage()">末页</li>
		</ul>
	</div>
     
     <button onclick="checkinfomotai()" type="button" class="btn btn-success" style="margin: -50px 0px 0px 160px;" data-toggle="modal" data-target="#myModal" id="sturuzhu">学生入住</button>
     <button type="button" class="btn btn-warning" style="margin: -50px 0px 2px 90px;"  data-target="#deleteModal"  id="stumtz" onclick="deletealert()">学生退房</button>
     <button type="button" class="btn btn-danger" style="margin: 139px 0px 0px -262px;"  data-target="#changeroom" onclick="changeroommotai()" id="stumtx">学生换房</button>
     <button type="button" class="btn btn-info" style="margin: 139px 0px 0px 91px;"  data-target="#stuinfoModal" onclick="studentinfo()" id="stumtc">学生信息</button>
              
                </div>
<!--
 <div>             
 <button class="btn btn-primary" style="margin-left: 2px 2px 2px 2px;">查找</button></div>   -->

                 <div class="col-md-6">
                    <div class="card" style="margin-top: 400px;">
                        <div class="card-header bg-light">
                            	查询学生信息
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <!-- <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">学生姓名</label>
                                            <input id="normal-input" class="form-control" value="Input value">
                                        </div>
                                    </div> -->
                               
                               <div class="col-md-4">
                                        <div class="form-group">
                                            <input id="stuname" class="form-control" placeholder="学生姓名" style="width: 338%;">
                                        </div>
                                    </div>
                               
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <input id="stuclass" class="form-control" placeholder="所在班级" style="width: 338%;">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <input id="sturoom" class="form-control" placeholder="所在房间" style="width: 338%;">
                                        </div>
                                    </div>
                                    <button class="btn btn-outline-primary" style="margin-left: 256px;" onclick="searchstudent(1)">查找</button>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </div>
</div>


<!-- 用户添加模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 405px;margin-left: 69px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加学生</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">

					<div class="form-group" style="width: 169px;">
						<label for="normal-input" class="form-control-label">姓名</label> 
						<input id="sname" class="form-control">
					</div>
					
					 					<div class="form-group" style="width: 169px;">
                                            <label for="single-select">性别</label>
                                            <select id="ssex" class="form-control" onchange="checkinfomotai()">
                                                <option>男</option>
                                                <option>女</option>
                                                </select>
      </div>
      <div style="margin:-135px 0 0 200px;">
                                   
     <!-- <form id="fileupform" enctype="multipart/form-data"> -->
		<input type="file" name="fileupform" id="fileupform" style="display: none"><br><br>
		<!-- <button class="btn btn-rounded btn-success" type="submit">点击上传</button> -->
	<!-- </form> -->
    
    
    <div class="modal-body text-center" style="margin: -80px 0 0 -9px;border: 0px solid gray;width: 150px;height: 150px;">
               <!-- -text-cente  bootstrap子元素居中--->
                <span id="myImg">
                	<!--预览图片位置，默认图片-->
                    <img src="/imgUrl/u=3807516607,1357614470&fm=26&gp=0.jpg" alt="选择您的头像上传" class="img-circle" width="150px" height="150px">
                </span>
 
            </div>
    
    <button class="btn btn-danger" onclick="$('#fileupform').click();" style="margin: 33px 0 0 30px;">浏览头像文件</button>
    
    
    
    
    </div>                    
    
    
    <div class="form-group" style="margin-left: 0px;width: 169px;margin-top: 9px;" id="classselect">
                                             <!-- <label for="single-select">班级</label>
                                            <select id="r_state" class="form-control">
                                                 <option>不限</option>
                                                <option>正常</option>
                                                <option>损坏</option> 
                                                </select> --> 
                                        </div>
                                    

                                     
                                        <div class="form-group" style="margin:-80px 0 0 200px;width: 169px;">
                                            <label for="normal-input" class="form-control-label">联系电话</label> 
												<input id="stel" class="form-control">
                                        
                                    </div>
                                    
                                    
                                    <!-- <div class="col-md-4" style="margin-left: 66px;"> -->
                                        <div class="form-group" style="margin-left: 0px;width: 169px;margin-top: 29px;" id="roomcanlive">
                                           <!--  <label for="single-select">房间</label>
                                            <select id="r_kezhu" class="form-control">
                                                <option>不限</option>
                                                <option>可住房间</option>
                                             </select> -->
                                        </div>
                                    
								
								<!-- <div class="col-md-4" style="margin-left: 58px;"> -->
                                     <div class="form-group" style="margin:-80px 0 0 200px;width: 169px;margin-top: -80px;">
                                            <label for="normal-input" class="form-control-label">入住时间</label> 
											<input id="sdate" type="date" class="form-control">
                                             
                 </div>
				
				
				
				
				
				</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onclick="addcheckinfo()">添加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 学生信息模态框（Modal） -->
<div class="modal fade" id="stuinfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 627px;">
            <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">学生信息</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              </div>
            <div class="modal-body" id="studentinfo">
            
            
            <!-- <div id="stuimg">
            <img src="./imgs/41f6834e-8363-499c-8fed-494e9a42b206.jpg" width="150px" height="150px">
            </div>
            <table class="table table-hover">
                  				<tbody>
									<tr>
                                        <td style="width: 70px;">姓名：</td>
                                        <td>孙军</td>
                                        <td style="width: 95px;">性别：</td>
                                        <td>男</td>
                                    </tr>
                                    
                                    <tr>
                                        <td>班级：</td>
                                        <td>3班</td>
                                        <td>联系电话：</td>
                                        <td>13569874589</td>
                                    </tr>
                                   <tr>
                                        <td>房间：</td>
                                        <td>春熙路</td>
                                        <td>入住时间：</td>
                                        <td>2018-09-10</td>
                                    </tr>
                                    
                                  </tbody>
                                </table> 
                             -->

            
            
            
            
            
            
            
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
            <label for="message-text" class="control-label">确定要退房？</label>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="checkout()">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<!-- 换房模态框（Modal） -->
<div class="modal fade" id="changeroom" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="height: 366px;margin-top: 150px;">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">学生换房</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
            
            
                      <table class="table table-hover" id="studentin">
                                <!-- <tbody>
                                    <tr>
                                        <td style="width: 116px;">姓名：</td>
                                        <td style="width: 200px;">孙军</td>
                                        <td style="width: 116px;">性别：</td>
                                        <td style="width: 200px;">男</td>
                                    </tr>
                                    <tr>
                                        <td>班级：</td>
                                        <td>GT23</td>
                                        <td>原房间：</td>
                                        <td>春熙路</td>
                                    </tr>
                                   </tbody> -->
                                </table> 
            					<div class="form-group" id="canlive">
                                     <!-- <label for="single-select">选择要更换的房间</label>
                                         <select id="changeroom" class="form-control">
                                               <option value="">1</option>
                                               
                                            </select> -->
                                        </div>
             
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="changeroom()">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<script type="text/javascript">

$("#fileupform").change(function(){//上传文件表单
	var file=this.files[0] ;  // 获取input上传的图片数据;
var url=window.URL.createObjectURL(file);  // 得到file对象路径，可当成普通的文件路径一样使用，赋值给src;
$("#myImg").html("<img src='"+url+"' class='img-circle'/>");


//获得原图片的长和宽-------------------------
//var img = new Image();// 创建对象	
//img.src =url;// 改变图片的src
//img.onload = function(){// 加载完成执行
// 打印
//alert('width:'+img.width+',height:'+img.height);
//};

});

</script>

<script src="./vendor/jquery/jquery.min.js"></script>
<script src="./vendor/popper.js/popper.min.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="./vendor/chart.js/Chart.min.js"></script>
<script src="./js/carbon.js"></script>
<script src="./js/demo.js"></script>

</body>
</html>