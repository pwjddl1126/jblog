<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>

 <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>

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
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected">기본설정</li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-category">카테고리</a></li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-write">글작성</a></li>
				</ul>
				<form action="${pageContext.request.contextPath}/blog/edit"
					method="post">
					<input type="hidden" name="id" value="${authUser.id }" />
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="title"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<td><img
								src="${pageContext.request.contextPath}/assets/images/${blogVo.logo}"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" name="logo"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="기본설정 변경"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>