<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有图书</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/allbook.js"></script>
<script src="../js/bookinfo.js"></script>
<script src="../js/booktype.js"></script>
<script src="../js/alterinfo.js"></script>
<script src="../js/alterbook.js"></script>
<script src="../js/delbook.js"></script>
<script src="../js/serachbook.js"></script>
<script src="../js/borrow.js"></script>
<script src="../js/returnbook.js"></script>
<script src="../js/borrowinfo.js"></script>
<script src="../js/addbook.js"></script>
<script src="../js/logoff.js"></script>
<style type="text/css">
#big {
	width: 1200px;
	height: 550px;
	border: 0px gray solid;
	margin: 0px auto;
}

#first {
	margin: -10px 40px 66px 645px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#tops {
	margin: -85px 40px 66px 702px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#down {
	margin: -85px 40px 66px 819px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#last {
	margin: -86px 40px 66px 890px;
	cursor: pointer;
	font-weight: bold;
	color: #7D26CD;
}

#page {
	margin: -86px 40px 66px 769px;
	font-weight: bold;
	color: #7D26CD;
}

#serch {
	margin-left: 400px;
}

#sss {
	width: 300px;
}

#aaa {
	margin-bottom: -1px;
	background-color: white;
	border-color: white;
}

#fff {
	margin-top: 8px;
}

#td {
	width: 200px;
}

#td1 {
	width: 150px;
}

#ddd {
	min-width: 98px;
}

#modal {
	width: 660px;
	height: 500px;
}

#del {
	height: 39px;
}

#modals {
	width: 660px;
	height: 490x;
}

#desc {
	width: 350px;
	height: 70x;
}

#author {
	width: 350px;
	height: 50x;
}

#modalborrow{
height: 600px;
width: 1000px;
}
.modal{
left: -460px;
top: -45px;
}

#addmodal{
height: 520px;
width: 800px;
}
#q{
height: 30px;
width: 666px;
}
#w{
height: 30px;
width: 666px;
}
#e{
height: 30px;
width: 666px;
}
#r{
height: 30px;
width: 666px;
}
#t{
height: 30px;
width: 666px;
}
#y{
height: 30px;
width: 666px;
}
#u{
height: 30px;
width: 666px;
}
#i{
height: 30px;
width: 666px;
}


</style>
</head>


<body>
	<%@ include file="top2.jsp"%>

	<div id="big">
		<nav class="navbar navbar-default" role="navigation" id="aaa">
			<div class="container-fluid">
				<div>
					<form class="navbar-form navbar-left" role="search" id="serch">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="请输入作者或者书名查找"
								value="" id="sss">
						</div>
						<button type="button" class="btn btn-default"
							onclick="serachbook(1)" style="background-color: #00BFFF;color: white;">查找</button>
					</form>
					<ul class="nav nav-tabs">


						<li class="dropdown" id="fff"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#" style="color: #CD1076"><strong>图书分类</strong><span class="caret"></span>
						</a>
							<ul class="dropdown-menu" id="ddd">
								<li><a href="booktype.jsp">所有图书</a></li>
								<li><a onclick="booktype(1,1)">计算机</a></li>
								<li><a onclick="booktype(2,1)">科普</a></li>
								<li><a onclick="booktype(3,1)">小说</a></li>
								<li><a onclick="booktype(4,1)">历史</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</nav>
		<table class="table table-bordered" id="book">
			<!-- 		<thead>
					<tr>
					    <th>序号</th>
					    <th>图书分类</th>
					    <th>图书名称</th>
						<th>作者</th>
						<th>价格</th>
						<th>出版社</th>
						<th>删除</th>
						<th>修改</th>
						<th>借阅</th>
					</tr>
		</thead> -->

			<!--    			<tr>
				<td>1</td>
				<td>历史</td>
				<td>十二个圣诞故事</td>
				<td>珍妮特.温特森 著</td>
				<td>￥43.50</td>
				<td>北京联合出版公司</td>
				<td><button class="btn btn-info">删除此书</button></td>
				<td><button class="btn btn-info">修改信息</button></td>
				<td><a><button class="btn btn-info" data-toggle="modal" data-target="#myModal">借阅此书</button></a></td>
			</tr> -->



		</table>

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

	<!-- 借阅模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" id="modal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">书籍详情</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered" id="bookinfo">
						<!--          		<thead>
					<tr>
					    <th>名称</th>
					    <th>描述</th>
					    <th>作者</th>
					    <th>分类</th>
                        <th>库存</th>
					</tr>
		      </thead>
            	<tr>
				<td>Python编程 从入门到实践</td>
				<td>一本写给每个人的梦想之书，无关国界，无关年龄</td>
				<td>珍妮特.温特森 著</td>
				<td>计算机</td>
				<td>66</td>
				
			</tr> -->
					</table>
				</div>
				<div class="modal-footer" id="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">借阅</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 修改模态框 -->

	<div class="modal fade" id="alterModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" id="modal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modals"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">书籍详情修改</h4>
				</div>
				<div class="modal-body" class="ztree" style="height:378	px;overflow:auto;">
					<table class="table table-bordered" id="alterinfo">
						<!--      <thead>
					<tr>
					    <th>借书号</th>
					    <th>书名</th>
					    <th>描述</th>
					    <th>作者</th>
					    <th>分类</th>
					    <th>还书</th>
					  </tr>
		      </thead>
            	<tr>
				<td>2018123013524210</td>
				<td>Excel高效办公</td>
				<td>网络爬虫热门编程语言</td>
				<td>珍妮特.温特森 著</td>
				<td>计算机</td>
				<td><button class='btn btn-info' onclick='bookinfo("+data.abklit[i].bid+")'>借阅此书</button></td>
				</tr>
				
				<tr>
				<td id="del"><input type="text" value="" id="desc"></td>
				<td id="del"><input type="text" value="" id="author"></td>
				</tr> -->
					</table>
				</div>
				<div class="modal-footer" id="modaldel">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">放弃修改</button>
                <button type="button" class="btn btn-primary" onclick="">提交修改</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 还书模态框 -->

	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" id="modalborrow">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modals"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">您的借阅信息</h4>
				</div>
				<div class="ztree" style="height:450px;overflow:auto;">
					<table class="table table-bordered" id="borrowinfo">
						
						<!-- <thead>
							<tr>
								<th>借书号</th>
								<th>书名</th>
								<th>描述</th>
								<th>作者</th>
								<th>分类</th>
								<th>借书时间</th>
								<th>还书</th>
							</tr>
						</thead>
						<tr>
							<td>2018123013524210</td>
							<td>Excel高效办公</td>
							<td>网络爬虫热门编程语言</td>
							<td>珍妮特.温特森 著</td>
							<td>计算机</td>
							<td>2018-12-30 13:52:42</td>
							<td><button class='btn btn-info'
									onclick='returnbook()'>还书</button></td>
						</tr>
 -->






					</table>
				</div>
				<div class="modal-footer" id="modaldel">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<!-- <button type="button" class="btn btn-primary" onclick="">提交修改</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<!-- 加书模态框 -->

	<div class="modal fade" id="addbookModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" id="addmodal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modals"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加图书</h4>
				</div>
				<div class="ztree" style="height:400px;overflow:auto;">
					<table class="table table-bordered" id="borrowinfo">

						<tr>
							<td>书名</td>
							<td><input type="text" value="" id="q"></td>
						</tr>
						<tr>
							<td>作者</td>
							<td><input type="text" value="" id="w"></td>
						</tr>
						<tr>
							<td>描述</td>
							<td><input type="text" value="" id="e"></td>
						</tr>
						<tr>
							<td>价钱</td>
							<td><input type="text" value="" id="r"></td>
						</tr>
						<tr>
							<td>出版社</td>
							<td><input type="text" value="" id="t"></td>
						</tr>
						<tr>
							<td>出版日期</td>
							<td><input type="text" value="" id="y"></td>
						</tr>
						<tr>
							<td>数量</td>
							<td><input type="text" value="" id="u"></td>
						</tr>
						<tr>
							<td>分类</td>
							<td><input type="text" value="" id="i" placeholder="计算机请输入1,   科普请输入2,   小说请输入3,   历史请输入4"></td>
						</tr>







					</table>
				</div>
				<div class="modal-footer" id="modaldel">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="addbook()">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>



</body>
</html>