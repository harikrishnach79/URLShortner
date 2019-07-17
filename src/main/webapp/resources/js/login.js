var base_url = window.location.origin;

$(document).ready(function() {
	   $(function(){ $("#pop").dialog({
	        modal: true,
	        autoOpen: false,
	        title: "Message",
	        width: 300,
	        height: 150
	    });
	   });	
	$('body').on('click', '#login', function() {
		   var errorhtml="";
			var email = $('#email').val();
			var atposition=email.indexOf("@");  
			var dotposition=email.lastIndexOf(".");  
			if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
			  errorhtml = errorhtml + "Please enter valid Email\n<br>";
			  }  
		   var password = $("#password").val();
		   if(email == ''){
			   errorhtml = errorhtml + "Email cant be empty\n<br>"; 
		   }
		   
		   if(password == ''){
			   errorhtml = errorhtml + "Password cant be empty\n<br>";
		   }
		   if(errorhtml != ''){
			   $("#pop").html(errorhtml);
			   $("#pop").dialog('open');
			   return;
		   }
		   var postData = {};
		   postData['email'] = email;
		   postData['password'] = password;
		   console.log(postData);
		   $.ajax({
               url: base_url+'/trylogin',
               type: "POST",
               data: JSON.stringify(postData),
               dataType: "json",
               contentType: "application/json",
               error: function (error) {
            	   $("#pop").html(error);
    			   $("#pop").dialog('open');
               },
               success: function (response) {
            	   if(response.state=='error'){
            		   $("#pop").html(response.message);
            		   $("#pop").dialog('open');}
            	   else{
            		   $("#loginForm").submit();
            	   }
               }
           });
	});
});



