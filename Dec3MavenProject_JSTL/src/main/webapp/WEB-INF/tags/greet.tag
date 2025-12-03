<%@ tag description="to greet user" pageEncoding="UTF-8"%>
<%@ attribute name="user" required="true" %>
<%@ attribute name="company" required="true" %>
<h1>Hello ${user} , welcome to custom tags demo</h1>
<h2>${user} works in ${company }</h2>