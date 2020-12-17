<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new animal</title>
</head>
<body>
<table align="center">
    <thead>Please give every information. Thank you! :)</thead>
<form:form method="post" action="/newAnimal" modelAttribute="animal">
    <tr><td><form:label path="name">Name</form:label></td>
        <td><form:input path="name"/></td></tr>
    <tr><td>Type of animal</td>
        <td>
        <form:select path="type">
            <form:options items="${type}"/>
        </form:select>
         </td>
    </tr>
    <tr><td>Gender</td>
        <td>
        <form:select path="gender">
            <form:options items="${gender}"/>
        </form:select>
        </td>
    </tr>
    <tr><td></td>
        <td>
        <form:select path="color">
            <form:options items="${color}"/>
        </form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="dateOfBirth">Date of birth</form:label></td><td><form:input type="date" path="dateOfBirth"/></td>
    </tr>
    <tr><td>Status</td>
        <td>
        <form:select path="status">
            <form:options items="${status}"/>
        </form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="costPerDay">Cost per day (dollar)</form:label></td>
        <td><form:input path="costPerDay"/></td>
    </tr>
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description"/></td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.servletContext.contextPath}/addAnimal">
                <input type="submit" value="Add animal">
            </form>
            </form:form>
        </td>
    </tr>
</table>
</body>
</html>
