<!DOCTYPE html>

<html lang="en">
<title>Password generator</title>
<link rel="stylesheet" type="text/css"
      href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
<body>

<h1>Password generator using AES encryption</h1>

<form action="/showpassword" method="post">
    <label for="word">Write one or more words to generate the password: </label>
    <input type="text" id="word" name="word" placeholder="Some words..."><br>
    <input type="submit" value="Generate">
</form>
<br>
<br>
<kbd><a href="/" style="color: white">Return to the main page</a></kbd>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
</body>

</html>