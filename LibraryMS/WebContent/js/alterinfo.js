function alterinfo(bbid) {
	$.ajax({
		url:"book_alterinfo",
		type:"post",
		data:{
			bid:bbid
			},
		dataType:"json",
		success:function(data){
			$("#modaldel").empty();

			for (var i = 0; i < data.abklit.length; i++) {
			var info = "<tr>"
				+"<td>id</td>"
				+"<td>"+data.abklit[i].bid+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>书名</td>"
				+"<td>"+data.abklit[i].bname+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>作者</td>"
				+"<td>"+data.abklit[i].bauthor+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='text' value='' id='author' placeholder='请输入你要修改的内容'></td>"
				+"</tr>"
				+"<tr>"
				+"<td>描述</td>"
				+"<td>"+data.abklit[i].bdesc+"&nbsp&nbsp&nbsp&nbsp<input type='text' value='' id='desc' placeholder='请输入你要修改的内容'></td>"
				+"</tr>"
				+"<tr>"
				+"<td>价钱</td>"
				+"<td>￥"+data.abklit[i].bprice+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>出版社</td>"
				+"<td>"+data.abklit[i].bpress+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>出版日期</td>"
				+"<td>"+data.abklit[i].bpdate+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>数量</td>"
				+"<td>"+data.abklit[i].bnum+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>分类</td>"
				+"<td>"+data.abklit[i].btype+"</td>"
				+"</tr>";

				$("#alterinfo").html(info);

				var button = $("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>")
				var button1 = $("<button type='button' class='btn btn-primary' onclick='alterbook("+data.abklit[i].bid+")'>提交修改</button>")

				$("#modaldel").append(button);
				$("#modaldel").append(button1);		
			}
	
			}
		});
}
