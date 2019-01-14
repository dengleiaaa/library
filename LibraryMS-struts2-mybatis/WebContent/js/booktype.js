function booktype(btype,bpage) {
	$.ajax({
		url:"book_booktype",
		type:"post",
		data:{
			type:btype,
			page:bpage,
		},
		dataType:"json",
		success:function(data){
			$("#book").empty();
			$("#fenye").empty();
			var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th1 = $("<th>序号</th>");
			var th2 = $("<th>图书分类</th>");
			var th3 = $("<th>图书名称</th>");
			var th4 = $("<th>作者</th>");
			var th5 = $("<th>价格</th>");
			var th6 = $("<th>出版社</th>");
			var th7 = $("<th>删除</th>");
			var th8 = $("<th>修改</th>");
			var th9 = $("<th>借阅</th>");
			
			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);
			trs.append(th6);
			trs.append(th7);
			trs.append(th8);
			trs.append(th9);
			thead.append(trs);
			$("#book").append(thead);
			
	
			var ul = $("<ul></ul>");
			var li1 = $("<li id='first' onclick='fpage()'>首页</li>");
			var li2 = $("<li id='tops' onclick='spage()'>上一页</li>");
			var li3 = $("<li id='page'><span id='now'></span>/<span id='too'></span>");
			var li4 = $("<li id='down' onclick='xpage()'>下一页</li>");
			var li5 = $("<li id='last' onclick='lpage()'>末页</li>");
			
			ul.append(li1);
			ul.append(li2);
			ul.append(li3);
			ul.append(li4);
			ul.append(li5);
			
			$("#fenye").append(ul);
			
			
			
			var t = 0;
			for (var i = 0; i < data.abklit.length; i++) {
				t++;
				var tr = $("<tr></tr>");	
				var td1 = $("<td></td>").text(t);
				var td2 = $("<td id='booktype'></td>").text(data.abklit[i].btype);
				var td3 = $("<td id='td'></td>").text(data.abklit[i].bname);
				var td4 = $("<td id='td1'></td>").text(data.abklit[i].bauthor);
				var td5 = $("<td>￥</td>").text(data.abklit[i].bprice);
				var td6 = $("<td></td>").text(data.abklit[i].bpress);
				var td7 = $("<td><button class='btn btn-info' onclick='delbook("+data.abklit[i].bid+")'>删除此书</button></td>");
				var td8 = $("<td><button class='btn btn-info' data-toggle='modal' data-target='#alterModal' onclick='alterinfo("+data.abklit[i].bid+")'>查询信息</button></td>");
				var td9 = $("<td><button class='btn btn-info' data-toggle='modal' data-target='#myModal' onclick='bookinfo("+data.abklit[i].bid+")'>借阅此书</button></td>");
                
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
				tr.append(td8);
				tr.append(td9);
				
				$("#book").append(tr);
				
				var button = $("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>")
				var button1 = $("<button type='button' class='btn btn-primary' onclick='borrow("+data.abklit[i].bid+")'>借阅</button>")

				$("#modal-footer").append(button);
				$("#modal-footer").append(button1);
			}
			$("#too").html(data.countpage);
			$("#now").html(data.page);
		}
	});
}

function xpage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	var be = $("#booktype").html();
	var type = 1;
	if (be == "计算机") {
		type = 1;
	}
	if (be == "科普") {
		type = 2;
	}
	if (be == "小说") {
		type = 3;
	}
	if (be == "历史") {
		type = 4;
	}
	if (nowpage<topage) {
		booktype(type,nowpage+1);
		
	}
}

function spage() {
	
	var nowpage = parseInt($("#now").html());
	var be = $("#booktype").html();
	var type = 1;
	if (be == "计算机") {
		type = 1;
	}
	if (be == "科普") {
		type = 2;
	}
	if (be == "小说") {
		type = 3;
	}
	if (be == "历史") {
		type = 4;
	}
	if (nowpage>1) {
		booktype(type,nowpage-1);
	}
}	

function fpage() {
	var be = $("#booktype").html();
	var type = 1;
	if (be == "计算机") {
		type = 1;
	}
	if (be == "科普") {
		type = 2;
	}
	if (be == "小说") {
		type = 3;
	}
	if (be == "历史") {
		type = 4;
	}
	booktype(type,1);
}

function lpage() {
	var be = $("#booktype").html();
	var topage = parseInt($("#too").html());
	var type = 1;
	if (be == "计算机") {
		type = 1;
	}
	if (be == "科普") {
		type = 2;
	}
	if (be == "小说") {
		type = 3;
	}
	if (be == "历史") {
		type = 4;
	}
	booktype(type,topage);
}

