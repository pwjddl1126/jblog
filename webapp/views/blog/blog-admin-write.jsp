<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>


<head>

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JBlog</title>
</head>
<body>
	
<div id="container">
		<div id="header">
			<h1>
				<a href="${pageContext.request.contextPath }/${blogVo.id}">${blogVo.title}</a>
			</h1>
			<c:import url="/views/include/blogheader.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-basic">기본설정</a></li>
					<li><a
						href="${pageContext.request.contextPath}/${authUser.id}/blog-admin-category">카테고리</a></li>
					<li class="selected">글작성</li>
				</ul>
	

				<form action="${pageContext.request.contextPath}/blog/${authUser.id}/write" method="POST">
					<table class="admin-cat-write">
						<tr>
							<td class="t">제목</td>
							<td><input type="text" size="60" name="title" id="title"></td>
						</tr>
						<tr>
							<td class="t">카테고리</td>
							<td>
								<select name="category_no">
									<option value="" disabled selected>Choose your option</option>
									<c:forEach items="${list }" var="vo" varStatus="status">
										<option value="${vo.no}">${vo.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="t">내용</td>
							<td><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="s"><input type="submit" value="포스트하기"
								class="waves-effect waves-light btn"></td>
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