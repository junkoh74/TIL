<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="vo.MemberVO, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TT �α��� ������</title>
</head>
<body>
	<h1>��� � �ϰ���?</h1>
	<form id="registerForm" Action="/springtrain/registerInsert" method="post">
		<input type="hidden" name="action" value="register">
		�̸� : <input id="username" type="text" name="user_id"
			placeholder="���̵� �Է����ּ���" required> <br> <br>
		E-MAIL : <input id="email" type="email" name="email"
			placeholder="�̸����� �Է����ּ���" required> <br><br> 
		�н����� : <input id="passwd" type="password" name="passwd"
			placeholder="��й�ȣ�� �Է����ּ���" required> <br> <br>
			
			<input id="send" type="submit" value="ȸ������"> <input id="cancel"
			type="reset" value="�ٽ� ����">
			<br>
			<br>
			<br>
		<button>
			<a href="login">�α��� �������� ���ư���</a>
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