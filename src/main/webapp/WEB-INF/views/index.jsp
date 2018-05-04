<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>

<meta 
    name="viewport"     
      content="width=device-width, 
             initial-scale=1, minimum-scale=1, user-scalable=1"/>
<title>Insert title here</title>


<link href="${ctx}/resources/CSS/index.css" type="text/css" rel="stylesheet">

</head>
<body>
   <!-- header -->
      <jsp:include page="inc/header.jsp"/>
   <!-- aside -->
      <jsp:include page="inc/aside.jsp"/>
      
   <!-- visual-->
   <section class="visual">
   	<h1></h1>
   </section>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
         $(function(){
            var shutter = $(".shutter");
            var shutterContent = $(".shutter ul");
            var shutterButton = $(".shutter-button-box > span");
           
            
            /* var wrapper = $("<div/>")
   
            //shutter 안에 있는 엘리먼트들을 wrapper 안으로 옮기고
            //wrapper를 shutter의 자식으로
            
            wrapper.html(shutter.html());
            shutter.empty().append(wrapper);
            var shutterButton = $(".shutter-button-box span") */
            var ul = shutterContent.detach();
           var clipper = $("<div />").append(shutterContent).appendTo(shutter).css("overflow","hidden");
            var check = true;
            shutterContent.css("transition", "1s");
            
            
            //초기상태 (펼칠것인지, 접을 것인지) : visited 값을 이용해서
            if(${visited}){
            	 shutterContent.css("margin-top", -1*shutter.outerHeight()+"px");
            	 shutterButton.css("background", '#007100 url("resources/images/ic_expand_less_black_24dp_1x.png") no-repeat center');
            }
            
            shutterButton.click(function(){

               //wrapper.css("margin-top", "-200px");
               //alert(shutterContent.outerHeight());
            	shutterContent.css("margin-top", -1*shutter.outerHeight()+"px");
            });
            
            shutterContent.on("transitionend", function(){
            	
            	var marginTop =  parseInt(shutterContent.css("margin-top"));
            	console.log(marginTop);
            	
            	
            	if(marginTop < 0)
            		shutterButton.css("background", '#007100 url("resources/images/ic_expand_less_black_24dp_1x.png") no-repeat center');
            	else
            		shutterButton.css("background", '#007100 url("resources/images/ic_expand_more_black_24dp_1x.png") no-repeat center');
            });
            
           
               
         });
         
         
         //cateogry switch 
         $(function(){
        	 //(Jquery 아님)
        	 var categoryViews = $(".category-views");
        	 var categoryList = $(".category ul");
             var categoryButton = $(".category ul > li");
             var ajaxIcon = null;
             
             categoryList.click(function(e){
            	 //e.target 내가 클릭한 것 / e.currentTarget binding 되어 잇는것?
            	if(e.target === e.currentTarget)
            		return;
             	
            	 
            	//alert("aa");
             	var target = e.target;
             	//alert(target);
             
                //target.css("background", 'url("resources/images/ajax-loader.gif") no-repeat center');
             	
             	//A태그를 클릭했을 때
             	if(target.nodeName=="A"){
             		target = target.parentNode;
             		e.preventDefault(); 
             		//alert(target);
             	}
             	
            	if(ajaxIcon != null){
            		alert("처리중입니다.")
            		return;
            	}
            	//alert(ajaxIcon); 
             	
             	var viewName = target.dataset.viewName;
             	//alert(viewName);
             	
             	//view 객체 얻기
             	var view = $("."+viewName);
             	//view.css("border","1px solid red");

             	//view가 null이면 ajax로 가져오기
             	
             	
             	if(view.length == 0){
             		ajaxIcon = $("<img />")
				                    .attr("src", "resources/images/ajax-loader.gif")
				                    .css({
				                    	position: "absolute",
				                    	top: "11px",
				                    	left: "8px"
				                    })
				                    .appendTo(target);
             		 
	             		$.get(viewName+"-partial", function(data){
		             		var html = categoryViews.html();
	             			//alert(data);
	             			categoryViews.html(html+data);
	             		
	             			view = categoryViews.find("."+viewName);
	             			
	             			//alert(view);
	             			ajaxIcon.remove();
	             			
	             			//ajaxIcon Object가 들어가니까 null로 바꿔줌
	             			//alert(ajaxIcon);
	             			ajaxIcon = null;
	             		
	             		});
             	}
             	
             	view
             		.children("ul")
             		.css({
             			position: "relative",
             			left: "-60px"
             		})
             	
             	//덮어쓰는 느낌 -> 가져오긴 한다
             	//categoryViews.load("book-list-partial");
             	
             	//view를 show 하기
             	
             	
             	 categoryViews.children("section").addClass("hidden");
             	
             	/*if(view.hasClass("hidden"))*/
             		
             		
             	
             	view.removeClass("hidden");
             });
         });
         
      </script>
   
   <section class="notepubs shutter"> 
   	<h1 class="hidden">서비스 안내</h1>
   	<div class="shutter-button-box" style="position: relative;">
   		<span class="">확장 / 축소</span>
   	</div>
   	<ul>
   		<li>
   			<article>
   				<h1>NOTE</h1>
   				<h2>
	   				스스로 새롭게 알게된 지식은 노트로 기록해 보세요.
	   				기록된 지식은 사라지지 않습니다.
	   				그것이 누적되면 나를 성장시키는 큰 자산이 됩니다.
   				</h2>
   				<div>
   					<img src="${ctx}/resources/images/notes-sm.png"/>
   				</div>
   			</article>
   		</li>
   		
   		<li>
   			<article>
   				<h1>BOOK</h1>
   				<h2>단편적으로 기록한 노트들을 엮어서 관련있는 것들로 모아보세요
   				그러면 하나의 책이 됩니다.
   				책은 지식을 체계적으로 이해하고 정리하는 데 도움이 됩니다.
   				</h2>
   				<div>
  	 				<img src="${ctx}/resources/images/book-sm.png"/>
   				</div>
   			</article>
   		</li>
   		
   		<li>
   			<article>
   				<h1>OPEN</h1>
   				<div></div>
   			</article>
   		</li>
   		
   		<li>
   			<article>
   				<h1>PUBLISH</h1>
   				<div></div>
   			</article>
   		</li>
   	</ul>
   </section>
   <!-- main -->
	<main class="main">
		
		<section class="category">
			<h1>카테고리</h1>
			<ul>
				<li data-view-name="note-list"><a href="">노트</a></li>
				<li data-view-name="book-list"><a href="">책</a></li>
				<li data-view-name="published-list"><a href="">출간본</a></li>
			</ul>
		</section>
		
		<div class="category-views">
			<section class="note-list">
				<h1 class="hidden">공개노트목록</h1>
				<ul>
		            <c:forEach var="note" items="${notes}">
		            <li>
		               <div><a href="${note.id}">${note.title }</a></div>
		               <div>${note.content}</div>
		               <div><span>분류</span><span>${note.regDate}</span><span>${note.commentCount}</span></div>
		            </li>
		            </c:forEach>
        		 </ul>
			</section>
			
			<!-- <section class="book-list hidden">
				<h1 class="hidden">공개북 목록</h1>
				<ul>
					<li>
						<a href="note/list">책</a>
					</li>
				</ul>
			</section> -->
			
			<!-- <section class="published-book-list hidden">
				<h1 class="hidden">출간된 책 목록</h1>
				<ul>
					<li>
						<a href="note/list">책</a>
					</li>
				</ul>
			</section> -->
		</div>
		
	</main>
	<!-- footer -->
      <jsp:include page="inc/footer.jsp"/>
</body>
</html>