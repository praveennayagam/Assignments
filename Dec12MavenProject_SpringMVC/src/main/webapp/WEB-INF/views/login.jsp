<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

  <div>
    <h1>Login Application</h1>

    <form method="post" id="loginform" onsubmit=" return login()">
   
      <label for="uname">UserName:</label>
      <input type="text" name="uname" id="uname">
      <br><br>

      <label for="pwd">Password:</label>
      <input type="password" name="pwd" id="pwd">
      <br>
      
     <select id="role" name="role">
    <option value="admin">Admin</option>
    <option value="user">User</option>
    <option value="manager">Manager</option>
</select>


      <input type="submit" value="login">
    </form>
    
    
    <script type="text/javascript">
    
    function login()
    {
    	let f =document.getElementById("loginform");
    	let role =document.getElementById("role").value;
    	f.action="home/"+role;
    	return true;
    }
    
    
    </script>
  </div>

</body>


</html>