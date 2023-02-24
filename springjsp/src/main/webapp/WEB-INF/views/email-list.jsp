<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<table border=1 cellpadding=0 cellspacing=0>
    <tr>
        <th>no</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
    </tr>

    <c:forEach items="${list}" var="emaillist">
        <tr>
            <td>${emaillist.no}</td>
            <td>${emaillist.firstName}</td>
            <td>${emaillist.lastName}</td>
            <td>${emaillist.email}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>