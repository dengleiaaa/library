function alterbook(bbid) {
	$.ajax({
		url:"book_alterbook",
		type:"post",
		data:{
			bid:bbid,
			desc:$("#desc").val(),
			author:$("#author").val()
			},
		dataType:"json",
		success:function(data){
			if (data.result == "修改成功") {
				window.location.href = "booktype.jsp";
			}
			alert(data.result);
			
		}
		
	});
}