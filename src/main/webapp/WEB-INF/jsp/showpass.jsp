<!DOCTYPE html>

<html lang="en">
<title>Password generator</title>
<link rel="stylesheet" type="text/css"
      href="webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
<body>

<h1>Password generator using AES encryption</h1>
<br>
<p>The generated password is <textarea id="copyPass" rows="1" readonly style="border: none; resize: none; width: 80%; height: 20px">${password}</textarea></p>
<button onclick="copy()">Copy password</button>
<br>
<p>This password contains: </p>
<ul>
    <li>${len} characters</li>
    <li>${spe} special characters</li>
    <li>${low} lowercase letters</li>
    <li>${upp} uppercase letters</li>
    <li>${num} numbers</li>
</ul>
<br>
<p>Add more characters to your password: </p>
<form id="modForm" action="/modPass" method="post">
    <label for="add">Add random characters: </label>
    <input type="number" id="add" name="add" value=0><br>
    <label for="special">Add special characters: </label>
    <input type="number" id="special" name="special" value=0><br>
    <label for="lower">Add lowercase letters: </label>
    <input type="number" id="lower" name="lower" value=0><br>
    <label for="upper">Add uppercase letters: </label>
    <input type="number" id="upper" name="upper" value=0><br>
    <label for="numb">Add numbers: </label>
    <input type="number" id="numb" name="numb" value=0><br>
    <input type="hidden" id="password" name="password" value="0">
</form>
<button value="Modify" onClick="submit()">Modify</button>
<br><br>
<kbd><a href="/password" style="color: white">Generate another password</a></kbd>
<kbd><a href="/" style="color: white">Return to the main page</a></kbd>
<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
<script>
    function copy() {
        var pass = document.getElementById("copyPass");
        pass.select();
        document.execCommand("copy");
    }
    function submit(form) {
        document.getElementById("password").value = document.getElementById("copyPass").value;
        document.getElementById("modForm").submit();
    }
</script>
</body>

</html>