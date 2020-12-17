<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${animal.name}</title>
</head>
<body>
<table align="center">
    <tr><td>Id:</td><td>${animal.id}</td></tr>
    <tr><td>Name:</td><td>${animal.name}</td></tr>
    <tr><td>Type:</td><td>${animal.type}</td></tr>
    <tr><td>Gender:</td><td>${animal.gender}</td></tr>
    <tr><td>Status:</td><td>${animal.status}</td></tr>
    <tr><td>Cost per month:</td><td>${animal.costPerDay} $</td></tr>
    <tr><td>Description:</td><td>${animal.description}</td></tr>
    <c:if test="${!empty animal.skills}">
        <tr>
            <td>Skill/Skills:</td>
            <td>
            <c:forEach items="${animal.skills}" var="animal">
                    ${animal.skill}
            </c:forEach>
            </td>
        </tr>
    </c:if>
    <tr>
    <td>
        <form action="${pageContext.servletContext.contextPath}/">
            <input type="submit" value="Back to Home">
        </form>
    </td>
    <td>
        <form action="${pageContext.servletContext.contextPath}/animals">
            <input type="submit" value="Back to List">
        </form>
    </td>
    </tr>
</table>
</body>
</html>
