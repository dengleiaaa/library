function allroom(rpage) {
	$.ajax({
		url:"../room/roominfo",
		type:"post",
		data:{
			rpage:rpage,
		},
		dataType:"json",
		success:function(data){
			
			$("#allroom").empty();
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
			
			for (var i = 0; i < data.allroom.length; i++) {
				
			
				
				var tbody = $("<tbody></tbody>"); 
				var tr = $("<tr></tr>");
				var td0 = $("<td><input  name='boxs' value="+data.allroom[i].r_id+" type='checkbox' onclick='addmt()'/></td>");
				var td1 = $("<td></td>").text(data.allroom[i].r_address);
				var td2 = $("<td></td>").text(data.allroom[i].r_population);
				var td3 = $("<td></td>").text(data.allroom[i].checkinpeople);
				var td4 = $("<td>"+data.allroom[i].r_rent+"元/每月</td>");
				var td5 = $("<td></td>").text(data.allroom[i].r_state);
				var td6 = $("<td></td>").text(data.allroom[i].l_name);
				var td7 = $("<td></td>").text(data.allroom[i].l_tel);
				var td8 = $("<td></td>").text(data.allroom[i].r_sextype);

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
allroom(1);
function xiapage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	if (nowpage<topage) {
		allroom(nowpage+1);
	}
}

function shangpage() {
	var nowpage = parseInt($("#now").html());
	if (nowpage>1) {
		allroom(nowpage-1);
	}
}	

function firstpage() {
	allroom(1);
}

function lastpage() {
	var topage = parseInt($("#too").html());
	allroom(topage);
}



