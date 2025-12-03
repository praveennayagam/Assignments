<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Employee Form</h1>
	<form action="data.jsp">
	<label>Employee Name</label>
	<input type="text" name="ename">
	<label>Employee Id</label>
	<input type="text" name="eid">
	<label>Employee Desg</label>
	<input type="text" name="desg">
	<input type="submit" value="submit">
	</form>
	
	<%application.setAttribute("cname","Mphasis");
		application.setAttribute("address","Bangalore");
	
	%>
	
	
</body>
</html>