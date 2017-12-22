<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<c:choose>
		<c:when test="${auth != null }">
			<h3>${auth}</h3>
			<form action="logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit" class="btn-link">Sign Out</button>
			</form>
		</c:when>
		<c:otherwise>
			<h3>로그인 해주세요.</h3>
			<span><a href="login" rel="nofollow">Sign In</a></span>
		</c:otherwise>
	</c:choose>
</body>
</html>