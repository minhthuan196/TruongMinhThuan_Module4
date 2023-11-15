<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/15/2023
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<h1>Calculator</h1>
<form method="post" action="/calculator">
  <div class="d-flex">
    <input type="number" name="number1" placeholder="Enter number 1">
    <input type="number" name="number2" placeholder="Enter number 1">
  </div>
  <div class="btn-group my-2" role="group" aria-label="Basic example">
    <button type="submit" name="calculator" value="addition" class="btn btn-primary">Addition(+)</button>
    <button type="submit" name="calculator" value="subtraction" class="btn btn-Warning">Subtraction(-)</button>
    <button type="submit" name="calculator" value="multiplication" class="btn btn-Success">Multiplication(*)</button>
    <button type="submit" name="calculator" value="division" class="btn btn-Danger">Division(/)</button>
  </div>
</form>
<p>RESULT: ${result}</p>
</body>
</html>
