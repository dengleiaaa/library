	function addcheckinfo() { 
		if(!(/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/.test($("#stel").val()))){ 
  		  swal("不是正确的手机号"); 
  		  return; 
  		 } 
		
		
		/*var formData = new FormData($('#fileupform')[0]);*/
		var formdata = new FormData();
		
		  formdata.append('file', $("#fileupform").prop("files")[0]); //上传文件
	      formdata.append('sname', $('#sname').val()); 
	      formdata.append('ssex', $('#ssex').val());
	      formdata.append('sclass', $('#sclass').val());
	      formdata.append('stel', $('#stel').val());
	      formdata.append('sroom', $('#sroom').val());
	      formdata.append('sdate', $('#sdate').val());

      $.ajax({
    	url : "../stu/addcheckinfo",
  		type : "post",
  		data :formdata,
  		cache: false,
        processData: false,
        contentType: false,
          dataType:'json',
          success: function(data){
        	  if (data.result == "该房间人数已满,请选择其他房间") {
    				swal(data.result);
    				
    				
    			}
        	  if (data.result == "手机号已使用,请更换") {
        		  swal(data.result);
  				
  				
  			}
        	  
        	  if (data.result == "上传头像失败") {
        		  swal(data.result);
  				return;
  				
  			}
        	  if (data.result == "请选择您的头像") {
  				 swal(data.result);
  			}
  			if (data.result == "添加成功") {
  				$('#myModal').map(function() {//用id选择器选中要关闭的模态框
   			       $(this).modal('hide'); //关闭
   			});
  				swal({title:"添加成功！",
			        text:"已成功添加",
			        type:"success"},function(){allstudent(parseInt($("#now").html()))}
			    )
  				
  			}
          }
      });
	}