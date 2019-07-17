<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"> type="text/javascript" </script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"> type="text/javascript" </script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/register.js"></script>
<title> Login Page</title>
</head>
<div class="login-page">
  <div class="form">
  	<h2> Please Register</h2>
    <form method="post" id="loginForm">
    	<label> Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input id="name" name="name" style="width:374px;" type="text" placeholder="Name"/>
      <label> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input id="email" name="email" style="width:374px;" type="email" placeholder="name@domain.com"/>
      <br><label> Password &nbsp;&nbsp;&nbsp; </label>  <input id="password" name="password" class="password" type="password" style="width:374px;" placeholder="**********"/>
      <label> Retype Pass</label>  <input id="cpassword" name="cpassword" class="cpassword" type="password" style="width:374px;" placeholder="retype password"/> 
    </form>
    <button id="create">Register</button>
  <br><br>
  Already registered! <a href="/login"> click here </a> to login.
  </div>
</div>
<div id="pop" style="display: none" align = "center">
    This is a jQuery Dialog.
</div>
 </html>
