<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/15/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<i>Student data coming soon...</i><br>
<table border="1">


    <tr>
        <td>id</td>
        <td>name</td>
        <td>mobile</td>
        <td>country</td>
    </tr>
    <for:forEach items="${students}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.name}</td>
            <td>${st.mobile}</td>
            <td>${st.country}</td>
        </tr>

    </for:forEach>
</table>
</body>
</html>
