function serachbook(bpage) {
	$.ajax({
		url:"book_serachbook",
		type:"post",
		data:{
			page:bpage,
			serachbook:$("#sss").val()
			},
		dataType:"json",
		success:function(data){
			$("#book").empty();
			$("#fenye").empty();
			if (data.result == "没找到") {
				alert(data.result);
				return;
			}
			if (data.result == "请输入查询条件") {
				alert(data.result);
				return;
			}
			$("#book").empty();
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
			var li1 = $("<li id='first' onclick='sfirstpage()'>首页</li>");
			var li2 = $("<li id='tops' onclick='sshangpage()'>上一页</li>");
			var li3 = $("<li id='page'><span id='now'></span>/<span id='too'></span>");
			var li4 = $("<li id='down' onclick='sxiapage()'>下一页</li>");
			var li5 = $("<li id='last' onclick='slastpage()'>末页</li>");
			
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
			}
			$("#too").html(data.countpage);
			$("#now").html(data.page);
			
		}
		
	});
}


function sxiapage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	if (nowpage<topage) {
		serachbook(nowpage+1);
	}
}

function sshangpage() {
	var nowpage = parseInt($("#now").html());
	if (nowpage>1) {
		serachbook(nowpage-1);
	}
}	

function sfirstpage() {
	serachbook(1);
}

function slastpage() {
	var topage = parseInt($("#too").html());
	serachbook(topage);
}

