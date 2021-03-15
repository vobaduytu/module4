<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/15/2021
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="uploadFile" modelAttribute="MyFiled" enctype="multipart/form-data">
    File: <form:input path="multipartFile" type="file"/> <br>
    Desciption: <form:input path="description" /> <br>
    <input type="submit">
</form:form>
<h3>${mess}</h3>
</body>
</html>
