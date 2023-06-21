<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/13/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${cars}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.brand}</td>
            <td>${c.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
