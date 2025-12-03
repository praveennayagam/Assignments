<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="Database connectivity"></c:out>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/mphasisdb" user="root"
		password="root@39" />


	<sql:query var="rs" dataSource="${db}">
		select * from customer;
		</sql:query>
	<!-- CustomerId, Name, Address, PhoneNumber, Email -->
	<c:forEach var="item" items="${rs.rows}">
    CustomerId   : <c:out value="${item.CustomerId}" />
		<br>
    Name         : <c:out value="${item.Name}" />
		<br>
    Address      : <c:out value="${item.Address}" />
		<br>
    PhoneNumber  : <c:out value="${item.PhoneNumber}" />
		<br>
    Email        : <c:out value="${item.Email}" />
		<br>
		<hr>
	</c:forEach>


	<!-- insert query -->


	<%-- <sql:update dataSource="${db}">
    INSERT INTO customer (CustomerId, Name, Address, PhoneNumber, Email)
    VALUES (125, 'barath', 'Chennai', '9876543210', 'barath@mail.com')
</sql:update> --%>

	<!-- update query -->

	<%-- 
<sql:update dataSource="${db}">
    UPDATE customer
    SET Address = 'Mumbai', PhoneNumber = '9998887776'
    WHERE CustomerId = 1;
</sql:update> --%>


	<!-- delete query -->
	<sql:update dataSource="${db}">
    DELETE FROM customer
    WHERE CustomerId = 2;
</sql:update>







</body>
</html>