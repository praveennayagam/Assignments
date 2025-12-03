<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
    <core:out value="My company name is ${applicationScope.cname}" />
    
    <core:remove var="cname" scope="application"/>

    <core:out value="After removing My company name is ${applicationScope.cname}" />
</body>
</html>
