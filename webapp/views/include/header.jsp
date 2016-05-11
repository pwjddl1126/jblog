<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<div class="center-content">
	<ul class="menu">
		<c:choose>
			<c:when test='${empty authUser}'>
				<li><a href="${pageContext.request.contextPath}/user/loginform" class="waves-effect waves-light btn">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/join" class="waves-effect waves-light btn">회원가입</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/user/logout" class="waves-effect waves-light btn">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${authUser.id}" class="waves-effect waves-light btn">내블로그</a></li>
			
			</c:otherwise>
		</c:choose>
	</ul>
</div>