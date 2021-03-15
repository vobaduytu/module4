<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/15/2021
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="update" method="post" modelAttribute="email">
    <table>
        <tr>
            <td> languages:</td>
            <td><form:select path="languages">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
            </td>
        </tr>
        <br>
        <tr>
            <td>Page Size:</td>
            <td><form:select path="size">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
            </form:select></td>
            <td> email per page</td>
        </tr>
        <tr>
            <td><form:label path = "spams">Spams Filter</form:label></td>
            <td><form:checkbox path="spams" value="Enable spams filter"/></td>
            <td>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" rows="5" cols="20"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="update"></td>
            <td><input type="submit" value="Cancel"></td>
        </tr>
        <tr>${mess}</tr>
    </table>
</form:form>
</body>
</html>
