<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<!-- <html>
<head> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1,  user-scalable=1"/>
<title>Insert title here</title>
<link href = "${ctx}/resources/CSS/style.css" type="text/css" rel="stylesheet"/>

	
	<main class="main">
		<section class="note-list">
			<h1 class="hidden">노트목록</h1>
			<ul class="">
				<c:forEach var="note" items="${notes}">
					<li class="text">
						<div><a href="${note.id}">${note.title}</a></div>
						<div class="">
							${note.content}
						</div>
						<div><span>분류</span> <span>${note.regDate}</span></div>
					</li>
				</c:forEach>
			</ul>
		</section>
		
		<nav class="btn-list">
			<h1 class="hidden">버튼목록</h1>
			<ul>
				<li id="add-button"><a href="reg">추가</a></li>
				<!-- <li id="edit-button"><a href=""></a>수정</li>
				<li id="delete-button"><a href=""></a>삭제</li> -->
			</ul>
		</nav>
		
	</main>
	
