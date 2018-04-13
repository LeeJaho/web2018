<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<fmt:setLocale value="en_US" scope="session"/>	
	<main class="main note detail">
		<article>
			<header>
				<h1>${note.title}</h1>
				<h2>컴퓨터 프로그래밍</h2>
			</header>
			<footer>
				<span>${note.writerId}</span>
				<span><fmt:formatDate pattern = "yyyy-MM-dd a HH:mm" value="${note.regDate}" /></span>
			</footer>
			
			<div>
				${note.content}
			</div>
				<!-- <div>
					<h1>5. CPU의 기능</h1>	
					<span>컴퓨터 프로그래밍</span><br>
					<span>newlec</span>  <span>2018.03.14.15:36</span>
				</div>
				
				<div>
					content
				</div> -->
		</article>

		<nav class="btn-list">
			<h1 class="hidden">버튼목록</h1>
			<ul>
				<li id="sel-button"><span>선택</span></li>
				<li id="edit-button"><a href=""></a>수정</li>
				<li id="delete-button"><a href=""></a>삭제</li>
			</ul>
		</nav>

</main>

<script>
	window.addEventListener("load", function(){
		var selButton = document.querySelector("#sel-button");
		var editButton = document.querySelector("#edit-button");
		var deleteButton = document.querySelector("#delete-button");
		
		selButton.onclick = function(){
			// editButton.style.bottom="50px";
			editButton.classList.add("show");
			deleteButton.classList.add("show");
			// editButton.classList.remove("");
		};

	});

</script>