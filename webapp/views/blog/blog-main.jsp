<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>

 <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	
		<!--div id="header"-->
		
		<div class="navbar-fixed">
		<nav>
		<div class="nav-wrapper">
			<a href="${pageContext.request.contextPath }/${blogVo.id}" class="brand-logo">${blogVo.title}</a>
			<ul class="right hide-on-med-and-down">
			<c:import url="/views/include/blogheader.jsp" />
			</ul>
			</div>
			</nav>
		</div>
		
		<div id="container" >
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>
					
						<c:if test="${not empty postVo.title }">
							${postVo.title }
							
						</c:if>
		
					
					</h4>
					<p>
						${postVo.content }
					<p>
						<form action="${pageContext.request.contextPath }/blog/${blogVo.id}/deletepost" method="post" >
						<input type="hidden" name="no" value="${postVo.no }"/>
						<c:if test="${not empty postVo.no }">
						<input type="submit" value="삭제">
						</c:if>
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
				<strong>넘나 힘든 제이블로그</strong> is powered by 정잉 (c)2016
			</p>
		</div>
	</div>
</body>
</html>