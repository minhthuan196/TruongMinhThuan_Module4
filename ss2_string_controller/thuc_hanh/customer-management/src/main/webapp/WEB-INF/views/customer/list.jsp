<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/14/2023
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<h5>There are ${customerList.size()} customers in list</h5>
<a href="create"><h3>Add new Customer</h3></a>
<p>${message}</p>
<table>
    <caption><h1>Customers List</h1></caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="detail?id=${c.id}">${c.name}</a>
            </td>
            <td>
                <c:out value="${c.email}"/>
            </td>
            <td>
                <c:out value="${c.address}"/>
            </td>
            <td>
                <a href="edit?id=${c.id}">Edit</a>
            </td>
            <td>
                <a href="delete?id=${c.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
