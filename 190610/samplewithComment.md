```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JavaScript로 구현하는 Ajax 프로그램-XML</h1>

<hr>
<script>

window.onload = function () { // 이 페이지에 대한 로딩이 끝나면
	var request = new XMLHttpRequest(); // 브라우저에 내장한 ajax 엔진 초기화
	request.onreadystatechange = function() { // 레디 스테이트 값이 변경 할때 마다 실행
		if(request.readyState == 4) { // 응답이 왔다 간것을 측정
			if (request.status == 200) {
				var xml = request.responseXML; // testxml을 파싱한 값
				//alert(xml);
				var rootE = xml.getElementsByTagName("testxml");
				var output = "";
				//alert (rootE[0].childNodes.length)
				for (var i = 1; i < rootE[0].childNodes.length; i+=2) {
					output += "<h2>" + rootE[0].childNodes[i].firstChild.nodeValue + "</h2>";
				} // XML에서 firstchild는 1부터 시작함
				alert(output);
				document.body.innerHTML += output;
			}
		}
	} 
	request.open("GET", "content/testxml.xml", true);
	request.send();
}

</script>

</body>
</html>
```

```xml
<?xml version="1.0" encoding="utf-8" ?>
<testxml>
    <name>자바스크립트</name>
    <age>22</age>
	<kind>웹앱개발 전용 OOP 언어</kind>
</testxml>
```

