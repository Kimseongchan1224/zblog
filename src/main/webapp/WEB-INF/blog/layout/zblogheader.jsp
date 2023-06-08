<%--- /sbootblog/src/main/webapp/WEB-INF/blog/layout/sblogheader.jsp --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>블로그 첫화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">게시판처음화면</a>
			<div class="collapse navbar-collapse" id="mynavbar">
				
				<c:if test="${sessionScope.blogprincipal  == null }">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="/auth/login">로그인</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/auth/insertUser">회원가입</a></li>
				</ul>
				</c:if>
				
				<c:if test="${sessionScope.blogprincipal != null }">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="/">회원상세정보</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/auth/logout">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/auth/insertPost">insertPost게시물</a></li>
				</ul>
				</c:if>
				
				
			</div>
		</div>		
	</nav>