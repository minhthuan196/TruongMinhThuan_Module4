<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/16/2023
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Language: ${emailSetting.languages}</p>
<p>Page size: ${emailSetting.pageSize}</p>
<div>
    Spam filter:
    <c:if test="${emailSetting.spamsFilter == true}">
        <input checked type="checkbox">
    </c:if>
    <c:if test="${emailSetting.spamsFilter == false}">
        <input type="checkbox">
    </c:if>
</div>
<p>Signature: ${emailSetting.signature}</p>
<a href="/">Back setting</a>
</body>
</html>
