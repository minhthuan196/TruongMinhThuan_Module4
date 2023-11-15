<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/15/2023
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="m-4">
    <h1>Sandwich Condiments</h1>
    <form method="post" action="/save">
        <c:forEach var="sandwich" items="${sandwichCondimentsList}">
            <div class="form-check">
                <input name="condiment" class="form-check-input" type="checkbox" value="${sandwich.name}"
                       id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                        ${sandwich.name}
                </label>
            </div>
        </c:forEach>
        <button type="submit">Save</button>
    </form>
    <p>Result: </p>
    <c:forEach var="cmt" items="${condiment}">
        ${cmt},
    </c:forEach>
</div>
</body>
</html>
