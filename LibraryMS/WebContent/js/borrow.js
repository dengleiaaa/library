function borrow(bbid) {
	$.ajax({
		url:"book_borrow",
		type:"post",
		data:{
			bid:bbid,
			},
		dataType:"json",
		success:function(data){
			alert(data.result);
			
			
			/*if (data.result == "该书已借完") {
				alert(data.result);
			}*/
			
			
		}
		
	});
}