function logoff() {
	$.ajax({
		url:"logoff",
		type:"post",
		data:{},
		dataType:"json",
		success:function(data){
			if (data == "已注销") {
				alert(data.results);
			}
			window.location.href = "../index.html";
			
			
			
			
			
		}
		
	});
}