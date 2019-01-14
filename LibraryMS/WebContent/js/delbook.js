function delbook(bbid) {
	$.ajax({
		url:"book_delbook",
		type:"post",
		data:{
			bid:bbid
			},
		dataType:"json",
		success:function(data){
			alert(data.result);
			window.location.href = "booktype.jsp";
		}
		
	});
}