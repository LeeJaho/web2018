<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 절대경로를 쓰기 위해서 -> 왜 절대경로를 써? -->
<c:set var="root" value="${pageContext.request.contextPath }" />
	<header class="header">
		<h1><a href="${root}/index"><img src="${root}/resources/images/logo-ldpi.png"/></a></h1>
		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
				<ul>
					<li id="ham-button"><a href=""><img src ="${root}/resources/images/ic_dehaze_black_24dp_1x.png"/></a></li>
					
					<%-- <li><a href=""><img src ="${ctx}/resources/images/ic_search_black_24dp_1x.png"/></a></li> --%>
					<!-- <li></li> -->
				</ul>
		</nav>
	</header>


	<script>
		window.addEventListener("load",function(event){
			var hamButton = document.querySelector("#ham-button");
			var aside = document.querySelector(".aside");
			hamButton.onclick=function(e){
				if(aside.classList.contains("show"))
					aside.classList.remove("show");

				else
					aside.classList.add("show");
							
					e.preventDefault();

			};
			

		});
	
	</script>