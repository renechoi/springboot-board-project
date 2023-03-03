<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		
		<form class="blog-form" id="blog-form" method="post" action="${pageContext.request.contextPath}/blog/create">
			<label class="block-label" for="blogTitle">블로그명</label>
			<input type="text" name="blogTitle"  value="" />

			<input type="submit" value="생성하기">

		</form>
	</div>

</body>


</html>