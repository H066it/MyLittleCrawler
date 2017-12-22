<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/modal/udtModal.jsp" %>
<%@ include file="/WEB-INF/jsp/modal/delModal.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M.L.C.</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="../css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<script src="../webjars/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
<script src="//cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="images/pic02.jpg" alt="" />
			<%@ include file="/WEB-INF/jsp/login/signBar.jsp" %>
		</div>
		<div id="menu">
			<ul>
				<li><a href="../" accesskey="1" title="">Crawling</a></li>
				<li><a href="#" accesskey="2" title="">Saved List</a></li>
				<li class="current_page_item"><a href="../list" accesskey="3" title="">FreeBoard</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		<div id="banner">
			<img src="images/pic01.jpg" alt="" class="image-full" />
		</div>
		<div id="welcome">
			<div class="title" align="left">
				
				<h3>Title : ${dto.FTitle }</h3>
								
				<h4>Writer : ${dto.FWriter }</h4>

				<hr>
	
				${dto.FContent }
								
				<div align="right">
					<a href="#udtModal" role="button" class="btn" data-toggle="modal">수정</a>
					<a href="../list"><button type="button">목록</button></a>
					<a href="#delModal" role="button" class="btn" data-toggle="modal">삭제</a>
				</div>
				
			</div>
		</div>		
		<div id="copyright">
			<span>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a></span>
			<span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</span>
		</div>
	</div>
</div>
</body>
</html>
