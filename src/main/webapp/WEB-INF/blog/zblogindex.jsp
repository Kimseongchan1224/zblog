<%--- /sbootblog/src/main/webapp/WEB-INF/blog/sblogindex.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./layout/zblogheader.jsp"%>

<%-- p98 목록화면 --%>
<div class="container-fluid mt-3">
	<c:if test="${!empty postList }">
		<div class="card">
			<c:forEach var="apost" items="${postList }">
				<div class="card-body">
					<h4 class="card-title">${apost.title }</h4>
					<a href="#" class="btn btn-secondary">상세보기</a>
				</div>
			</c:forEach>
		</div>
	</c:if>
</div>

<%@ include file="./layout/zblogfooter.jsp"%>