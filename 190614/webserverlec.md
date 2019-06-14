## [ Web Client ]

Web Client : HTML, CSS, JavaScript, Ajax, jQuery

Web Server : Servlet, JSP, MVC 패턴 (Sevelet + JSP 를 포함한 패턴)
, MyBatis (JDBC프로그램을 효과적으로 하는 framework)
, Spring Frame Work (Spring IOC, Spring MVC) : 다양한 모듈중에서 IOC 와 MVC

## [ Severlet 프로그래밍 ] : 0613 ~ 0614

자바 언어로 구현하는 웹서버 프로그래밍 기술

Servelt : 멀티스레드 (메모리 사용에 효율적)

- 클라이언트가 많아도 스레드를 공유
- 수행 성능이 높음
- 구현이 편의함
  Servlet : Servlet자체로는 웹서버를 구축할 수 없음 (JAVA를 모르는 사람들을 위해 나온 JSP)
  Servlet 엔진 (컨테이너) : Servlet이 구동하기 편하기 위한 도구
  Web Server 
- Tomcat : Web Server + Servlet 컨테이너 / Servelt 엔진 을 포함하고 있는 프로그램
  aka WAS (Web Application Server)

## [ 서버 프로그래밍 학습 웹 프로젝트 : sedu ]

new => dynamic web project (check target runtime Tomcat 9.0v) 

Java Resources => src . right-click  => create servlet => firstservlet as class name =>  next => check off : doPost, Constructors

doGet 메소드에 만들때 부터 매개변수는 바꿀수 없다

HttpServletRequest request : 요청
HttpServletResponse response : 응답

sevlet은 응답을 바로 만들수 있지만 



```java
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("guest");
		response.setContentType("text/html; charset=utf-8"); //리스폰스 형식을 정해 줘야함
		PrintWriter out = response.getWriter(); //변수 생성
        out.print("<h1> 맛보기 JSP</h1><hr>"); //개행 문자를 직접 넣어 주어야함
		out.print("<h3>당신의 이름은" + name + "이네요</h3>"); //out 추출
		out.close();
	}
}
```

Servlet == Server Side Applet (Application보다 작은 프로그램, 단독으로 수행 불가 / 수행 환경을 구축 해줘야함)

모든 메소드는 언제 무슨 메소드가 생성되는지 정해져 있다. p281

```java
public void init (ServletConfig config) throws ServletExcetiion {
    
}

public void destory () {
    
}
protected void service (HttpServletRequest request, HttpServletResponse response) throws 
```

Tomcat서버는 새로운 Servlet을 기동 될때 인식함
이미 기동된 상태일 땐 상관없이 reload를 하면 됨

@WebServlet("/FirstServlet") == URL 매핑명, 매핑 정보를 일일히 넣어주는 것이 아니라 annotation으로 간편하게 입력

웹에서 사용되는 파일은 확장자를 보고 판단을 하는데 servlet은 .class가 확장자이기 때문에 클래스 명과 매핑명을 연결 시키는 것이 중요함



| 애노테이션 명     | 기능                                                         |
| ----------------- | ------------------------------------------------------------ |
| @WebServlet       | Servlet 프로그램의 등록과 매핑(URL mapping)을 정의           |
| @WebInitParam     | Servlet프로그램에 전달할 초기 파라미터를 정의                |
| @WebListener      | 리스너 정의                                                  |
| @WebFilter        | 필터 정의                                                    |
| @MupltipartConfig | Servlet 프로그램에서 다중 파티션으로 전달되는 파일 업로드를 처리 할 수 있는 것을 정의 |

서블렛에서는 System.out.println();가 브라우져에 보여지진 않지만, eclipse console창에 출력이 된다

Servlet은 멤버변수는 서버가 죽을 때까지 유지 그리고 공유
지역변수는 리로드 그리고 개별적으로 메모리를 각각 할당

getPost.html ----> GetPostServlet - GET.POST
                             선택메소드 : doGet, doPost
                             매핑명 : /getpost

포스트 일시 다음 코드를 입력해야 한글이 깨지지 않고 제대로 실행됨

```java
 request.setCharacterEncoding("utf-8");
```



## [ Review ]

(1) HttpServlet 클래스를 상속
(1-1) Tomcat (Web Server + Application Server 기능 : WAS -- Web Application Server)
                      Coyote Server + Catalina Server (코요테 서버에서 모든 정보를 받고 카탈리나에 보내야 할지 아니면 웹으   					  로 보내야 할지 판단)
				      doGet (), doPost () 주로 둘중 하나만 사용하지만 둘다 사용 가능, service()도 가능
				      HttpServletRequest : 요청 정보를 추출 할 때 사용 (Query 는 클라이언트가 서버로 변환하여 보낼때 사용되  														는 문자열)
				      HttpServletResponse : 응답과 관련하여 -- 응답 스트림 객체 사용, 컨텐트 타입 설정, 
(2) 서블릿의 수행상의 특징
(2-1) 서블릿은 한번 메모리 할당(객체생성)되면 할당된 상태를 계속 유지한다
(2-2) 하나의 서블릿 객체를 공유하여 여러 클라이언트 요청을 처리한다 (Multi-Thread)
		 각 시점맏 호출되는 매서드가 정해져 있다
        	 객체 생성 후 실행 - init()
        	 요청이 올 때마다 - service (), doGet(), doPost()
			 객체 해제전 - destroy()
(2-3) 쿼리 문자열 추출 방법
		 name=value&name=value&name=value
		 HttpServletRequest 객체의 getParameter()
				String getParameter(String) : 리턴값이 value 값 또는 null 또는 " "
		  	  String [] getParameteValues(String) : 여러개의 value를 return -- value값들의 배열 혹은 null
		 GET 방식의 경우엔 Query 문자열 추출시 한글이 깨지지 않음
		 POST 방식은 깨지기 때문에 --> request.setCharacterEncoding ("utf-8"); 을 설정하여 호출 한후 추출

### 유용한 메서드

getRequestURI()
getRequestURL()
getParameter(name)
getParameterValues(name)
getRemoteAddr() -- 클라이언트 IP조수 추출하여 사용자의 정보를 보고 싶을 시
getServerName() -- 요청을 보내온 서버의 도메인 명을 추출 (*naver에서 타고 왔을 경우)

sendRedirect(url) -- 요청을 재지정

RequestDispatcher API = redirect 하는 API

```java
포워드(forward) 형식

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ForwardServlet 수행");
RequestDispatcher dis = request.getRequestDispatcher("/welcome.jsp");
dis.forward(request, response); // forward로 request하면 welcome.jsp가 응답
```



```java
리다이렉트 (redirect) 형식

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RedirectServlet 수행");
//		response.sendRedirect("/sedu/welcome.jsp");
        response.sendRedirect("http://www.naver.com/");
	}
}
```

포워드(Forward) 형식은 동일한 서버, 동일한 웹 프로젝트 내의 페이지만 재 연결 시킬수 있지만 리다이렉트(Redirect) 는 동일 서버/웹프로젝트 외의 페이지에도 재연결이 가능하다