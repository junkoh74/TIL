<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberVO vo = (MemberVO)request.getAttribute("data");
String phone = vo.getNumber();
String pattern = phone.replaceFirst("(\\d{3})(\\d{4})(\\d+)", "$1-$2-$3");
%>
<h1>회원정보</h1>
<hr>
<ul>
<li>회원 이름 : <%=vo.getName() %></li>
<li>회원 계정 : <%=vo.getAccount() %></li>
<li>회원 암호 : <%=vo.getPassword() %></li>
<li>회원 전화번호 : <%= pattern %></li>
</ul>
</body>
</html>