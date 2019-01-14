function returnbook(bbid) {
	$.ajax({
		url:"book_returnbook",
		type:"post",
		data:{
			bid:bbid
		},
		dataType:"json",
		success:function(data){
			
			if (data.result == "还书成功") {
				alert(data.result);
				window.location.reload();
			}
			

			}
		});
}

