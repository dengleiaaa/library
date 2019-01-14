function bookinfo(bbid) {
	$.ajax({
		url:"book_bookinfo",
		type:"post",
		data:{
			bid:bbid,   
		},
		dataType:"json",
		success:function(data){
			$("#bookinfo").empty();
			$("#modal-footer").empty();
			var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th1 = $("<th>名称</th>");
			var th2 = $("<th>描述</th>");
			var th3 = $("<th>作者</th>");
			var th4 = $("<th>分类</th>");
			var th5 = $("<th>库存</th>");

			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);

			thead.append(trs);
			$("#bookinfo").append(thead);
			
			for (var i = 0; i < data.abklit.length; i++) {
				
					var tr = $("<tr></tr>");	
					var td1 = $("<td></td>").text(data.abklit[i].bname);
					var td2 = $("<td></td>").text(data.abklit[i].bdesc);
					var td3 = $("<td id='td'></td>").text(data.abklit[i].bauthor);
					var td4 = $("<td id='td1'></td>").text(data.abklit[i].btype);
					var td5 = $("<td>￥</td>").text(data.abklit[i].bnum);
					
	                tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);

					$("#bookinfo").append(tr);
				
					var button = $("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>")
					var button1 = $("<button type='button' class='btn btn-primary' onclick='borrow("+data.abklit[i].bid+")'>确认借阅</button>")

					$("#modal-footer").append(button);
					$("#modal-footer").append(button1);
			}
			}
		});
}

