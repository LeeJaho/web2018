<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- 권한 인증을 view단에서 가능하게 함 -->

<nav class="aside">
	
	<!-- not authenticated -->
	<sec:authorize access="!isAuthenticated()">
		<section class="not-authenticated">
			<h1>
				<img src="${root}/resources/images/bg-profile.png"/>
			</h1>
			<h2><span>로그인 정보가 필요합니다.</span></h2>
			<div>
				<a href="${root}/member/login" class="btn">노트펍스 로그인</a>
			</div>
		</section>
	</sec:authorize>
	
	<!-- authenticated -->
	<sec:authorize access="isAuthenticated()">
		<section class="authenticated">
			<h1>히히히ㅣㅜㅎ후후후하하하하</h1>
		</section>
	</sec:authorize>
	<%-- <h1></h1>
	
	<ul>
		<li>
			<a href="${root}/member/login">로그인</a>
			<a href="${root}/logout">로그아웃</a>
			<a href="${root}/member/join">회원가입</a>
			<a href="${root}/author/index ">관리</a>
			<a href="${root}/admin/index">관리자</a>
		</li>
	</ul> --%>

</nav>