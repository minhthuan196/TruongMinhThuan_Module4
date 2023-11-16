<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/16/2023
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Setting</h1>
<form:form action="/result" method="post" modelAttribute="emailSetting">
    <div class="d-flex">
        <p>Languages</p>
        <form:select cssStyle="width: 200px" itemValue="${emailSetting.languages}" path="languages"
                     class="mx-3 form-select"
                     aria-label="Default select example">
            <form:options items="${languages}"/>
        </form:select>
    </div>
    <div class="d-flex">
        <p>Page size</p>
        <p>Show </p>
        <form:select cssStyle="width: 100px" itemValue="${emailSetting.pageSize}" path="pageSize"
                     class=" mx-3 form-select"
                     aria-label="Default select example">
            <form:options items="${pageSize}"/>
        </form:select>
        <p> emails per page</p>

    </div>
    <div class="d-flex">
        <p>Spams filter: </p>
        <form:checkbox class="mx-3" path="spamsFilter" value="${emailSetting.spamsFilter}"/>
        <p> Enable spams filter</p>
    </div>
    <div class="d-flex">
        <p>Signature</p>
        <form:textarea class="mx-3" path="signature" value="${emailSetting.signature}"/>
    </div>
    <form:button>Update</form:button>
</form:form>
</body>
</html>
