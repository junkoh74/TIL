# 웹 내용

## HTML5 추가 기능

비디오/오디오 재생 기능

서버로서의 역할은 줄어 들고 클라이언트로서의 비중이 커짐



## 내용

html은 <> 기호가 가장 많이 쓰이고 중요한 명령어이기 때문에 문자로 사용하기 위해서는 특수한 방법이 필요하다

<내용>을 문자로써 사용하기 위해서는  == `&lt;` less than; `&gt;` greater than;

html5로 넘어 오면서 html, css, javascript의 영역이 더 확실해지며 iOS, Android를 구분하여 웹을 만들기보다는 통합적으로 만들기 수월하도록 간단하게 분업화

기본 html5 문서구조

```html
<!doctype html>
    <html>
        <head>
   		<title></title>
        </head>
        <body>
            <form>
               다양햔 form을 사용한 웹 구성 요소 
            </form>
        </body>
</html>
```
![1558940598149](C:\Users\student\AppData\Roaming\Typora\typora-user-images\1558940598149.png)

테이블 구조

```html
<!doctype html> 
        <html>
        <head>
   		<title></title>
        </head>
            <h1></h1>
        <body>
            <table>
            <tr>사이에 <th></th> 혹은 <td></td> 를 넣어 테이블임을 입력</tr>
            <tr><th></th><tr> : 열의 갯수 만큼 -- 3열 테이블 == <tr><th></th><th></th><th></th></tr>
            <tr><td></td></tr> : 열의 갯수 -- 3열 테이블 == <tr><th></th><th></th><th></th></tr>
            <tr><td></td></tr> :행의 갯수만큼 반복 사용
            </table>
        </body>
</html>
</!doctype>
```
colspan == 열병합 <th colspan #>

rowspan == 행병합 <td rowspan #>

figcaption 태그 로 사진과 글은 묶어서

i 태그, em 태그

# 190528

HTML5는 특수한 경우가 아닌한 여러 공백을 한개로 인식

여러 종류의 공백 표기 코드

##  

# CSS

CSS = Cascade Styling Sheet

HTML 없이는 CSS가 존재 할 수 없다

작성은 2가지로 html과 css를 따로 생성하거나 html과 css를 한번에 

<style> 
    선택자 {
        css속성명 : 속성값;
    }
</style>

**선택자 종류**

1. 전체 선택자 : *

2. 태그선택자 (타입 선택자) : 태그명
3. 그룹 선택자 - .class 속성값
4. 아이디 선택자 - #id속성값
5. 자식선택자 - 부모태그>자식태그
6. 자손선택자 - 조상태그 자손태그
7. 형제선택자 - 언니태그~동생태그(동생태그 전부), 언니태그+동생태그(특정 동생태그만)
8. 속성선택자
   - [속성명]
   - [속성명 = 속성값]
   - [속성명^=속석값]
   - [속성명$ =속성값] : img [src$ = png]

hover : 마우스가 올라갔을 경우 변화를 표현 할 때 사용



## HTML 태그에 대한 렌더링 규칙 (1)

태그마다 출력되는 영역을 정하는 규칙에 따라 inlinesyle태그와 blockstyle태그로 나뉜다

inlinestyle : a, img, input, span

blocksyle : h#, div (....), table, ul, ol, p, form

블락 타입과 인라인 스타일은 각각 다른 정렬 기능을 사용해야한다

같은 이름의 태그 별로 스타일을 부여 할경우 class = " "를 사용하여 각기 설정

크기를 정하는 속성에 ''##%''로 부여한다면 창 크기에 따른 자동 크기 조정을 할 수 있도록 HTML5가 지원

**블락타입** 

텍스트는 text-align을 이용하여 좌, 우, 가운데정렬이 가능하다

하지만 높이 가운데 정렬을 자동으로 해주는 기능은 없다

여러 방법중 하나는 height와 padding-top을 이용하여 조절

CSS내에서는 margin을 자동 중앙 정렬 기능이 없다

하지만 margin : # px auto; 을 통해서 같은 결과를 얻어낼 수 있다

<style>
    margin : 5 px auto;
    이것은 아래와 같은 의미다
    margin-top : 5px;
    margin-bottom : 5px;
    margin-left : auto;
    margin-right : auto;
</style>

**인라인 스타일**

각각의 개체로 생성 되어 있기 때문에 text-align, margin을 할 경우 페이지 중간이 아닌 자신의 공간에서 정렬을 하기때문에 페이지 전체를 대상으로 정렬할 경우 인라인 스타일전체를 블락 타입으로 묶어 준 이후 정렬 기능을 삽입	



**테이블**

- 테이블의 크기는 입력하는 내용에 영향을 받는다
- 테이블은 영역이 정해진 블락 타입

table에 스타일을 입히기 위해서는 table태그에만 스타일을 넣어주는 것이 아닌, th, td 모두에게 입력을 해줘야만함

table, th, td : 테이블 전체부터 각 항목 전체에 영향

table : 테이블 밖의 전체에 영향

th : 테이블 헤딩에 영향

td : 테이블 데이터에 영향



**보더만들기**

nth-of-type(#)로 같은 여러 태그에 각각 클래스를 부여 하지않고 스타일을 입힐 수 있다 

( div:nth-of-type(1) = 첫번째 div 속성 )

border를 이용하여 border 속성을 정하고

border-radius를 이용하여 보더의 둥근 모양을 표현할 수 있다



**그라디언트**

속성을 정하는 영역에 

<style>
    속성부여 영역 { 
        스타일 종류 : linear-gradient (to bottom(top, left, right 등 방향), color, color, 색을 더 더할 수 있다) 
        text shadow : 오른쪽으로 왼쪽으로 번짐효과 색깔;
        text shadow : 2px 2px 2px white; //텍스트의 그림자를 2px 오른쪽으로 이동, 2px 왼쪽으로 이동 2px번지게 하고 하얀색으로 칠함
    }
</style>




## [웹페이지를 디자인 할 때]

1. 모바일
2. PC + 모바일 : 반응형 웹디자인 혹은 PC 디자인 따로 모바일 디자인 따로 생성

http://unico2013.dothome.co.kr/resweb/exam2.html

http://unico2013.dothome.co.kr/resweb/exam3.html

http://unico2013.dothome.co.kr/resweb/exam4.html

http://unico2013.dothome.co.kr/resweb/exam5.html



http://unico2013.dothome.co.kr/resweb/exam1.html

http://unico2013.dothome.co.kr/resweb/exam1_1.html

## [JavaScript]

JAVA : 범용 언어 (특별한 제약 없시 사용가능), OOP, 썬마이크로시스템즈 -> 오라클

JavaScript : 동적인 웹페이지 제작에 사용되는 언어, OOP

- 넷스케이프 -> ECMA (오픈언어)
- 정적인 웹페이지를 생산하는 HTML을 보완하는 프로그래밍 언어이며 라이브 스크립트
- CSS와 동일하게 HTML 문서안에 작성해도 되고 독립된 파일로 만들어 HTML문서 안으로 IMPORT

**[JavaScript 구문 정리]** 

1. 데이터 타입, 변수 생성 방법
2. 연산자
3. 제어문
4. 배열 구문
5. 함수
6. 객체 생성
   - 객체 리터럴 방식
   - 클래스 객체 생성 방식

## 구문 정리

document.write ("내용");

console.log ("내용");

JS는 어떠한 타입도 입력할 수 있다

## [ 자바 스크립트의 배열]

배열 생성 방법 :

1. 배열 리터럴
   - [값1, 값2, 값3]
2. 표준 API( Array( ) ) 로 객체를 생성하여 만드는 방법
   - new Array( )
   - new Array(#)
   - new Array(값1, 값2, 값3, 값4, 값5)



**자바 스크립트 배열의 특징**

- 하나의 배열에 저장되는 데이터 타입의 제한이 없다
- 배열이 생성된 이후에도 배열의 크기를 변경할 수 있다

```javascript
// 데이터 타입의 제한 이 없는 자바 스크립트
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>배열 생성과 활용 (1)</h1>
<hr>
<script>
var a1 = [];
document.write("<h3>" + typeof a1 + "</h3>");
document.write("<h3>" + Array.isArray(a1) + "</h3>");
document.write("<h3>" + a1.length + "</h3>");
document.write("<h3>" + a1[0] + "</h3>");
document.write("<hr>");
a1[4] = 100;
document.write ("<h3>" + a1.length + "<h3>");
for (var i = 0; i < a1.length; i++){
	document.write("<h4>" + a1[i] + "<h4>");	
}
document.write("<hr>");
for (var i in a1) { //자바는 값이 들어가지만, 자바스크립트는 인덱스를 넣는다
	document.write("<h4>" + a1[i] + "<h4>");
}
document.write("<hr>");
 var a2 = [10, '가나다', true, 3.5]
 for (var i in a1) { //자바는 값이 들어가지만, 자바스크립트는 인덱스를 넣는다
		document.write("<h4>" typeof a2[i] + ":" + a1[i] + "<h4>");
	}
 
</script>
</body>
</html>
```



```java

```



### [ 함수 정의와 활용]

**함수의 정의**

1. 선언적 함수 정의 (명시적 함수 정의)

   - function 함수명 (매개변수 리스트) {

     ​				:

     ​				:

     return 리턴값; // 필수가 아님

     // 리턴값 없이 리턴한다면 : undefined 가 리턴됨

     }

   - 함수명 ();

   - var v = 함수명 ();

   - 함수명 (아규먼트리스트);
     - 

2. 표현식 방식의 함수정의 혹은 이름이 없는 함수라는 익명함수

   - function (매개변수리스트) {

     ​	:

     ​	:

   }

   - var 함수명 = function (매개변수 리스트) {

     

     }

   - f1(function () {...........});

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>함수</h1>
<hr>
<script>

var sum;
var ran = Math.floor(Math.random()*6);

sum = function (num){
	var total = 0;
    if (num) { // num 이 0이거나 전달되지 않는 다면 false, 값이 전달 된다면 true
		for (var i = 1; i <= num; i++) {
			total += i;
		}
			return total;
	}
}

if (ran == 0) {
	result = sum();
} else {
	result = sum(ran)	
}

if(result) {
	document.write("호출 결과값 : " + result);
} else {
	document.write("결과값이 없어요");
}

</script>
</body>
</html>
```



호출시 아규먼트의 갯수가 제한없는 함수 만들기

function out ( ) {

}

함수가 호출될 때 arguements라는 지역변수가 자동으로 초기화 된다 

- 함수 호출시 전달되는 아규먼트들을 유사배열 객체에 담아서 arguements 변수에 할당한다