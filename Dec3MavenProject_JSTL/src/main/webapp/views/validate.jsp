<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String uname = request.getParameter("uname");
    String pwd = request.getParameter("pwd");
%>

<core:choose>
    <core:when test="${param.uname == 'Praveen' and param.pwd == '12345'}">
        <h1>Authenticated Successfully</h1>
        <core:redirect url="Success.jsp">
            <%-- <core:param name="uname" value="${param.uname}" /> --%>
        </core:redirect>
    </core:when>

    <core:otherwise>
        <h1 style="color:red">Invalid Credentials</h1>
    </core:otherwise>
</core:choose>

</body>
</html>