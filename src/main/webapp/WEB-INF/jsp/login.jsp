<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"> type="text/javascript" </script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"> type="text/javascript" </script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/login.js"></script>
<title> Login Page</title>
</head>
<div class="login-page">
  <div class="form">
  	<h2> Please Login</h2>
    <form method="post" id="loginForm">
      <label> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input id="email" name="email" style="width:374px;" type="email" placeholder="name@domain.com"/>
      <br><label> Password &nbsp;&nbsp;&nbsp; </label>  <input id="password" name="password" class="password" type="password" style="width:374px;" placeholder="**********"/> 
    </form>
    <button id="login">Login</button>
  <br><br>
  Not registered! <a href="/register"> click here </a> to create an account
  </div>
</div>
<div id="pop" style="display: none" align = "center">
    This is a jQuery Dialog.
</div>
 </html>
