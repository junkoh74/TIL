<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	font-size : 40px; 
}
h3 {
	font-size : 20px;
}
#msg {
	color : red;
}
</style>
</head>
<body>
<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<h1>요청을 처리하는 동안 오류가 발생했어요..</h1>
<hr>
<h3>오류의 원인 : <span id = "msg"><%= errorMsg %></span></h3> 
<br>
<br>
<a href = <%= request.getHeader("referer") %>>입력화면</a>
</body>
</html>