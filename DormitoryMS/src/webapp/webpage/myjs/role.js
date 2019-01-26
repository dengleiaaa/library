function allrole() {
	$.ajax({
		url:"../user/role",
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
			$("#roletable").empty();
	
            var thead = $("<thead></thead>");
			var trs = $("<tr></tr>");
			var th0 = $("<th style='width: 53px;'>选择</th>");
			var th1 = $("<th style='width: 20px;'>ID</th>");
			var th2 = $("<th style='width: 60px;'>账号</th>");
			var th3 = $("<th style='width: 60px;'>密码</th>");
			var th4 = $("<th>拥有的权限</th>");
			var th5 = $("<th style='width: 20px;'>禁用</th>");
			var th6 = $("<th style='width: 160px;'>角色</th>");
			
			trs.append(th0);
			trs.append(th1);
			trs.append(th2);
			trs.append(th3);
			trs.append(th4);
			trs.append(th5);
			trs.append(th6);

			thead.append(trs);
			$("#roletable").append(thead);
			
			
			/*if (data.userrole[i].r_role=="data.userrole[i].r_role") {
				for (var i = 0; i < data.allrole.length; i++) {
					if (data.listcanlive[i].r_sextype=="女生宿舍") {
						 data.listcanlive.splice(i, 1); 
					　　　　i--; 
					}
					
				}
			}
			for (var i = 0; i < data.userrole.length; i++) {
				if (data.userrole[i].r_role==data.allrole.r_role)
			
			}*/
			
			
			var t = "";
			for (var i = 0; i < data.allrole.length; i++) {
					t+= "<option value='"+data.allrole[i].r_id+"'>"+data.allrole[i].r_role+"</option>";
				}
			
			
			for (var i = 0; i < data.userrole.length; i++) {

				var y = "<select id='sclass"+data.userrole[i].u_id+"' class='form-control'>";
				var u = "</select>";
				var x =y+t+u;
				
				var tbody = $("<tbody></tbody>"); 
				var tr = $("<tr></tr>");
				var td0 = $("<td><input  name='boxs' value="+data.userrole[i].u_id+" type='checkbox'/></td>");
				var td1 = $("<td></td>").text(data.userrole[i].u_id);
				var td2 = $("<td></td>").text(data.userrole[i].u_acc);
				var td3 = $("<td></td>").text(data.userrole[i].u_pass);
				var td4 = $("<td></td>").text(data.userrole[i].r_role);
				var td5 = $("<td><button class='btn btn-outline-info' style='margin-left: 1px;'>禁用</button></td>");
				var td6 = $("<td><div class='form-group' id='allrolesel'>"+x+"</div></td>");
				
				tr.append(td0);
				tr.append(td1);
				tr.append(td2);
				tr.append(td3);
				tr.append(td4);
				tr.append(td5);
				tr.append(td6);
				
				tbody.append(tr);
				
				$("#roletable").append(tbody);
			}

		}	
		
	});
}
allrole();
