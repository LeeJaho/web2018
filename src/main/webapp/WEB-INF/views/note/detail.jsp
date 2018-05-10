<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

	<fmt:setLocale value="en_US" scope="session"/>	
	<main class="main note-detail">
		<article>
			<header>
				<h1>${note.title}</h1>
				<!-- <h2>컴퓨터 프로그래밍</h2> -->
			</header>
			<footer>
			<%-- 	<span>${note.writerId}</span> --%>
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
		<section>
			<h1>버튼</h1>
			<div>
				<a href="${note.id}/like" class="btn btn-like">좋아요</a>
			</div>
		</section>
		
		<!-- 대신이형 -->
		<section class="comment-form">
            <h1 class="hidden">댓글 입력 폼</h1>
            <h2>댓글을 달아보세요</h2>
              <form action="${note.id}/comment/reg" method="post">
                     <div style="height:300px; diplay:flex; flex-direction: column; padding:10px; text-align: center">
                        <div style="display:flex;">
                           <input type="text" style="width:50%; margin-right:5px; border:none;" placeholder="필명" name="nic-name" />
                           <input type="text" style="width:50%;margin-right:5px; border:none;" placeholder="비밀번호" name="pwd" />
                        </div>
                        
                        <input type="text" style="width:100%; height:50%; margin-top:15px;" placeholder="" name="content" />
                        
                        <div style="display: flex; margin-top:10px; justify-content: space-between;">
                           <div><input type="checkbox" name="secret" value="true"/>비밀댓글</div>
                           <div><input type="submit"/></div>
                        </div>
                     </div>
               </form>
         </section>
		
		<section>
			<h1>Comments</h1>
			<ul>
				<c:forEach var="c" items="${note.comments}">
					<li>
						<table border="1">
							<tr>
								<td rowspan="2"><img src=""/>1</td>
								<td>
									<span>${c.writerId}</span>
									<span>${c.regDate}</span>
									<span></span>
								
								</td>
							</tr>
							<tr>
							 	
								<td>${c.content}</td>
							</tr>
							
						</table>
					</li>
				</c:forEach>
			</ul>
		
		</section>
		<nav>
			<h1></h1>
			<ul>
				<li>
					<c:if test="${not empty note.prevNote}">
						<a href="${note.prevNote.id}">${note.prevNote.title}</a>
					</c:if>
					<c:if test="${empty note.prevNote}">
						<span>이전글이 없습니다.</span>
					</c:if>
				</li>
				<li>	
					<c:if test="${not empty note.nextNote}">
						<a href="${note.nextNote.id}">${note.nextNote.title}</a>
					</c:if>
					<c:if test="${empty note.nextNote}">
						<span>다음글이 없습니다.</span>
					</c:if>
					
				</li>
			
				
			</ul>
		</nav>
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	
	$(function(){
		var submitButton  = $(".comment-form input[type='submit']");
		//var nicNameInput  = $(".comment-form input[name='nicName']").val();
		
		submitButton.click(function(e){
			e.preventDefault();
			//alert(nicNameInput);
			
			var data = $(".comment-form form").serialize();
			alert(data);
			/*
			$.ajax();
			$.get(); / $.getJSON() / $.getScript()
			$.post();
			*/
			
			//$.post("?/comment/reg", {nickName:nicNameInput, val(),})
			
			$.post("${note.id}/comment/reg", data, function(result){
					alert(result);
			});
			
			//alert(data);
			//파일이 포함되느냐 아니냐 encodeType
			//Multipart -> new FormData();
			//key = value & key = value ....
			
		});
	});

</script>