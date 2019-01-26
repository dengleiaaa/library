function deleteclass(){ //jquery获取复选框值 
    var cid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	cid=($(this).val());
    $.ajax({
		url:"../class/deleteclass",
		type:"post",
		data:{
			cid:cid,
		},
		dataType:"json",
		success:function(data){
			if (data.result == "该班级还有学生,不能删除") {
			
				swal(data.result);
  				
  			}
			if (data.result == "删除成功") {
				swal({title:"删除成功！",
			        text:"已成功删除",
			        type:"success"},function(){allclass(parseInt($("#now").html()))}
			    )
				
  				
  			}
  			
		}
	});
}); 
    if (cid.length==0) {
    	swal({ 
    		title: "你还没有选择班级！", 
    		text: "1秒后自动关闭。", 
    		timer: 1000, 
    		showConfirmButton: true,
    		allowOutsideClick: true 
    	});
    	return;
	}
} 

