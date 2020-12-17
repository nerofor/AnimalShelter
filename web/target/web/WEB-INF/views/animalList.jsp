<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Animals</title>
</head>
<body>

<c:url var="action" value="/byType"></c:url>
<c:if test="${!empty animals}">
    <table frame="border" rules="all" align="center">
        <tr><th>name</th><th>type</th><th>Gender</th><th>status</th><th colspan="2"></th></tr>
        <c:forEach items="${animals}" var="animal">
            <tr><td><a href="${pageContext.servletContext.contextPath}/animal/${animal.id}">${animal.name}</a></td>
                <td>${animal.type}</td><td>${animal.gender}</td><td>${animal.status}</td>
                <td><a href="${pageContext.servletContext.contextPath}/updateById/${animal.id}">Update</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/deleteById/${animal.id}">Delete</a></tr>
        </c:forEach>
        <tr>
            <td align="center" colspan="6">
                <form action="${pageContext.servletContext.contextPath}/">
                    <input type="submit" value="Back to Home">
                </form>
            </td>
        </tr>
    </table>
</c:if>
<c:if test="${empty animals}">
    <c:out value="Do not take care any animals."/>
</c:if>
</body>
</html>
