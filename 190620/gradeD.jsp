<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String data1 = (String) request.getParameter("name");
%>
<h1><%= data1 %>님은 D 등급 입니다. 꾸준히 노력하세요.</h1>
<a href= <%= request.getHeader("referer")%>>성적 입력 화면으로</a>
</body>
</html>