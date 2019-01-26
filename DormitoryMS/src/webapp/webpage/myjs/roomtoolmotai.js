function roomtoolmotai(){ //jquery获取复选框值 
    var rid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	rid=($(this).val());
    $.ajax({
		url:"../roomtool/roomtoolmotai",
		type:"post",
		data:{
			rid:rid,
		},
		dataType:"json",
		success:function(data){
			$("#toolTable").empty();

			for (var i = 0; i < data.roomtool.length; i++) {
				
			
		   var tbody = $("<tbody></tbody>"); 
			var tr1 = $("<tr></tr>");
			var td0 = $("<td style='width: 52px;'><input name='toolboxs' value="+data.roomtool[i].rt_id+"  type='checkbox'/></td>");
			var td1 = $("<td></td>").text(data.roomtool[i].rt_name);
			var td2 = $("<td class='text-nowrap'></td>").text(data.roomtool[i].rt_time);
			var td3 = $("<td></td>").text(data.roomtool[i].rt_solve);
			
			tr1.append(td0);
			tr1.append(td1);
			tr1.append(td2);
			tr1.append(td3);
			
			tbody.append(tr1);
			$("#toolTable").append(tbody);
		   var h = "<input type='hidden' value="+data.roomtool[i].rt_roomid+"  id='roomidtool'>";
			}
			$("#roomidhidden").html(h);
			
		}
	});
}); 
    if (rid.length==0) {
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