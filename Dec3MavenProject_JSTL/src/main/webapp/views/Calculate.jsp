<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculation Result</title>
</head>
<body>

<core:set var="num1" value="${param.num1}" />
<core:set var="num2" value="${param.num2}" />
<core:set var="op" value="${param.op}" />


<core:choose>
    <core:when test="${op == '+'}">
        Result: ${num1 + num2}
    </core:when>
    <core:when test="${op == '-'}">
        Result: ${num1 - num2}
    </core:when>
    <core:when test="${op == '*'}">
        Result: ${num1 * num2}
    </core:when>
    <core:when test="${op == '/'}">
        Result: ${num1 / num2}
    </core:when>
    <core:otherwise>
        Invalid operation
    </core:otherwise>
</core:choose>

</body>
</html>
