<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />
<nav class="aside">
	<h1></h1>
	
	<ul>
		<li>
			<a href="${root}/member/login">로그인</a>
			<a href="${root}/logout">로그아웃</a>
			<a href="${root}/member/join">회원가입</a>
		</li>
	</ul>

</nav>