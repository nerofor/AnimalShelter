<%--
  Created by IntelliJ IDEA.
  User: gergo
  Date: 2020. 12. 12.
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add animal</title>
</head>
<body>
<form:form method="post" action="addAnimal" modelAttribute="animal">
    <form:label path="name">Name</form:label>
    <form:input path="name"/>
    <form:select path="status">
        <form:options items="${status}"/>
    </form:select>
    <form:select path="type">
        <form:options items="${type}"/>
    </form:select>
    <form:label path="description">Description</form:label>
    <form:input path="description"/>
</form:form>
</body>
</html>
