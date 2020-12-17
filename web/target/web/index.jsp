<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<body>
<h2 align="center">Animal Shelter Database</h2>
<p align="center">
    Choose options:<br/>
    <c:url var="action" value="/animals"></c:url>
    <form action="${action}">
        <input type="submit" value="All animals"/>
    </form>
    <form action="${pageContext.servletContext.contextPath}/addAnimal">
        <input type="submit" value="Add new animal"/>
    </form>
    <form action="${pageContext.servletContext.contextPath}/deleteAnimal">
        <input type="submit" value="Delete animal by name"/>
    </form>
    <form action="${pageContext.servletContext.contextPath}/deleteAnimal">
        <input type="submit" value="Update animal by name"/>
    </form>
</p>
</body>
</html>
