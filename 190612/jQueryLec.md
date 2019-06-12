# jQueryLec

 $(아규먼트).xxx()
$.xxx()

each()

var ary = [10, 20,30,40,50];

$(ary).each(function(index, data) {  });

$.each(ary, function(index, data) {  })

$(아규먼트)

$(argument)

$(JavaScript 객체)

$("CSS selector name")

$("CSS selector name", DOM 객체)

$("HTML Tag 문자열") => HTML Tag 문자열의 DOM 객체를 만들어줌

$(함수) == window.onload() = 함수 => 로드가 끝나면 실행

$(함수) == $(document).ready(함수) == window.onload = 함수 => 문서의 준비가 끝날경우 실행

jQuery는 표준 이벤트 모델로 변환하여 이벤트를 실행

$(...).val()  방법은 다 다르지만, 사용에 일관성이 있다

val () : getter

val (argument) : setter
	값 혹은 함수 입력가능

html () : getter

html(argument) : setter
	값 혹은 함수 입력가능

css("속성명") : getter

css("속성명", "속성값" / 함수) : setter

css({"속성명, 속성값"....}) : setter



**[칼라 설정시]**

#000000 => 색갈은 RGB를 2진수로 표현한 것이지만 2진수코드가 모드 동일할경우 한개로 줄일수 있다
#000000 == #000, #FFFFFF == #FFF

$('tr:first').css('background', '#000000').css('color', '#FFFFFF' );
한번에 연이어서 설정을 넣을수 있다 (Chaining method)

### *혹은*

$('tr:first').css({ 'background': '#000000', 'color': '#FFFFFF' });
설정하고자 하는 속성을 { } 안에 입력하여 설정이 가능하다

**$.each(ary, function(index, data) {  })**

```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script>
        $(document).ready(function () {
            // 변수를 선언합니다.
            var array = [
                { name: 'Hanbit Media', link: 'http://hanb.co.kr' },
                { name: 'Naver', link: 'http://naver.com' },
                { name: 'Daum', link: 'http://daum.net' },
                { name: 'Paran', link: 'http://paran.com' }
            ];

            // $.each() 메서드를 사용합니다.
            $.each(array, function (a, b) {
                // 변수를 선언합니다.
                //alert(a);
                 var output = '';
                // 문자열을 만듭니다.
                // array안에 들어가는 output을 연결하여 $.each를 구동
                output += '<a href="' + b.link + '">';
                output += ' <h1>' + b.name + '</h1>';
                output += '</a>';
                // 집어넣습니다.
                document.body.innerHTML += output;
            });
        });
    </script>
</head>
<body>

</body>
</html>

```



```html
$('h3').css('backgroundColor', 'pink')
                         .filter('.group').css('color', 'cyan')
                                     .end().filter('#target').css('color', 'yellow');

// 전체 h3 tag를 찾아 적용
// group 클래스를 필터하여 적용
// end() == 전 필터가 적용되기 전 조건을 불러온후 필터하여 적용, 다수의 end ().end().end()을 연결가능
```

```html
$('h1').eq(0).css('background', 'Orange');
            $('h1').eq(-1).css('background', 'Red');

// eq(#) 몇번째 배열에 대한 속성 입력, 0 == 첫번째, -1 == 마지막
```

## [ ATTR 속성을 지정 ]

attr("속성명") : getter

attr("속성명", "속성값" / 함수) : setter

attr({"속성명, 속성값"....}) : setter

jQuery내 찾는 값은 모든 값을 찾지만
추출하는 값은 맨 첫 값만 내보냄
전부를 내보내기 위해선 each

## [ 이벤트 등록하기 ]

이벤트마다 각각의 이름이 존재하여 이름으로 등록이 가능하고
on 메소드를 사용하여도 이벤트 등록이 가능함

## [ append ]

```html
            $('body').append(h1, h2, h1, h2); 
			// 자식을 추가
```



## [ 이벤트 ]

이벤트 사용하기

1. 이벤트 이름 (함수)
2. on ("이벤트 이름", 함수)
   click 이벤트 사용시, 

1. click (함수)
2. on ("click", 함수)
   off ()

**트리거이벤트**

강제로 이벤트 발생

```html
                $(document).ready(function () {
            $('h1').on('click', function () {
                var length = $('h1').length;
                var targetHTML = $(this).html();
                $('#wrap').append(
                		'<h1>' + length + ' - ' + targetHTML + '</h1>');
            });
        });
// 준비가 되면 실행하는 속성이기 때문에 이후에 추가되는 h1태그들에게는 이벤트 핸들러가 적용이 안됨

$(document).ready(function () {
            $(document).on('click', 'h1', function () {
                var length = $('h1').length;
                var targetHTML = $(this).html();
                $('#wrap').append('<h1>' + length + ' - ' + targetHTML + '</h1>');
            });
        });

// 준비가 되면 실행하며 document에 다시한번 h1태그에 대한 이벤트 핸들러가 적용되기에 모든 h1태그에 이벤트가 적용 가능해짐
```

**keydown 이벤트**

```html
        $(document).ready(function (event) {
            $('textarea').keydown(function () {
                // 남은 글자 수를 구합니다.
                var inputLength = $(this).val().length;
                var remain = 150 - inputLength;

                // 문서 객체에 입력합니다.
                $('h1').html(remain);

                // 문서 객체의 색상을 변경합니다.
                if (remain >= 0) {
                    $('h1').css('color', 'Black');
                } else {
                    $('h1').css('color', 'Red');
                }
            });
        });
```

일반태그의 컨텐트 : html(), text()

form 태그의 서브 태그들은 : val ()로 설정하지만 textarea 만큼은 html(), text(), val() 전부 적용 가능함

**change 이벤트**

      <!DOCTYPE html>
    <html>
    <head>
        <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script>
      $(document).ready(function () {
            $('#all_check').change(function () {
                if (this.checked) {
                    $('div>input[type=checkbox]').prop('checked', true);
                   
                } else {
                    $('div>input[type=checkbox]').prop('checked', false);
                }
            });
        });
            </script>
    </head>
    <body>
    <body>
        <input type="checkbox" id="all_check"/>
        <label>All</label>
        <div id="check_item">
            <label><input type="checkbox"/>
            A Option</label>
            <label><input type="checkbox"/>
            B Option</label>
            <label><input type="checkbox"/>
            C Option</label>
        </div>
    </body>
    </html>