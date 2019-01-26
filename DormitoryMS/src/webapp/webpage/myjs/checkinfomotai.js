function checkinfomotai() {
	$.ajax({
		url:"../room/checkinfomotai",
		type:"post",
		data:{
			
		},
		dataType:"json",
		success:function(data){
			$("#classselect").empty();
			$("#roomcanlive").empty();
			var y = "<label for='single-select'>班级</label>"
                    +"<select id='sclass' class='form-control'>";
			var u = "</select>";
			var t = "";
			for (var i = 0; i < data.classs.length; i++) {
				t+= "<option>"+data.classs[i].cname+"</option>";
			}
			
			var i =y+t+u;
			$("#classselect").html(i);
			
			
			
            var j = "<label for='single-select'>房间</label>"
                  +"<select id='sroom' class='form-control'>";
			var k = "</select>";
			var l = "";
			
			if ($("#ssex").val()=="男") {
				for (var i = 0; i < data.listcanlive.length; i++) {
					if (data.listcanlive[i].r_sextype=="女生宿舍") {
						 data.listcanlive.splice(i, 1); 
					　　　　i--; 
					}
					
				}
			}
			
			if ($("#ssex").val()=="女") {
				for (var i = 0; i < data.listcanlive.length; i++) {
					if (data.listcanlive[i].r_sextype=="男生宿舍") {
						 data.listcanlive.splice(i, 1); 
					　　　　i--; 
					}
					
				}
			}
			
			for (var i = 0; i < data.listcanlive.length; i++) {
				l+= "<option>"+data.listcanlive[i].r_address+"</option>";
			}
			
			var p =j+l+k;
			
			$("#roomcanlive").html(p);
			
			}
			
			
		
	});
}
