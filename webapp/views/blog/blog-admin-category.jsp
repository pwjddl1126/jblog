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
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-basic">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-write">글작성</a></li>
				</ul>
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${vo.no }</td>
							<td>${vo.name }</td>
							<td>${vo.post_count }</td>
							<td>${vo.description }</td>
							<td>
								<a href="${pageContext.request.contextPath}/blog/delete/${authUser.id}/${vo.no }" class="del">
									<img src="${pageContext.request.contextPath}/assets/images/delete.jpg">
								</a>
								</td>
						</tr>
					</c:forEach>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form action="${pageContext.request.contextPath}/blog/insert">
					<input type="hidden" name="id" value="${authUser.id }" />
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td class="t">설명</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input type="submit" value="카테고리 추가"></td>
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