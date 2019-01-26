function addclassmotai() {
	$.ajax({
		url:"../class/addclassmotai",
		type:"post",
		data:{
			
		},
		dataType:"json",
		success:function(data){

			$("#addclassmotai").empty();
			
			var y = "<label for='single-select'>带班老师</label>"
                    +"<select id='classestea' class='form-control'>";
			var u = "</select>";
			var t = "";
			for (var i = 0; i < data.tea.length; i++) {
				t+= "<option>"+data.tea[i].tname+"</option>";
			}
			
			var i =y+t+u;
			$("#addclassmotai").html(i);
			
			
			
			
			
			}
			
			
		
	});
}
