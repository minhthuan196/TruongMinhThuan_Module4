<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/14/2023
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Translate English to Vietnamese</h1>
<form action="/translate" method="post">
    <input type="text" placeholder="Enter vocabulary want translate" name="input">
    <button>Translate</button>
</form>
<c:if test="${result!=null }">
<p>${result}</p>
</c:if>
<c:if test="${result==null }">
    <p>Not found</p>
</c:if>
</body>
</html>
