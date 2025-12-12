<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="addUser" method="post">
  <label for="name">Name:</label>
  <input type="text" id="uname" name="uname">
  <br><br>

 <label for="pwd">Password:</label>
  <input type="password" id="pwd" name="pwd">
  <br><br>

<label for="role">Role:</label>
  <input type="text" id="role" name="role">
  <br><br>
  
  <label for="email">Email:</label>
  <input type="email" id="email" name="email">
  <br><br>

  <label for="mobile">MobileNumber:</label>
  <input type="text" id="mobile" name="mobile">
  <br><br>


 



  <input type="submit" value="Sign Up">
</form>

</body>
</html>