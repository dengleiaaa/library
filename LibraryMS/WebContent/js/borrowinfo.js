function borrowinfo() {
	$.ajax({
		url:"book_borrowinfo",
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
        if (data.result == "您还没有借阅书籍") {
        	  alert(data.result);
        	  return;
		}
        if (data.result == "请登陆后在操作") {
      	  		alert(data.result);
      	  	return;
		}
			
		$("#borrowinfo").empty();
			
		var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th1 = $("<th>借书号</th>");
			var th2 = $("<th>书名</th>");
			var th3 = $("<th>描述</th>");
			var th4 = $("<th>作者</th>");
			var th5 = $("<th>分类</th>");
			var th6 = $("<th>借书时间</th>");
			var th7 = $("<th>还书</th>");

			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);
			trs.append(th6);
			trs.append(th7);

			thead.append(trs);
			$("#borrowinfo").append(thead);
			
				
			
			for (var i = 0; i < data.bInfoPojos.length; i++) {
				
					var tr = $("<tr></tr>");	
					var td1 = $("<td></td>").text(data.bInfoPojos[i].borid);
					var td2 = $("<td></td>").text(data.bInfoPojos[i].bname);
					var td3 = $("<td id='td'></td>").text(data.bInfoPojos[i].bdesc);
					var td4 = $("<td id='td1'></td>").text(data.bInfoPojos[i].bauthor);
					var td5 = $("<td></td>").text(data.bInfoPojos[i].tname);
					var td6= $("<td></td>").text(data.bInfoPojos[i].bortime);
					var td7= $("<td><button class='btn btn-info' onclick='returnbook("+data.bInfoPojos[i].borbid+")'>还书</button></td>");
					
	                tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					tr.append(td6);
					tr.append(td7);

					$("#borrowinfo").append(tr);
				
					
				
			}
			
		}
		
	});
}