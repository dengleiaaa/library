
function handletool(){ //jquery获取复选框值 
    var rtid=""; 
    $('input[name="toolboxs"]:checked').each(function(){ 
    	rtid=($(this).val());
    	  var rid = $("#roomidtool").val();

    $.ajax({
		url:"../roomtool/handletool",
		type:"post",
		data:{
			rid:$("#roomidtool").val(),
			rtid:rtid
		},
		dataType:"json",
		success:function(data){
			if (data.result == "处理成功") {
				swal(data.result,"","success");
				
				roomtoolmotai();
  				allroom(parseInt($("#now").html()));
  				$('#handleModal').map(function() {//用id选择器选中要关闭的模态框
  			       $(this).modal('hide'); //关闭
  			});
  			
			}
			
			
			
			
  			
		}
	});
}); 
    if (rtid.length==0) {
    	swal({ 
    		title: "你还没有选择学生！", 
    		text: "1秒后自动关闭。", 
    		timer: 1000, 
    		showConfirmButton: true,
    		allowOutsideClick: true 
    	});
    	
    	
    	$('#roomtoolModal').map(function() {//用id选择器选中要关闭的模态框
    	       $(this).modal('hide'); //关闭
    	});
    	
    	
    	return;
	}
} 