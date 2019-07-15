<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="vo.MemberVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TT 로그인 페이지</title>
</head>
<body>
	<h1>어서와 운동 하고갈래?</h1>
	<form id="registerForm" Action="/springtrain/registerInsert" method="post">
		<input type="hidden" name="action" value="register">
		이름 : <input id="username" type="text" name="user_id"
			placeholder="아이디를 입력해주세요" required> <br> <br>
		E-MAIL : <input id="email" type="email" name="email"
			placeholder="이메일을 입력해주세요" required> <br><br> 
		패스워드 : <input id="passwd" type="password" name="passwd"
			placeholder="비밀번호를 입력해주세요" required> <br> <br>
			
			<input id="send" type="submit" value="회원가입"> <input id="cancel"
			type="reset" value="다시 쓰기">
			<br>
			<br>
			<br>
		<button>
			<a href="login">로그인 페이지로 돌아가기</a>
		</button>
	</form>
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<script>
		alert('${msg}')
	</script>
	<%
		}
	%>
</body>
</html>