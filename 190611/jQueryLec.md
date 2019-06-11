# jQueryLec

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