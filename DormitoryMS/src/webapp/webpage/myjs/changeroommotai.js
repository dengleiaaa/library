function changeroommotai(){ //jquery获取复选框值 
    var sid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	sid=($(this).val());
    $.ajax({
		url:"../stu/changeroommotai",
		type:"post",
		data:{
			sid:sid,
		},
		dataType:"json",
		success:function(data){
			$("#studentin").empty();
			$("#canlive").empty();
			
		   var tbody = $("<tbody></tbody>"); 
			var tr1 = $("<tr></tr>");
			var td0 = $("<td style='width: 80px;'>姓名：</td>");
			var td1 = $("<td style='width: 200px;'></td>").text(data.allstu.s_name);
			var td2 = $("<td style='width: 93px;'>性别：</td>");
			var td3 = $("<td style='width: 200px;'></td>").text(data.allstu.s_sex);
			
			tr1.append(td0);
			tr1.append(td1);
			tr1.append(td2);
			tr1.append(td3);
			
			var tr2 = $("<tr></tr>");
			var td4 = $("<td>班级：</td>");
			var td5 = $("<td></td>").text(data.allstu.c_name);
			var td6 = $("<td>原房间：</td>");
			var td7 = $("<td></td>").text(data.allstu.r_address);
			
			tr2.append(td4);
			tr2.append(td5);
			tr2.append(td6);
			tr2.append(td7);
			
			tbody.append(tr1);
			tbody.append(tr2);
			$("#studentin").append(tbody);
		    
		   

			 var j = "<label for='single-select'>选择要更换的房间</label>"
                 +"<select id='changeroomstu' class='form-control'>";
			var k = "</select>";
			var l = "";
			
			if (data.allstu.s_sex=="男") {
				for (var i = 0; i < data.listcanlive.length; i++) {
					if (data.listcanlive[i].r_sextype=="女生宿舍") {
						 data.listcanlive.splice(i, 1); 
					　　　　i--; 
					}
					
				}
			}
			
			if (data.allstu.s_sex=="女") {
				for (var i = 0; i < data.listcanlive.length; i++) {
					if (data.listcanlive[i].r_sextype=="男生宿舍") {
						 data.listcanlive.splice(i, 1); 
					　　　　i--; 
					}
					
				}
			}
			
				for (var i = 0; i < data.listcanlive.length; i++) {
					if (data.allstu.r_address==data.listcanlive[i].r_address) {
						data.listcanlive.splice(i, 1); 
					　　　　i--;
					}
					
				}
			
			for (var i = 0; i < data.listcanlive.length; i++) {
				l+= "<option value='"+data.listcanlive[i].r_id+"'>"+data.listcanlive[i].r_address+"</option>";
			}
			
			var p =j+l+k;
			
			$("#canlive").html(p);
				
			
  			
		}
	});
}); 
    if (sid.length==0) {
    	$("#stumtz").removeAttr("data-toggle","modal")
    	$("#stumtx").removeAttr("data-toggle","modal")
    	$("#stumtc").removeAttr("data-toggle","modal")
    	
    	swal({ 
    		title: "你还没有选择学生！", 
    		text: "1秒后自动关闭。", 
    		timer: 1000, 
    		showConfirmButton: true,
    		allowOutsideClick: true 
    	});
    	/*swal('你还没有选择学生！')*/
    	return;
	}
} 