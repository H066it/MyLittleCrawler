<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M.L.C.</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="../css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/fonts.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="images/pic02.jpg" alt="" />
			<%@ include file="/WEB-INF/jsp/login/signBar.jsp" %>
		</div>
	</div>
	<div id="main">
		<div id="banner">
			<img src="images/pic01.jpg" alt="" class="image-full" />
		</div>
		<div id="signIn">
			<form action="login" method="POST" style="width: 500px">
				<input type="hidden" name="_csrf" value="${_csrf.token}">
			
				<div style="width: 50rem">
					<p>
						id : <input type="text" name="username">
					</p>
					<p>
						pw : <input type="password" name="password">
					</p>
					<p>
						Remember me : <input type="checkbox" name="remember-me">
					</p>
				</div>
				<p align="right">
					<button type="submit">로그인</button>
					<a href="signUp"><button type="button">회원가입</button></a>
					<a href="/"><button type="button">취소</button></a>
				</p>
			</form>
		</div>
		<div id="copyright">
			<span>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a></span>
			<span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</span>
		</div>
	</div>
</div>
</body>
</html>