<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
a {
font-size : 22px;
background: radial-gradient(yellow, white, green);
}
</style>
<body>
	<h1>선택된 상품 정보는 다음과 같습니다.</h1>
	<hr>
<h2>사과 : ${ sessionScope.product.apple}</h2>
<h2>바나나 : ${ sessionScope.product.banana }</h2>
<h2>한라봉 : ${ sessionScope.product.hala }</h2>
<br>
<br>
<a href= <%= request.getHeader("referer")%>>상품선택 화면</a>


</body>
</html>