<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<core:set var="today" value="${Date() }"></core:set>
	<core:out value="${today}"></core:out><br>
	
	<fmt:formatDate value="${today }" pattern="dd MMM yyyy"/>


	

</body>
</html>