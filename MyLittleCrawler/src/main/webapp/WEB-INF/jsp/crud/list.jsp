<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="../images/pic02.jpg" alt="" />
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
			<img src="../images/pic01.jpg" alt="" class="image-full" />
		</div>
		<div id="welcome">
			<div class="title">
				<table class="table table-striped">
					<tr align="center">
						<td>번호</td>
						<td width="50%">제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
					
					<%-- <c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.FId }</td>
							<td width="50%"><a href="/${dto.FId }">${dto.FTitle }</a></td>
							<td>${dto.FWriter }</td>
							<td>${dto.FDate }</td>
							<td>${dto.FCount }</td>
						</tr>
					</c:forEach>
					
					@PageableDefault 안 쓸 경우는 위에껄로 해서 paging 설정 만들어야 함.
					--%>
					
					<c:forEach items="${pageList.content}" var="dto">
						<tr>
							<td>${dto.FId }</td>
							<td width="50%"><a href="/${dto.FId }">${dto.FTitle }</a></td>
							<td>${dto.FWriter }</td>
							<td>${dto.FDate }</td>
							<td>${dto.FCount }</td>
						</tr>
					</c:forEach>
				</table>
				
				<div align="right">
					<a href="write"><button>write</button></a>
				</div>
				
				<div class="pagination">
					<%@ include file="/WEB-INF/jsp/crud/pagiantion.jsp" %>
				</div>
				
				<div class="search">
					<form action="search" method="get" class="form-search">
						<div class="input-append">
							<select name="searchType">
								<option value="fTitle">제목</option>
								<option value="fContent">내용</option>
								<option value="fWriter">작성자</option>
								<option value="fTitle_fContent">제목+내용</option>
							</select>
							<input type="text" name="keyword" class="span2 search-query">
							<input type="submit" value="검색" class="btn">
						</div>
					</form>
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
