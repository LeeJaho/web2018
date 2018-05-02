<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
	
	//file.listFiles();
	
	//List<String> list = new List<>;



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1,  user-scalable=1"/>
		<link href="style.css" type="text/css" rel="stylesheet"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript" src="example.js"></script>

		
		
	</script>
	
</head>

<body>
	<section id="ex7" class="example">
			<h1>갤러리 예제</h1>
			<div class="text-align-center viewer">
					
			</div>
			<div class="photo-box">
				<ul>
					<li><a><img class="" src="images/acon.png"/></a></li>
					<li><a><img class="" src="images/han.png"/></a></li>
					<li><a><img class="" src="images/answeris.png"/></a></li>
					<li><a><img class="" src="images/han.png"/></a></li>
				</ul>
			</div>
			<div>
				<input class="btn btn-default btn-left" type="button" value="왼쪽"/>
				<input class="btn btn-default btn-right" type="button" value="오른쪽"/>
			</div>
	</section>

	<section id="ex6" class="example">
			<h1>노드조작 예제</h1>
			<div class="text-align-center">
					aaaaa
			</div>
			<div>
				<input class="btn btn-add" type="button" value="노드추가"/>
				<input class="btn btn-remove" type="button" value="노드삭제"/>
			</div>
	</section>
	<section id="ex5" class="example">
		<h1>화면전환 예제</h1>
		<div class="text-align-center">
			<img class="" src="images/acon.png"/>
			<img class="" src="images/han.png"/>
			<img class="" src="images/answeris.png"/>
		</div>
		<div>
			<input class="btn btn-default btn-okay" type="button" value="확인"/>
			<input class="btn btn-default btn-css" type="button" value="css 애니메이트"/>
		</div>
	</section>
	
	<section id="ex4" class="example">
		<h1>효과주기 예제</h1>
		<div class="text-align-center">
			<img class="" src="images/acon.png"/>
			<img class="" src="images/han.png"/>
		</div>
		<div>
			<input class=" input" type="text" list="img-list"/>
			<datalist id="img-list">
				<option>han.png</option>
				<option>acon.png</option>
			</datalist>
			<input class="btn btn-default btn-okay" type="button" value="확인"/>
			<input class="btn btn-default btn-css" type="button" value="css 애니메이트"/>
		</div>
	</section>
	
	<section id="ex3" class="example">
		<h1>속성, 스타일 수정하기 예제</h1>
		<div class="text-align-center">
			<img src="images/acon.png"/>
		</div>
		<div>
			<input class="input" type="text" list="img-list"/>
			<datalist id="img-list">
				<option>han.png</option>
				<option>acon.png</option>
			</datalist>
			<input class="btn btn-default btn-okay" type="button" value="확인"/>
			<input class="btn btn-default btn-toggle" type="button" value="토글"/>
		</div>
	</section>
	
	<section id="ex2" class="example">
		<h1>이벤트 처리하기 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인"/>
		</div>
	</section>
	
	<section id="ex1" class="example">
		<h1>노드 선택 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인"/>
		</div>
	</section>
	
</body>
</html>