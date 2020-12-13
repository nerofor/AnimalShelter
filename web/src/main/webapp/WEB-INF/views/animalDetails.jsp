<%--
  Created by IntelliJ IDEA.
  User: gergo
  Date: 2020. 12. 12.
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${animal.id}</title>
</head>
<body>
    <tr><th>id</th><th>name</th><th>type</th><th>status</th><th>description</th></tr>
<table>
    <tr><td>name</td><td>${animal.name}</td></tr>
    <tr><td>type</td><td>${animal.type}</td></tr>
    <tr><td>status</td><td>${animal.status}</td></tr>
    <tr><td>description</td><td>${animal.description}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Home">
</form>
</body>
</html>
