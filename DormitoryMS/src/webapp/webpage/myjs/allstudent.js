function allstudent(spage) {
	$.ajax({
		url:"../stu/allstu",
		type:"post",
		data:{
			spage:spage,
		},
		dataType:"json",
		success:function(data){

			$("#allstudent").empty();
			var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th0 = $("<th>选择</th>");
			var th1 = $("<th>学生姓名</th>");
			var th2 = $("<th>性别</th>");
			var th3 = $("<th>班级</th>");
			var th4 = $("<th>所在房间</th>");
			var th5 = $("<th>联系电话</th>");
			
			trs.append(th0);
			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);
			

			thead.append(trs);
			$("#allstudent").append(thead);
			
			for (var i = 0; i < data.allstu.length; i++) {

				var tbody = $("<tbody></tbody>"); 
				var tr = $("<tr></tr>");
				var td0 = $("<td><input  name='boxs' value="+data.allstu[i].s_id+" type='checkbox' onclick='addmt()'/></td>");
				var td1 = $("<td></td>").text(data.allstu[i].s_name);
				var td2 = $("<td></td>").text(data.allstu[i].s_sex);
				var td3 = $("<td></td>").text(data.allstu[i].c_name);
				var td4 = $("<td></td>").text(data.allstu[i].r_address);
				var td5 = $("<td></td>").text(data.allstu[i].s_tel);
				
				tr.append(td0);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);

				
				tbody.append(tr);
				
				$("#allstudent").append(tbody);
			}
			$("#too").html(data.allpage);
			$("#now").html(data.currentpage);
			
		}
	});
}
allstudent(1);
function xiapage() {
	var nowpage = parseInt($("#now").html());
	var topage = parseInt($("#too").html());
	if (nowpage<topage) {
		allstudent(nowpage+1);
	}
}

function shangpage() {
	var nowpage = parseInt($("#now").html());
	if (nowpage>1) {
		allstudent(nowpage-1);
	}
}	

function firstpage() {
	allstudent(1);
}

function lastpage() {
	var topage = parseInt($("#too").html());
	allstudent(topage);
}




