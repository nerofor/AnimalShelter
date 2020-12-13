<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${animal.id}</title>
</head>
<body>
<table>
    <tr><td>Name</td><td>${animal.name}</td></tr>
    <tr><td>Type</td><td>${animal.type}</td></tr>
    <tr><td>Status</td><td>${animal.status}</td></tr>
    <tr><td>Cost per day</td><td>${animal.costPerDay}</td></tr>
    <tr><td>Description</td><td>${animal.description}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Back to Home">
</form>
</body>
</html>
