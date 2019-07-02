<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
font-size : 40px;
}
h3 {
font-size : 30px;
}
span {
color : blue;
}
</style>
</head>
<body>
<%
int calc = (Integer) request.getAttribute("result");
%>
<h1>연산요청 결과</h1>
<hr>
<h3>결과 : <span><%= calc %></span></h3>
<br>
<br>
<h1>연산요청 결과 (EL)</h1>
<hr>
<h3>결과 : <span>${ result }</span></h3>
<br>
<br>
<a href = <%= request.getHeader("referer") %>>입력화면</a>
</body>
</html>