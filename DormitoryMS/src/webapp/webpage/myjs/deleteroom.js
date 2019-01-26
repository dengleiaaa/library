function deleteroom(){ //jquery获取复选框值 
    var rid=""; 
   

    $('input[name="boxs"]:checked').each(function(){ 
    	rid=($(this).val());
    $.ajax({
		url:"../room/deleteroom",
		type:"post",
		data:{
			rid:rid,
		},
		dataType:"json",
		success:function(data){
			if (data.result == "该房间还有人住,不能删除") {
				swal(data.result);
				$('#deleteModal').map(function() {//用id选择器选中要关闭的模态框
	  	    	       $(this).modal('hide');
  				 //关闭
  	    	});
  				
  			}
			if (data.result == "删除成功") {
				swal({title:"删除成功！",
			        text:"已成功删除",
			        type:"success"},function(){allroom(parseInt($("#now").html()))}
			    )
					
  			}
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