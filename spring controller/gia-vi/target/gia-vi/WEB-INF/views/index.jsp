<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/11/2021
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form:form action="/home" method="post"  modelAttribute="list" >
        <div class="form-check">
                <form:checkbox path="lettuce"/>lettuce
        </div>
        <div class="form-check">
            <form:checkbox path="tomamto"/>tomamto
        </div>
        <div class="form-check">
            <form:checkbox path="sprouts"/>sprouts
        </div>
        <div class="form-check">
            <form:checkbox path="mustard"/>mustard
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>

</body>
</html>
