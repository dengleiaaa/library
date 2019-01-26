function deletealert(){ //jquery获取复选框值 
    var sid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	sid=($(this).val());
  
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

function deletealertroom(){ //jquery获取复选框值 
    var sid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	sid=($(this).val());
  
}); 
    if (sid.length==0) {
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