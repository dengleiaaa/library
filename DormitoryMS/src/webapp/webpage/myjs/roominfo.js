function roominfo(){ //jquery获取复选框值 
	
	var roomid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	roomid=($(this).val()); 
    	
    $.ajax({
		url:"../room/singleroom",
		type:"post",
		data:{
			roomid:roomid,
		},
		dataType:"json",
		success:function(data){
			
		$("#singleroomrrr").empty();
		$("#srvTable").empty();
		var t= "<table class='table table-hover'>"
	            +"<tbody>"
	            +"<tr>"
	            +"<td style='width: 116px;'>房间地址：</td>"
				+"<td style='width: 200px;'>"+data.singroom.r_address+"</td>"
				+"<td style='width: 116px;'>房间户型：</td>"
				+"<td style='width: 200px;'>"+data.singroom.r_type+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>可容纳人数：</td>"
				+"<td>"+data.singroom.r_population+"</td>"
				+"<td>已住人数：</td>"
				+"<td>"+data.singroom.checkinpeople+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>房租：</td>"
				+"<td>"+data.singroom.r_rent+"/月</td>"
				+"<td>支付方式：</td>"
				+"<td>"+data.singroom.r_renttype+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>房东：</td>"
				+"<td>"+data.singroom.l_name+"</td>"
				+"<td>房东电话：</td>"
				+"<td>"+data.singroom.l_tel+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>房间状态：</td>"
				+"<td>"+data.singroom.r_state+"</td>"
				+"<td>房间类型：</td>"
				+"<td>"+data.singroom.r_sextype+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>租房日期：</td>"
				+"<td>"+data.singroom.r_renttime+"</td>"
				+"</tr>"
				+"</tbody>"
				+"</table>";
			$("#singleroomrrr").html(t);
			
			
			
			/*<tbody>
            <tr>
               <td>韦小宝</td>
               <td class="text-nowrap">gt11</td>
               <td>12356987458</td>
             </tr>
         </tbody>*/
         for (var i = 0; i < data.stu.length; i++) {
			
		
          var tbody = $("<tbody></tbody>"); 
			var tr = $("<tr></tr>");
			var td0 = $("<td></td>").text(data.stu[i].s_name);
			var td1 = $("<td class='text-nowrap'></td>").text(data.stu[i].c_name);
			var td2 = $("<td></td>").text(data.stu[i].s_tel);
			
			tr.append(td0);
			tr.append(td1);
			tr.append(td2);
	
			tbody.append(tr);
			
			$("#srvTable").append(tbody);
         }
         
		}
	});
}); 
    
    
    if (roomid.length==0) {
    	$("#roomq").removeAttr("data-toggle","modal")
    	$("#roomw").removeAttr("data-toggle","modal")
    	$("#roome").removeAttr("data-toggle","modal")
    	swal({ 
    		title: "你还没有选择房间！", 
    		text: "1秒后自动关闭。", 
    		timer: 1000, 
    		showConfirmButton: true,
    		allowOutsideClick: true 
    	});
    	return;
	}
} 