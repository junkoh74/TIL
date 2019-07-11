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
	<h1>운동 가즈아!!!!!!!!!!</h1>
	<form id="loginForm" action="/springtrain/loginProcess" method="post">
		<input type="hidden" name="login" value="${getLogin.getUser_id}">
		이름 : <input id="username" type="text" name="user_id"
			placeholder="아이디를 입력해주세요" required> <br> <br> 패스워드
		: <input id="passwd" type="password" name="passwd"
			placeholder="비밀번호를 입력해주세요" required> <br> <br> <input
			id="send" type="submit" value="로그인"> <input id="cancel"
			type="reset" value="취소">
		<button>
			<a href="register.jsp">회원가입</a>
		</button>
	</form>


</body>
</html>