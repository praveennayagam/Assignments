<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String user="Praveen" ;
	pageContext.setAttribute("user", user);

	%>
	<%=pageContext.getAttribute("user") %>
	<h3><%=page.getClass() %></h3>
</body>
</html>