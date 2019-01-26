function addtool(){ //jquery获取复选框值 
    var rid=""; 
    $('input[name="boxs"]:checked').each(function(){ 
    	rid=($(this).val());
    $.ajax({
		url:"../roomtool/addtool",
		type:"post",
		data:{
			rid:rid,
			tooldate:$("#tooldate").val(),
			tooldesc:$("#tooldesc").val()
		},
		dataType:"json",
		success:function(data){
			if (data.result == "添加成功") {
				swal(data.result,"","success");
  				roomtoolmotai();
  				allroom(parseInt($("#now").html()));
  			}
			if (data.result == "请输入后在提交") {
  				swal(data.result);
  			}
  			
		}
	});
}); 
    if (rid.length==0) {
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