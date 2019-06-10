```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>오늘의 날씨 정보</h1>
	<hr>

	<script>
		window.onload = function() {
			var request = new XMLHttpRequest();
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var str = request.responseText;
					var jsObj = JSON.parse(str);
					var output = "";

					output += "<h3>" + "기준시간 : " + jsObj['time'] + "</h3>";
					output += "<h3>" + "기온 : " + jsObj['temp'] + "도" + "</h3>";
					output += "<img src = " + jsObj['img'] + ">";
					document.body.innerHTML += output;
				}
			}
	 request.open("GET", "content/weather.jsp", true);
	 request.send();
		}

	</script>

</body>
</html>
```

