# [ JSP 수업 ]

JSP 또한 Servlet에서 실행
JSP는 GET 과 POST를 구분 하지 않는다

시간 출력
(1) JavaScript : 클라이언트 시간
(2) JSP + Java : 서버 시간

표현식 태그

```JSP
<%=      %>
<h3>현재 시간 정보 : <%=java.time.LocalDateTime.now()%></h3>
```



6/18 순서

------------------------------------------------------------------------

1. JSP 태그
2. JSP 내장 객체

## [ JSP 태그 ]

- 스크립트 태그 : 필요한 자바 코드를 정의하는 용도의 태그들

  ```JSP
  <%=         %> == 표현식 태그 (수행 결과를 출력 하고 싶다면 (어떠한 식이라도 올 수 있다))
  <%          %> == 수행문 태그 (수행만 하고 출력은 하지 않는다)
  <%!         %> == 선언문 태그 (멤버변수 선언, 메서드 정의)
  <%@         %> == 지시자 태그 (영향을 주는 기능 (?))
  <%--      --%> == 주석 (HTML 주석 == <!-- -->, 자바 주석 == //, /*.....*/)
  ```

- 액션 태그
  <jsp : usebean .../>
  <jsp : foraward ..../>
  <jsp : include ..../>
  <jsp : setProperty ..../>
  <jsp : getProperty ..../>
- 커스텀 태그
  팔요에 의해 개발자가 직접 태그를 만들어서 사용
- 총 9개의 내장객체를 활용하고 있다
  1. request
  2. session
     - session 객체는 접속하지 않아도 만들어 질때 부터 자동으로 시작된다
     - 관련된 모든 파일을 닫고 다시 시작하면 seesion 이 reset된다
  3. application
  4. out
  5. response
  6. pageContext
  7. config
  8. page
  9. exception
     - 에러가 날때만 사용 가능
     - isError = true 일때만 발동

**표현식 태그에는 모든 식이 올수 있다**

servlet에서 out.print (); 안에 올 수 있는 모든 식이 가능하다

POST 방식을 쓰기 위해서는 캐릭터 세팅 선언을 해줘야 한다

```jsp
GET&amp;POST => <%-- GET&POST 중  --%>
<% if (request.getMethod().equals("POST")) {
	request.setCharacterEncoding("UTF-8");
}
%> // 포스트 일때 변환
무조건 변환도 가능
<% request.setCharacterEncoding("utf-8") %>
```



**선언식 태그**

```jsp
<%
	String p1 = request.getParameter("num1");
	String p2 = request.getParameter("num2");
	if (p1 == null || p2 == null) {
%>
	<h2>num1 = xx & num2 = yy 형식의 쿼리를 전달하시오</h2> 
<%-- 자바, servlet 코드가 아닌 것들은 따로 빼서 하는것이 안전하다 --%>
<%		
	} else {
		int result = multiply(Integer.parseInt(p1), Integer.parseInt(p2));
		out.print("<h2> 연산 결과 : " + result + "</h2>");
	}
%>
```

### [ 예외처리 ]

JSP는 예외 처리가 자동으로 생성 되기 때문에 catch/try를 직접 구현 안해도 되지만 원하는 예외 처리가 있다면 직접 구현해도 무관함

### [ Form ]

폼택은 action 속성이 없을 경우 자기 자신의 페이지를 default로 불러 옴



```jsp
<head>
<meta charset="UTF-8">
<title>요청 방식에 따른 처리</title>
<style>
	input {
		margin : 3px;
	}
</style>
</head>
<body>
	<% if (request.getMethod().equals("GET")) { %>
		<h2>원하는 칼라와 날짜를 선택하세요</h2>
		<form method="post">
			칼라 : <input type="color"  name="fcolor" ><br>
			날짜 : <input type="date"  name="fdate"><br>
			<input type="submit" value="전송">
		</form>
	<% } else { %>	
			<script> // 자바스크립트 구역에선 자바스크립트 구문에 마춰야 함
				document.body.style.backgroundColor = // 전체 블럭은 자바스크립트로 실행
					         '<%= request.getParameter("fcolor") %>'; // jsp는 웹페이지에 동적으로 넣어준다
			</script>
			<h2>선택 날짜는 <%= request.getParameter("fdate") %> 이네요..</h2>
	<% } %>
</body>
</html>

```

## [ Servlet의 전달 방법 ]

1. HttpServletRequest 객체에 저장하여 전달 하는 방법 - request scope (요청이 끝날 때 까지)
2. HttpSession 객체에 저장하여 전달 하는 방법 - session scope (세션이 죽을 때 까지)
3. ServletContext 객체에 저장하여 전달 하는 방법 - application scope (서버가 죽을 때 까지 / 가장 긴 라이프 사이클)

3 방법중 하나에 담아 jsp에 전달

공통적으로 가지고 있는 Method

- setAttribute(이름, 객체)
- getAttirbute (이름)
- removeAttribute (이름)

**배열, 문자열**

이름, 번호, 나이, 주소 ==> VO (Value Object), DTO 클래스

```jsp
class MyData {
	String name;
  	int number;
	int age
String address
}
```



​	