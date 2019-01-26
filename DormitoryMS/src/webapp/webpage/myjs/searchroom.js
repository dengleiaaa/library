function searchroom(spage) {
	$.ajax({
		url:"../room/searchroom",
		type:"post",
		data:{
			page:spage,
			r_address:$("#r_address").val(),
			r_state:$("#r_state").val(),
			r_kezhu:$("#r_kezhu").val(),
			r_sextype:$("#r_sextype").val()
			},
		dataType:"json",
		success:function(data){
			$("#allroom").empty();
			$("#fenye").empty();
			if (data.result=="当前查询条件没有符合的记录") {
				swal(data.result);
				return;
			}
			

			var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th0 = $("<th>选择</th>");
			var th1 = $("<th>房间地址</th>");
			var th2 = $("<th>可容纳人数</th>");
			var th3 = $("<th>已住人数</th>");
			var th4 = $("<th>房租</th>");
			var th5 = $("<th>房间状态</th>");
			var th6 = $("<th>房东</th>");
			var th7 = $("<th>房东电话</th>");
			var th8 = $("<th>房间类型</th>");
			
			trs.append(th0);
			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);
			trs.append(th6);
			trs.append(th7);
			trs.append(th8);
			

			thead.append(trs);
			$("#allroom").append(thead);
			
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
			
			for (var i = 0; i < data.searchroom.length; i++) {
				
			
				
				var tbody = $("<tbody></tbody>"); 
				var tr = $("<tr></tr>");
				var td0 = $("<td><input  name='boxs' value="+data.searchroom[i].r_id+" type='checkbox' onclick='addmt()'/></td>");
				var td1 = $("<td></td>").text(data.searchroom[i].r_address);
				var td2 = $("<td></td>").text(data.searchroom[i].r_population);
				var td3 = $("<td></td>").text(data.searchroom[i].checkinpeople);
				var td4 = $("<td>"+data.searchroom[i].r_rent+"元/每月</td>");
				var td5 = $("<td></td>").text(data.searchroom[i].r_state);
				var td6 = $("<td></td>").text(data.searchroom[i].l_name);
				var td7 = $("<td></td>").text(data.searchroom[i].l_tel);
				var td8 = $("<td></td>").text(data.searchroom[i].r_sextype);

				tr.append(td0);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				tr.append(td7);
				tr.append(td8);
				
				tbody.append(tr);
				
				$("#allroom").append(tbody);
			}
			$("#too").html(data.allpage);
			$("#now").html(data.currentpage);
		}
	});
}

function sxiapage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	if (nowpage<topage) {
		searchroom(nowpage+1);
	}
}

function sshangpage() {
	var nowpage = parseInt($("#now").html());
	if (nowpage>1) {
		searchroom(nowpage-1);
	}
}	

function sfirstpage() {
	searchroom(1);
}

function slastpage() {
	var topage = parseInt($("#too").html());
	searchroom(topage);
}
