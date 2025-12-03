<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<core:forEach var="n" begin="1" end="10">
    ${n}
</core:forEach>
<br>
	<core:forTokens var ="item" items="Praveen,Barath,Saro,Irfan" delims=",">
   ${item}
</core:forTokens>
	
	<br>

	<core:import url="Success.jsp"></core:import>
		<br>
	<core:set var="imgPath" value="Downloads/logo.png" />

    <img src="<core:out value='${imgPath}'/>" alt="Profile Image">



</body>
</html>