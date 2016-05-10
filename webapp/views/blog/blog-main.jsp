<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>

	<div id="container">
	
		<div id="header">
			<h1><a href="${pageContext.request.contextPath }/${blogVo.id}">${blogVo.title}</a></h1>
			<c:import url="/views/include/blogheader.jsp" />
		</div>
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postVo.title }</h4>
					<p>
						${postVo.content }
					<p>
						<form action="${pageContext.request.contextPath }/blog/${blogVo.id}/deletepost" method="post" >
						<input type="hidden" name="no" value="${postVo.no }"/>
						<input type="submit" value="삭제">
						</form>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList }" var="vo" varStatus="status">
					<li><a href="${pageContext.request.contextPath }/${blogVo.id}?category_no=${vo.category_no}&post_no=${vo.no}">${vo.title}</a> <span>${vo.reg_date }</span>	</li>
					</c:forEach>

				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/assets/images/${blogVo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList }" var="vo" varStatus="status">
				<li><a href="${pageContext.request.contextPath }/${blogVo.id}?category_no=${vo.no}">${vo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>