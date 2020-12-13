<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<body>
<h2>Animal Shelter Database</h2>

<c:url var="action" value="/animals"></c:url>
<form action="${action}">
    <input type="submit" value="All animals"/>
</form>
</body>
</html>
