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
	$('body').on('click', '#create', function() {
		   var errorhtml="";
		   var name = $('#name').val();
			var email = $('#email').val();
			var atposition=email.indexOf("@");  
			var dotposition=email.lastIndexOf(".");  
			  
		   var password = $("#password").val();
		   var cpassword = $("#cpassword").val();
		   if(name == ''){
			   errorhtml = errorhtml + "Name cant be empty\n<br>";
		   }
		   if(email == ''){
			   errorhtml = errorhtml + "Email cant be empty\n<br>"; 
		   }else{
			   if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){  
					  errorhtml = errorhtml + "Please enter valid Email\n<br>";
					}
		   }
		   if(password == ''){
			   errorhtml = errorhtml + "Password cant be empty\n<br>";
		   }
		   if(cpassword == ''){
			   errorhtml = errorhtml + "Retype Password cant be empty\n<br>";
		   }
		   if(password != '' && cpassword != '' && password != cpassword){
			   errorhtml = errorhtml + "Passwords does not match\n<br>";
		   }
		   if(errorhtml != ''){
			   $("#pop").html(errorhtml);
			   $("#pop").dialog('open');
			   return;
		   }
		   var postData = {};
		   postData['name'] = name;
		   postData['email'] = email;
		   postData['password'] = password;
		   console.log(postData);
		   $.ajax({
               url: base_url+'/createuser',
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
            		   $("#pop").html(response.message + "<br> Please <a href='/login'> click here </a> to login");
            		   $("#pop").dialog('open');
            	   }
            	   else{
            		   var html = response.message + "<br> Please <a href='/login'> click here </a> to login";
            		   $("#pop").html(html);
            		   $("#pop").dialog('open'); 
            		   //$("#loginForm").submit();
            	   }
               }
           });
	});
});