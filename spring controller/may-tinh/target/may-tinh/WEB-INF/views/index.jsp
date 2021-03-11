<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/11/2021
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%--@elvariable id="cac" type=""--%>
<h1>Calculator</h1>

<form action="/process" method="post">

    <div class="form-group">
        <input type="number" class="form-control"  name="t1"  >
    </div>

    <br>
    <div class="form-group">
        <select class="form-control" name="operator">
            <option value="+" >Addition(+)</option>
            <option value="-" >Subtraction(-)</option>
            <option value="*" >Multiplication(*)</option>
            <option value="/" >Divison(/)</option>
        </select>
    </div>
    <div class="form-group">
        <input type="number" class="form-control"  name="t2" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <h3>Result: ${result}</h3>

</form>
</body>
</html>
