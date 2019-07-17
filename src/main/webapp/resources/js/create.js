var base_url = window.location.origin;

$(document).ready(function() {
	   $(function(){ 
		   $("#pop").dialog({
	        modal: true,
	        autoOpen: false,
	        title: "Message",
	        width: 300,
	        height: 150
	    });
	   });	
	   $("#result").hide();
	$('body').on('click', '#create', function() {
		   var errorhtml="";
			var lurl = $('#lurl').val();
		   
		   if(lurl == null || lurl == ''){
			   errorhtml = errorhtml + "URL cant be empty\n<br>"; 
		   }
		   if(lurl.substring(0, 7) != 'http://' && lurl.substring(0, 8) != 'https://'){
			   errorhtml = errorhtml + "URL must start with http:// or https://\n<br>";
		   }
		   if(errorhtml != ''){
			   $("#pop").html(errorhtml);
			   $("#pop").dialog('open');
			   return;
		   }
		   console.log(lurl);
		   console.log(window.location.origin);
		   var postData = {};
		   postData['actualURL'] = lurl;
		   console.log(postData);
		   $.ajax({
               url: base_url+'/createSURL',
               type: "POST",
               data: JSON.stringify(postData),
               dataType: "text",
               contentType: "application/json",
               error: function (error) {
            	   $("#pop").html(error);
    			   $("#pop").dialog('open');
               },
               success: function (response) {
            	   $("#surl").html(response);
            	   $("#surl").attr("href",response);
            	   $("#result").show();
               }
           });
		   $('#lurl').val('');
	});
	$('body').on('click', '#copy', function() {
		var $temp = $("<input>");
		  $("body").append($temp);
		  $temp.val($("#surl").text()).select();
		  document.execCommand("copy");
		  $temp.remove();
	});
});



