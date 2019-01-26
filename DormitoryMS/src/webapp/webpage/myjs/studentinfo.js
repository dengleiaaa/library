function studentinfo(){ //jquery获取复选框值 
    var sid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	sid=($(this).val());
    $.ajax({
		url:"../stu/stuinfo",
		type:"post",
		data:{
			sid:sid,
		},
		dataType:"json",
		success:function(data){
		$("#studentinfo").empty();
			
			var t = "<div id='stuimg'>"
            +"<img src="+data.stuinfo.s_img+" width='150px' height='150px'>"
            +"</div>"
            +"<table class='table table-hover'>"
            +"<tbody>"
            +"<tr>"
            +"<td style='width: 70px;'>姓名：</td>"
			+"<td>"+data.stuinfo.s_name+"</td>"
			+"<td style='width: 95px;'>性别：</td>"
			+"<td>"+data.stuinfo.s_sex+"</td>"
			+"</tr>"
			+"<tr>"
			+"<td>班级：</td>"
			+"<td>"+data.stuinfo.c_name+"</td>"
			+"<td>联系电话：</td>"
			+"<td>"+data.stuinfo.s_tel+"</td>"
			+"</tr>"
			+"<tr>"
			+"<td>房间：</td>"
			+"<td>"+data.stuinfo.r_address+"</td>"
			+"<td>入住时间：</td>"
			+"<td>"+data.stuinfo.ck_time+"</td>"
			+"</tr>"
			+"</tbody>"
			+"</table>";
                            
	      
			$("#studentinfo").html(t);	
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
    	return;
	}
} 