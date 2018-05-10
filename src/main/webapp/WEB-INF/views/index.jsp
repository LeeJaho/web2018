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
             //대신이형
             var views = categoryViews.children();
             var view = views.eq(0);
			//초기상태 설정
             views.css({
            	 visibility:"hidden",
             	zIndex:"1"
             })
             
             view.css({
            	 visibility:"visible",
             	zIndex:"3"
             })
             categoryViews.css({
           		height: view.height()
           		/* left: "0%" */
             });
             
             var oldView = view;
             
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
             	
             	//대신이형
             	//1. CSS로 초기상태 만들기
               // -view들의 position이 모두 absolute로 겹치게 한다.
               // 단, 그 높이는 실행해봐야 아는 문제이므로 스크립트로 처리한다.
               // -view들의 부모는 현재 view의 높이와 같게 한다.
             	
               // z-index 1 2 3 
               //1) 선택된 놈을 왼쪽으로 위치시키고 z축 제일 위로 올라가도록
               //모든 view 1 주고
               views.css({
            	   zIndex: "1",
            	   visibility: "hidden"
               });
             	//띄워져있던 기존 view에 2 주고
				oldView.css({
					zIndex: "2",
					visibility: "visible"
				});
               
               //새로운 view에 3준다
               view.css({
            	   left: "-100%",
            	   zIndex: "3",
           		   visibility: "visible"
               });
               //2) 그 놈의 높이로 부모 영역의 높이를 맞추고
               
               
               //3) 그 놈이 천천히 밀고 들어온다
               
               categoryViews.animate({
             		height: view.height()
             		/* left: "0%" */
               },400, function(){
            	   
            	   view.animate({
                 	  left: "0%" 
                    });
     				
               });
               
               
             	//2. 현재 view를 제외한 나머지는 hidden 한다
				/* categoryViews.children().css({
					display:"none"
				});
             	
             	view.css({
             		display:"block"
             	}); */
             	
             	//새로운 view를 oldView로 해줌
             	oldView = view;
         
               
               
               /* if(view.length == 0){
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
	             		
	             			var views = categoryViews.find("section");
	             			var height = Math.max(views.eq(0).height(), views.eq(1).height());
	             			views.css("height", height); */
	             			
	             			/* console.log(views.eq(0).height());
	             			console.log(views.eq(1).height()); */
	             			
	             			
	             			          			
	             			/* view = categoryViews.find("."+viewName);
	             			view.addClass("show")
	             				.animate({
				             		right: "0px"
				             	},400,function(){
				             		view.prev().remove();
				             		views.css({
				             			position: "static",
				             			height: "100%"
				             		});
				             	}) */
	             				
	             			
	             			
	             			/* setTimeout(function(){
		             			view
		                 		.css({
		                 			
		                 			right: "0px"
		                 		});	             				
	             			},30); */
	             			//alert(view);
	             			/* ajaxIcon.remove(); */
	             			
	             			//ajaxIcon Object가 들어가니까 null로 바꿔줌
	             			//alert(ajaxIcon);
	             			/* ajaxIcon = null;
	             		});
             	} */
             	
             	
             	
             	//덮어쓰는 느낌 -> 가져오긴 한다
             	//categoryViews.load("book-list-partial");
             	
             	//view를 show 하기(여기다가만 두면 위에 if문 걸렸을 때 view라는 객체가 생성이 안됐을 수도 있으니)
             	//위에다가 하나 여기다가 하나 해줘야함(비동기에 대한 개념!!!!)
             	/* else view.addClass("show"); */
             	
             	//categoryViews.children("section").addClass("hidden");
             	
             	/*if(view.hasClass("hidden"))*/
             	
             	/* view.removeClass("hidden");
             });
         }); */
         
         
         
        	/* if(view.length == 0){
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
         categoryViews.html(html+data);
  		
			var views = categoryViews.find("section");
			var height = Math.max(views.eq(0).height(), views.eq(1).height());
			views.css("height", height);
         view = categoryViews.find("."+viewName);
			view.addClass("show")
				.animate({
          		right: "0px"
          	},400,function(){
          		view.prev().remove();
          		views.css({
          			position: "static",
          			height: "100%"
          		});
          	})
         
     	ajaxIcon.remove();
         ajaxIcon = null;
		});
	}

     	else view.addClass("show");
         view.removeClass("hidden");*/
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
		               <div><a href="note/${note.id}">${note.title }</a></div>
		               <div>${note.content}</div>
		               <div><span>분류</span><span>${note.regDate}</span><span>${note.commentCount}</span></div>
		            </li>
		            </c:forEach>
        		 </ul>
			</section>
			
			<section class="book-list">
				<h1 class="hidden">공개북 목록</h1>
				<ul>
						<li><a href="note/list">책1</a></li>
						<li><a href="note/list">책2</a></li>
						<li><a href="note/list">책3</a></li>
						<li><a href="note/list">책4</a></li>
						<li><a href="note/list">책5</a></li>
						<li><a href="note/list">책6</a></li>
				</ul>
			</section>
			
			<section class="published-list">
				<h1 class="hidden">출간된 책 목록</h1>
				<ul>
					<li><a href="note/list">출간 책 목록1</a></li>
					<li><a href="note/list">출간 책 목록2</a></li>
					<li><a href="note/list">출간 책 목록3</a></li>
					<li><a href="note/list">출간 책 목록4</a></li>
				</ul>
			</section>
		</div>
		
	</main>
	<!-- footer -->
      <jsp:include page="inc/footer.jsp"/>
</body>
</html>