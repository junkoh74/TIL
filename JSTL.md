# JSTL

JSTL = JSP Standard Tag Library - 아파치 오픈 그룹이 만든 JSP의 커스텀 태그 모음

TAG 모음 (총 5가지) :: Core Library, XML Library위주로 교육
Core Library : 
i18n(**I**nternationalizatio**N**) Library (국제/각 국가와 알맞는)
SQL Library
XML Library : 
함수 Library

표준 태그와 커스텀 태그
<% xxxxx %> == JAVA 표준태그
<jsp: xxxx  > == JSP 표준 태그
<prefix:xxx > == JSP 커스텀 태그

| JSTL 태그    | 프리픽스 ( TAGLIB 지시자태그에 프리픽스를 설정가능) | 속성                                                         | 기능                                                         |
| ------------ | --------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Core Library | <c:set >                                            | 1. var : 변수 이름 <br />2. value : 변수의 값 <br />3. scope: page, request, session, application | 선언과  사용할 영역을 설정이 가능하다 (해당 페이지만, 해당 세션동안 등) |
|              | <c:remove>                                          | var : 삭제할 변수 이름                                       |                                                              |
|              | <c:out>                                             | EL과 비슷함 ( ${a}) 다른점은 EL은 없을 경우 null값 등 기본 value가 없지만 JSTL은 default 속성 설정이 가능하다 |                                                              |
|              | <c:if>                                              | test = 조건식                                                | <c:if test = "<%= some condition %>" var ="testResult"><br />처리 형식 및 실행 식<br /></c:if><br /><c:if .....><br />거짓일 때 형식 및 실행<br /></c:if> |
|              | <c:choose>, <c:when>, <c:otherwise>                 | test = 조건식                                                | choose안에 when을 무제한적으로 사용 가능하며 마지막에만 otherwise를 사용 |
|              | <c:forEach>                                         | traditional for 와 enhanced for와 비슷한 방식으로 사용 가능  | 1. traditional for<br /><c:forEach var = "i" begin "1" end "10" step"2"><br />${i}사용<br /></c:forEach><br /><br />2. enhanced for<br /><c:forEach var = "item" items "<% 배열%>" varstatus="ststus"><br />${status.index + 1} 번째 항목 ${item.name}<br /></c:forEach> |
|              | <c:forTokens>                                       | var : 저장된 값<br />items : 지정된 속성<br />delims : 지정된 구분자를 이용하여 각각 저장 | <c:forTokens var = "color" items= "red, green, blue" delims ","> ${color}</c:forToekns> <br />result => (red, green, blue) |
|              | <c:forTokens>                                       |                                                              | <c:forTokens var = "color" items= "red, green, blue, navy.purple" delims ",."> ${color}</c:forToekns><br />result => (red, green, blue, navy, purple) |
|              | <c:import>                                          | url : 주소<br />                                             | url 속성에 끌어오고자 하는 URL문자열을 주면 변수에 var에 보관하여 사용을 용이하게 도와주며 url에 query문자가 필요할 경우 <c:param name="" value="값"/>으로 입력이 가능<br /><c:import var="weather" url="http://www.kma.go.kr/wid/queryDFSRSS.jsp"><br /><c:param name="zone" value="1168064000"/><br /></c:import> |
|              | <c:catch>                                           | var : 예외가 발생 할 수 있는 코드                            | <c:catch var="ex"><br />name 파라미터의 값 = <% request.getParameter("name") %><br /><% if(request.getParameter("name").equals("test")) {%> ${param.net} 은 test입니다. <% } %><br /></c:catch><br /><c:if test = "${!empty ex}"><br />예외가 발생하였습니다 : ${ex}<br /></c:if> |
|              |                                                     |                                                              |                                                              |
|              |                                                     |                                                              |                                                              |
|              |                                                     |                                                              |                                                              |

css selector는 html을 위주로 쓰기 위하여 만들어졌고 Xpath는 xml을 위주로 쓰기위하여 만들어졌지만 모두 사용 가능하다

**XPath의 예제 :arrow_right: /wikimedia/projects/project/@name**

wikimedia의 자식 projects 의 자식 project의 name인 속성을 찾아라

//*[@="예"] => path보다는 "예"라는 문자가 들어간 문서를 찾는 것이 더 중요 할시

//*[@id="mw-content-text"]/div/h2[2]/span[3]

section//a => section의 모든 자손에서 a를 가지고 있는 정보를 찾아라
section/a => sectino의 자식에서 a를 가지고 있는 정보를 찾아라