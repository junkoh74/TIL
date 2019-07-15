<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TT 로그인 페이지</title>
</head>
<body>
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${msg}')
	</script>
	<%
		}
	%>
	
	<h1>환영한다</h1>
	
</body>
</html>