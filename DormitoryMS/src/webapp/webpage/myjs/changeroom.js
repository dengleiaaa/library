function changeroom(){ //jquery获取复选框值 
    var sid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	sid=($(this).val());
    $.ajax({
		url:"../stu/changeroom",
		type:"post",
		data:{
			sid:sid,
			rid:$("#changeroomstu").val()
		},
		dataType:"json",
		success:function(data){
			if (data.result == "换房成功") {
				swal({title:"换房成功！",
			        text:"已成功换房",
			        type:"success"},function(){allstudent(parseInt($("#now").html()))}
			    )
  			}
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