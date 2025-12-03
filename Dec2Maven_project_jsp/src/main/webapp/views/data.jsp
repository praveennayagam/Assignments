<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Employee Name:<%=request.getParameter("ename") %> </h3>
	<h3>Employee Id: <%=request.getParameter("eid") %></h3>
	<h3>Employee Desg: <%=request.getParameter("desg") %></h3>
	<h3>Company Name:<%=application.getAttribute("cname")%></h3>
	<h3>Address:<%=application.getAttribute("address") %></h3>
</body>
</html>