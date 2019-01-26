function changerole(){ //jquery获取复选框值 
    var uid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	uid=($(this).val());
    	
    $.ajax({
		url:"../user/changerole",
		type:"post",
		data:{
			uid:uid,
			roleid:$('#sclass'+uid).val()
		},
		dataType:"json",
		success:function(data){
			if (data.result == "更改角色成功") {
				allrole();
				swal({ 
		    		title: "更改角色成功！", 
		    		text: "1秒后自动关闭。", 
		    		timer: 1000, 
		    		showConfirmButton: true,
		    		allowOutsideClick: true 
		    	});
  			
  				
  			}
			
			
			
			
  			
		}
	});
}); 
    if (uid.length==0) {
    	
    	swal({ 
    		title: "你还没有选择用户！", 
    		text: "1秒后自动关闭。", 
    		timer: 1000, 
    		showConfirmButton: true,
    		allowOutsideClick: true 
    	});
    	return;
	}
} 