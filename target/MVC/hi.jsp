<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello ${name}</h1>
<form action="add">
 <input type="text" name="color" placeholder="Enter Color"><br>
<input type="text" name="size" placeholder="Size"><br>
<input type="text" name="gender" placeholder="Gender"><br>
<input type="text" name="outputPref" placeholder="OutPut Preference"><br>
<input type="submit">
</form>
</body>
</html>