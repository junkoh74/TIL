# 웹 날라간 내용 정리

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





