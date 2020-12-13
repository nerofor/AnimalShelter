<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Animals</title>
</head>
<body>

<c:url var="action" value="/byType"></c:url>
<c:if test="${!empty animals}">
    <table frame="border" rules="all">
        <tr><th>id</th><th>name</th><th>type</th><th>status</th><th>description</th></tr>
        <c:forEach items="${animals}" var="animal">
            <tr><td><a href="${pageContext.servletContext.contextPath}/animal/${animal.id}"></a></td><td>${animal.name}</td><td>${animal.type}</td><td>${animal.status}</td><td>${animal.description}</td></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty animals}">
    <c:out value="Do not take care any animals."/>
</c:if>
<form action="${pageContext.servletContext.contextPath}/addAnimal">
    <input type="submit" value="Add new animal"/>
</form>
</body>
</html>