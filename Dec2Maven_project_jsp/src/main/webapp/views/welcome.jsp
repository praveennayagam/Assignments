<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:red">welcome</h1>
<h3> UserName:<% String uname=request.getParameter("uname"); %></h3>
<h3> Password:<%String pwd =request.getParameter("pwd");%></h3>
<%
	if(uname.equals("praveen") && pwd.equals("pwd")){
		session.setAttribute("uname",uname);
		response.sendRedirect("Success.jsp");
	}

	else
		response.sendRedirect("Error.jsp");


%>


</body>
</html>