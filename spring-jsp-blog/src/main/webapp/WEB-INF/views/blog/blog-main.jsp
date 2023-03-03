<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 


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
			<div id="content">
				<div class="blog-content">
					<c:if test="${not empty postVo}">
						<h4>${postVo.postTitle}</h4>
						<p>
						${fn:replace(postVo.postContent, newLine, "<br>") }
						<p>
					</c:if>
					<c:if test="${empty postVo}">
						<h4>등록된 글이 없습니다.</h4>
						<p>
						
						<p>
					</c:if>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList}" var="postVo">
						<li>
							<a href="${pageContext.request.contextPath}/${blogVo.id}?crtCateNo=${param.crtCateNo}&postNo=${postVo.postNo}">${postVo.postTitle}</a> 
							<span>${postVo.regDate}</span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<c:if test="${blogVo.logoFile eq 'default'}">
					<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
				</c:if>
				<c:if test="${blogVo.logoFile ne 'default'}">
					<img src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}">
				</c:if>
			</div>
		</div>

		<div id="navigation">
			<h2><a href="${pageContext.request.contextPath}/${blogVo.id}">카테고리</a></h2>
			<ul>
				<c:forEach items="${cateList}" var="cateVo">
					<li><a href="${pageContext.request.contextPath}/${blogVo.id}?crtCateNo=${cateVo.cateNo}">${cateVo.cateName}</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터-->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
	</div>
</body>
</html>