function addbook() {
	$.ajax({
		url : "book_addbook",
		type : "post",
		data : {
			q : $("#q").val(),
			w : $("#w").val(),
			e : $("#e").val(),
			r : $("#r").val(),
			t : $("#t").val(),
			y : $("#y").val(),
			u : $("#u").val(),
			i : $("#i").val()
		},
		dataType : "json",
		success : function(data) {
			if (data.result == "格式不正确") {
				alert(data.result);
				return;

			}
			if (data.result == "新增成功") {
				alert(data.result);
				window.location.href = "booktype.jsp";
			}

		}

	});
}