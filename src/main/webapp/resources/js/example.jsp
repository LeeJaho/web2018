<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<section id="ex1" class="example">
		<h1>노드 선택 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인"/>
		</div>
	</section>

	<section id="ex2" class="example">
		<h1>이벤트 처리하기 예제</h1>
		<div>
			<input class="btn btn-default" type="button" value="확인"/>
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
			<input class="btn btn-default" type="button" value="확인"/>
		</div>
	</section>
	
</body>
</html>