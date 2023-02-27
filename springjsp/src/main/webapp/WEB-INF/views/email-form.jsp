<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="/emails" method="post">
		Last Name(성) <input type="text" name="lastName"><br>
		First Name(이름) <input type="text" name="firstName"><br>
		Email Address <input type="text" name="email"><br> <input
			type="submit" value="등록">
	</form>

	<p>
		<a href="/emails">리스트 바로가기</a>
	</p>

</body>
</html>