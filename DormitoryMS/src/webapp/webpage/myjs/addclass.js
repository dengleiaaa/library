function addclass() {
	$.ajax({
		url : "../class/addclass",
		type : "post",
		data : {
			name : $("#classesname").val(),
			tea : $("#classestea").val(),
			time : $("#classestime").val(),
		},
		dataType : "json",
		success : function(data) {
			
			if (data.result == "添加失败") {
				swal(data.result);
				return;
				
			}
			if (data.result == "添加成功") {
				swal({title:"添加成功！",
			        text:"已成功添加",
			        type:"success"},function(){allclass(parseInt($("#now").html()))}
			    )
				
			}
			if (data.result == "没有这个老师") {
				swal(data.result);
			
			}

		}

	});
}