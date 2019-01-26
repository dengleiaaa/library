function addroom() {
	$.ajax({
		url : "../room/addroom",
		type : "post",
		data : {
			r_address : $("#r_addressss").val(),
			r_type : $("#r_type").val(),
			r_population : $("#r_population").val(),
			r_sextype : $("#r_sextyper").val(),
			r_rent : $("#r_rent").val(),
			r_renttype : $("#r_renttype").val(),
			r_renttime : $("#r_renttime").val(),
			r_state : $("#r_stater").val(),
			l_name : $("#l_name").val(),
			l_tel : $("#l_tel").val(),
			
		},
		dataType : "json",
		success : function(data) {
			if (data.result == "添加失败") {
				swal(data.result);
				return;

			}
			if (data.result == "电话重复,请重新输入") {
				swal(data.result);
				return;

			}
			if (data.result == "添加成功") {
				swal({title:"添加成功！",
			        text:"已成功添加",
			        type:"success"},function(){allroom(parseInt($("#now").html()))}
			    )
				
			}
			
		}

	});
}