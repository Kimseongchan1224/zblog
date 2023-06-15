<%--- /sbootblog/src/main/webapp/WEB-INF/blog/sblogindex.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/zblogheader.jsp"%>

<div class="contriner border">

제목:
<h3>${thepost.title}</h3>

<br>
<hr>
내용:
<h3>${thepost.content}</h3>

<hr>

아이디:${thepost.id }
작성자:${thepost.user.username}

</div>
<%@ include file="../layout/zblogfooter.jsp"%>