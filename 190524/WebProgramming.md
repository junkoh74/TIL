# [웹 프로그래밍]

웹 클라이언트 : HTML, CSS, JavaScript, Ajax, HTML5 주요 API

- 웹 페이지의 내용이나 겉모습을 바꾸는 프로그램

웹서버 : Servlet & JSP, Spring FrameWork, MyBatis (JDBC를 더 세련되게 구현 가능, DB구동 전용 Frame Work) 

- 평균적으로 기능을 갈아 엎는 것보단 업그레이드 위주로 운영

웹기반 시각화 : D3.js

오픈 API : 네이버, 구글에서 제공하는 오픈 API를 활용한 구현

- 대부분 JavaScript를 이용

웹서버 필요 - Tomcat (Web Application Server : WAS) 사용

웹클라이언트 - 크롬, IE 등

## 설치 프로그램

Tomcat

[다운로드](<https://tomcat.apache.org/download-90.cgi>)

1.1 Connector Port 8080 => 8000

**Install 종료시 "Run Apache Tomcat" 실행 하지 말것**

javaexam - Java Project

edu - Dynamic Web Porject

1. Tomcat 서버를 eclipse에 등록
2. edu를 생성
3. edu를 Tomcat 서버가 관리 할 수있도록 등록
4. first.html 파일 생성
5. 브라우저에서 (크롬) first.html을 요청

### Tomcat 서버를 eclipse에 등록

자바 => new => Other => Server => Tomcat v9.0 => Tomcat 9.0 선택

### Edu 생성

자바 => new => Other => web server => Geverate web.xml deployment describer 체크 

edu 메뉴 => Properties => 'resources' 검색 => text file container (other) =>  utf-8

### Edu 서버  Tomcat에  등록

Server Tab => Stopped, republished => add and remove => edu => finish

### first.html 파일 생성

web content 메뉴 => new => html => 파일 생성

Tomcat 서버 구동시키기

Servers Tab => 서버 Run

http:\\localhost:8000/edu/first.html









