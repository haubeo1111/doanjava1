/**
 * 
 */
 var dd=0;
        function validate(){
      	    	
      	var tendangnhap = document.forms["form"]["tendangnhap"].value;
      	  $.ajax({
      	      type : "POST",
      	      contentType : "application/json",
      	    data:JSON.stringify(tendangnhap),
      	       url : "http://localhost:8081/api/customer/checkten1",
      	       dataType : 'json',
      	       async: false,
      	     success : function(result) {
      	     if(result.tendangnhap=="ten khong ton tai"){
      	    	dd=1;
      	    	 alert("ten dang ky khong ton tai trong quan ly user ");
      	     }else{
      	    	 if(result.tendangnhap=="ten da duoc dang ky"){
      	    	 dd=2;
      	    	 alert("ten da duoc dang ky roi");
      	    	 }
      	    	// event.stopPropagation();
      	    	   }
      	        	},
      	        	
      	      });
      	 
      	  if(dd==1){
      		  return false;
      	  }else{
      		 if( dd==2){
      		  return false;
      		  }else{
      			 alert("dang ky thanh cong ");
      		  }
      	  }
      	//  alert("ten khong ton tai ");
      	//	 return false;
      	  
      	 }
      	  