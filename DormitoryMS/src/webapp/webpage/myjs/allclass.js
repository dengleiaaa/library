function allclass(cpage) {
	$.ajax({
		url:"../class/allclass",
		type:"post",
		data:{
			cpage:cpage,
		},
		dataType:"json",
		success:function(data){
		
			$("#tUsers").empty();
			var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th0 = $("<th>选择</th>");
			var th1 = $("<th>班级名称</th>");
			var th2 = $("<th>开办时间</th>");
			var th3 = $("<th>带班老师</th>");
			
			trs.append(th0);
			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			
			thead.append(trs);
			$("#tUsers").append(thead);
			
			for (var i = 0; i < data.allclass.length; i++) {
				
				var tbody = $("<tbody></tbody>"); 
				var tr = $("<tr></tr>");
				var td0 = $("<td><input  name='boxs' value="+data.allclass[i].c_id+" type='checkbox' onclick='addmt()'/></td>");
				var td1 = $("<td></td>").text(data.allclass[i].c_name);
				var td2 = $("<td></td>").text(data.allclass[i].c_opentime);
				var td3 = $("<td></td>").text(data.allclass[i].t_name);
				
				tr.append(td0);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				
				tbody.append(tr);
				
				$("#tUsers").append(tbody);
			}
			$("#too").html(data.allpage);
			$("#now").html(data.currentpage);
		}
	});
}
allclass(1);
function xiapage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	if (nowpage<topage) {
		allclass(nowpage+1);
	}
}

function shangpage() {
	var nowpage = parseInt($("#now").html());
	if (nowpage>1) {
		allclass(nowpage-1);
	}
}	

function firstpage() {
	allclass(1);
}

function lastpage() {
	var topage = parseInt($("#too").html());
	allclass(topage);
}




