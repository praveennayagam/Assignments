<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
</head>
<body>

	<h1>Welcome to my Spring Application</h1>

	<h1>Hello ${Username}</h1>

	<form onsubmit="return info()" id="userForm">
		<input type="submit" value="userInfo">

	</form>

	<script type="text/javascript">
    
    function info()
    {
    	let f =document.getElementById("userForm");
    	/* let role =document.getElementById("role").value; */
    	f.action="userInfo/${Username}";
    	return true;
    }
    
    </script>

	
	
</body>



</html>