<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/10/2021
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<%--@elvariable id="customer" type="com"--%>
<from:form  action="/edit" method="post" modelAttribute="customer">
    <from:input path="id" type="number"/><br>
    <from:input type="text" path="name"/><br>
    <from:input type="email" path="email"/><br>
    <from:input path="address"/><br>
    <input type="submit" value="Send">
</from:form>
</body>
</html>