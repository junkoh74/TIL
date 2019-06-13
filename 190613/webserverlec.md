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

