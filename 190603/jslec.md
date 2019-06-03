# JAVAScript

## [ BOM & DOM ]

### BOM :Browser Object Model

ㅂ라우저가 제공하는 자바스크립트 API

미리 객체를 생성해서 제공

- window, location, document, history, screen, navigator

1. location => href속성을 변경시켜주는 객체 ( 사이트 이동 )
2. window.open => 창을 열어주며 창에 여러 동작을 추가 할 수 있다
   - resize, resizeBy, moveBy, moveTo 등 
3. setInterval (func, 밀리초시간(밀리세컨드)), clearInterval (설정한 인터벌을 해제하는 명령어)
   - id = setInterval (func, millisec); 
     clearInterval(id);
     - 일정 시간이 흐를 때 마다 주기적으로 실행
   - id = setTimeout(func, millisec);
     clearTimeout(id);
     - 일정 시간이 흐른 후, 한 번만 실행
   - alert (), confirm(), prompt (), open ()
     - 서브창을 띄우는 명령어
   - href, reload()
4. history
   - go()
     - go(-1) : 바로 전페이지로 이동
   - go (n) : n번째 페이지로 이동
5. navigator
   - user-agent
   - getLocation()



### DOM : Document Object Model

읽혀진 웹페이지를 구성하는 html 속성과 태그들을 각각 javascript객체로 생성
브라우저 HTML 파서들은 파싱한 HTML 문서의 각각의 태그들, 태그의 속성들, 태그의 텍스트 형식의 컨텐트들 모두 자바 스크립트 객체로 생성

자바스크립트에서 접근 가능하도록 지원하기 위하여 브라우저가 호환을 지원
Document객체의 자손 객체로 등록
document.body 밑 태그들을 자손으로 등록

document.getElementById(); // id로 찾는법
document.getElemensClassName(); // class로 찾기
document.getElementsTagName();  // 태크명으로 찾기
document.getQuerySelector(); // CSS선택자로 찾기
document.getQuerySelectorAll(); 

### [ 이벤트 핸들러 구현 ]

이벤트 : 웹 페이지상에서 발생되는 일

1. 브라우저에서 자동으로 발생 (load)
2. 사용자의 액션에 의해서 발생
   (click, onmouseover, mouseent, mouseout, keyin, keypress, keyout, scroll, change, submit, reset, ...)

타겟 : 이벤트 발생된 대상 객체 (버튼 설정일 경우 버튼이 타겟)
이벤트 핸들러 (리스너) : 이벤트가 발생했을 시 수행되는 코드를 담고 있는 함수
이벤트 보델 : 특정한 타겟에서 정해진 이벤트가 발생했을 때 핸들러가 수행되도록 구현하는 방법

**(1)	인라인 이벤트 모델 (태그마다 구현 하기 때문에 유지 보수가 힘듬, 지역방식)**
**(2)	고전 이벤트 모델 (예전 부터 사용해 오던 모델, 전역 방식 == 자바 스크립트 영역에 따로 구현하는 방식)**
**(3)	표준 이벤트 모델 (W3C.org 에서 인정, 전역)**

<u>(1)	인라인 이벤트 모델 (지역)</u>

- 태그의 속성으로 등록
  - onclick, onmouseover등 onxxx = "코드"
    onclick(onClick, onCLICK) = "수행문장1; 수행문장 2; 수행문장 3;" 연속으로 지정 가능 하지만
    코드가 복잡해지기 때문에 때문에 함수 사용을 권장

<u>(2)	고전 이벤트 모델 (전역)</u>

- DOM 객체를 찾는다
  DOM객체. onxxx = 함수;
- 해제하는 방법
  DOM객체. onxxx = null;
- 고전 이벤트 모델은 하나의 dom모델에 함수를 추가 한다면 이전의 함수는 덮어씌워진다

<u>(3)	표준 이벤트 모델 (전역)</u>

- DOM객체를 찾는다
  정식으로 이벤트 핸들러를 등록하는 메소드를 가지고 있다
  DOM객체.addEventListner("xxx(이름)", 함수);
- 해제하는 방법
  DOM객체.removeEventListner("xxx(이름)", 함수);
- 표준 이벤트 모델은 하나의 dom모델에 함수를 추가 한다면 이전의 함수와 함께 출력된다

