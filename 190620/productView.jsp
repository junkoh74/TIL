<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.ProductVO" %>
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
<%
	ProductVO vo = (ProductVO)session.getAttribute("pid");
    if(vo != null) {
%>
		선택된 사과의 개수: <%= vo.getApple() %><br>		
		선택된 바나나의 개수: <%= vo.getBanana() %><br>		
		선택된 할라봉의 개수: <%= vo.getHala() %><br>		
<%
} 
%>
<br>
<br>
<a href= <%= request.getHeader("referer")%>>상품선택 화면</a>


</body>
</html>