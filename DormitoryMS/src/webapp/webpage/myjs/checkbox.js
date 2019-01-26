
function addmt(){
    	        $("input:checkbox").on("change",function(){
    	            var objName = $(this).attr("name");   //获取name属性的值
    	            /*alert(objName)*/
    	var i = 0;
    	            //依次遍历上下文所有的含有name='"+objName+"'的input
    	            //each中index是当前元素的位置，element是值。
    	            $("input[name='boxs']").each(function(index, element) {
    	                if($(element).is(':checked'))
    	                {$("#stumtz").attr("data-toggle","modal")
    		             $("#stumtx").attr("data-toggle","modal")
    		             $("#stumtc").attr("data-toggle","modal")
    	                    i++; 
    	                }
    	            });
    	            if(i > 1)
    	            { 
    	          /* $("#stumtx").attr("data-toggle","modal")*/       
    	     $("input[type='checkbox']").prop("checked", false)
    	     
    	    $(this).prop("checked", true);            
    	
    	            }
    	        });
    	    }; 
    	
    	