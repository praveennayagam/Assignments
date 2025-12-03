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
	<core:set var="name" value="Praveen" ></core:set>
	<core:out value="${name}" />
	<core:if test="${name== 'Praveen'}"><h1>Name is Praveen</h1></core:if>

</body>
</html>