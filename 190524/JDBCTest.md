# JDBC 프로그래밍 정리

ODBC 는 C, C++을 지원

- JDBC API는 표준적으로 정해놓은 인터페이스가 있다
  - 정해진 호출 방식
  - 실질적으로 BODY는 가지고 있지 않음 
  - JDBC는 DRIVER를 제공
  - JDBC API는 JAVA (java.sql) 에서 제공
- JDBC프로그램의 구현 과정

1. JDBC드라이버 로딩 (Class.forName (대표클래스 이름(주로 DRIVER)))
   - 대표 드라이버는 도큐멘테이션을 제공
2. DB 서버 접속 (DriverManager.getConnection(JDBCUrl, 'ID', 'PASSWD'))
3. 수행하고자 하는 명령에 따라서 Statement, PreparedStatement 객체를 생성
   - FACTORY 메소드는 Connection
   - PreparedStatement는 미리 수행할 명령을 세팅후 동적으로 실행
   - Statement는 정해진 명령을 실행
4. executeQuery (), executeUpdate ()
   - execute () 문은 어디에나 쓸수 있지만 결과값을 다시 출력하여야만 함
   - executeQuery() 는 리턴값이 ResultSet : select 결과가 없다면 리턴이 blank || next (), getType () 을 통하여 다음 값을 출력
   - executeUpdate ()  는 리턴값이 int : 변화된 행의 갯수이기 때문에 int로 리턴 || 변화가 없다면 리턴값은 0
5. 연결된 자원 해제
   - ***.close();