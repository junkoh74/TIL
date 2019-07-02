<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberVO vo = (MemberVO)request.getAttribute("mh");
if ("mh" != null) {
%>
<h1>회원정보</h1>
<hr>
<ul>
<li>회원 이름 : <%=vo.getName() %></li>
<li>회원 계정 : <%=vo.getAccount() %></li>
<li>회원 암호 : <%=vo.getPassword() %></li>
<li>회원 전화번호 : <%= vo.getNumber() %></li>
<%
}
%>
</ul>
</body>
</html>