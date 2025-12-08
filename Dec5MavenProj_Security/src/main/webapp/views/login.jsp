<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="j_security_check" method="post">
<label>UserName:</label>
<input type="text" name="j_username">
<label>Password:</label>
<input type="password" name="j_password">
<input type="submit" value="login">

</body>
</html>