# MyBatis 1st

MyBatis 는 JDBC를 더 효율적으로 하기위해 나온 FW.

- 예외 처리 (Exception)
- 결과 처리 (Result Set)
- SQL Manager => 어플리케이션 소스코드로부터 분리
  - SQL 문서를 xml로 변환하여 보관

알아서 위의 처리 결과를 단순하게 지원

select를 사용 하기 위해선 resultType 의 선언이 필수적이며 기능은 result를 담을 vo객체를 정해주는 역할

- selectlist도 마찬가지

parameterType은 정보를 받아올 타입을 정해주는 역할

​	    session.close(); session에 대한 선언을 하고 나선 무조건 close를 호출하여 닫아줘야함

search는 

```java
where memo like '%'||#{key}||'%'
```

동적 파라미터 형식을 쓴다

#{} 는 (?***=xxxx) 와 같은 역할

정해져 있는 typeAliases를 쓰는것도 가능하지만 새로운 aliases를 정의 할 수 있다

```java
<typeAliases>
	<typeAlias alias="Author" type = "domain.blog.Author"/>
</typeAliases>
```

xml내 꺽세 기호를 쓰기 위해서는

```xml
select id, name, to_char(writedate,'yyyy"년"mm"월"dd"일"') writedate, memo from visitor where id 
<![CDATA[<]]> 5 
```

<![CDATA[<]]> 는 < 로 인식

Mapper를 사용하기 위한 API는 

```java
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
// SqlSessionFactory는 객체생성을 대신해주는 메소드
// SqlSessionFactoryBuilder() 를 이용하여 객체를 생성
SqlSession *var* = sqlSessionFactory.openSession();
// openSession(); 의 argument에 true를 준다면 자동 commit모드가 실행된다
// openSession(); 이 비어 있다면 자동 commit 모드가 비활성화 된다

```

