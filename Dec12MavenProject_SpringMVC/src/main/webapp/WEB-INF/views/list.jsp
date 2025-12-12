<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mphasis.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
<h1>User List</h1>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>UID</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Role</th>
        <th>Email</th>
        <th>Mobile</th>
    </tr>
    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        if (userList != null) {
            for (User u : userList) {
    %>
    <tr>
        <td><%= u.getUid() %></td>
        <td><%= u.getUname() %></td>
        <td><%= u.getPwd() %></td>
        <td><%= u.getRole() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getMobile() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
