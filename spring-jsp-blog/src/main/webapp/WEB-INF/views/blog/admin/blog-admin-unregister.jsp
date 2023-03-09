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

	<div id="container">
		
		<!-- 블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/basic">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/write">글작성</a></li>
					<li><a href="/user/${authUser.id}/unregister">회원탈퇴</a></li>
				</ul>


				<form class="unregister-form" action="/user/${authUser.id}/unregister" method="post">

					<label class="block-label" for="id">아이디</label>
					<input type="text" name="id"  value="" />

					<label class="block-label" for="password">패스워드</label>
					<input type="password" name="password"  value="" />

					<input type="submit" value="탈퇴하기">
				</form>



			</div>
		</div>


		
		<!-- 푸터-->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	</div>
</body>

</html>