<%@ tag description="factorial" pageEncoding="UTF-8"%>
<%@ attribute name="num" required="true" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="fact" value="1" />
<c:forEach var="i" begin="1" end="${num}">
    <c:set var="fact" value="${fact * i}" />
</c:forEach>

Result: <c:out value="${fact}" />
