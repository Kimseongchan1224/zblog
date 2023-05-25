<%--- /sbootblog/src/main/webapp/WEB-INF/blog/user/insertUser.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/zblogheader.jsp"%>

<%-- p98 목록화면 --%>
<div class="container mt-3">
  <form>
      <div class="mb-3 mt-3">
      <label for="uname">Username사용자이름:</label>
      <input type="text" class="form-control" id="username" placeholder="사용자이름" name="username">
    </div>
  
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button id="btn-save" type="submit" class="btn btn-primary">Submit회원가입</button>
  </form>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/zblogfooter.jsp"%>