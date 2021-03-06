<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1,  user-scalable=1"/>
<title>Insert title here</title>
<link href = "${ctx}/resources/CSS/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<!-- header -->
	 <tiles:insertAttribute name="header" />
	 <!-- aside -->
	 <tiles:insertAttribute name="aside" />
	<!-- main -->
	 <tiles:insertAttribute name="main" />
	<!-- footer -->	
	 <tiles:insertAttribute name="footer" />

</body>
</html>