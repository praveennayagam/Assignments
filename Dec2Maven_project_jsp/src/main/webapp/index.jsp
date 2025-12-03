<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
<html>
<body>
<h2><%= "Hello World!" %></h2>
<!-- expression tag -->
<h3>current time:<%=new java.util.Date() %></h3>


 <!-- scriptlet tag -->
<%-- <%
int a=56;
int b=78;
 out.println(a+b);
%> --%>

 <!-- declration tag -->
<%! public int add(){
 int a=56;
 int b=78;
 return a+b;
}
%>
<%out.println(add()); %>

<%ArrayList alist=new ArrayList();
alist.add(56);
alist.add("praveen");
out.println(alist);
%>




</body>
</html>
