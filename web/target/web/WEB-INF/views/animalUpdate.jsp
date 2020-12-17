<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${animal.name} - update</title
</head>
<table align="center">
    <c:url var="action" value="/update"></c:url>
    <form:form method="post" action="${action}" modelAttribute="animal">
        <form:input type="hidden" path="id"/>
        <tr><td><form:label path="name">Name</form:label></td><td><form:input path="name"/></td></tr>
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
            <td><form:label path="costPerDay">Cost per day (dollar)</form:label></td><td><form:input path="costPerDay"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td><td><form:input path="description"/></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="Add new animal"></td></tr>
    </form:form>
</table>
<body>

</body>
</html>
