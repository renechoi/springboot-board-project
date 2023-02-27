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

    <c:forEach items="${emails}" var="emails">
        <tr>
            <td>${emails.no}</td>
            <td>${emails.firstName}</td>
            <td>${emails.lastName}</td>
            <td>${emails.email}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>