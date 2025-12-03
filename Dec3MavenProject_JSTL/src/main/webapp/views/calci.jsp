<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="Calculate.jsp" method="post">
    <label>First Number:</label>
    <input type="text" name="num1">

    <label>Second Number:</label>
    <input type="text" name="num2">

    <label>Operation:</label>
    <input type="radio" name="op" value="+"> +
    <input type="radio" name="op" value="-"> -
    <input type="radio" name="op" value="*"> *
    <input type="radio" name="op" value="/"> /

    <br><br>
    <input type="submit" value="submit">
</form>

</body>
</html>