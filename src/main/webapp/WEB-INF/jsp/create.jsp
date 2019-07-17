<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"> type="text/javascript" </script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.min.js"> type="text/javascript" </script>
<link href="resources/css/create.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/create.js"></script>
<title>Create Short URL</title>
</head>
<div class="login-page">
  <div class="form">
  	<h2> Please enter your URL</h2>
    <form>
      <label> URL to short &nbsp;&nbsp;&nbsp;</label> 
      <input id="lurl" style="width:500px;" type="text" placeholder="http://google.com"/>
    </form>
    <button style="width:200px;" id="create">Shorten URL</button>
    <br>
    <br>
  <div id="result">
  	<a id="surl" href="" ></a>
  	<button style="border:none;background:none;cursor: pointer;"><img id="copy" src="/resources/images/clipboard.png" alt="Copy" height="20" width="25"></button>
  </div>
  </div>
  
</div>
<div id="pop" style="display: none" align = "center">
    This is a jQuery Dialog.
</div>
 </html>