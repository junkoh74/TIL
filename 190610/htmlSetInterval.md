```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	height: 100px;
	width: 600px;
	text-align: center;
}
</style>
<script>
window.onload = function() {
	setInterval(function() { // poling이라고 부름
		var request = new XMLHttpRequest();
		request.onload = function(event) {
			if (request.status == 200) {
				var str = request.responseText;
				var obj = JSON.parse(str);
				var target = document.getElementById('news');
				target.innerHTML = obj.news;
			}
		};
		request.open('GET', 'content/newsjson.jsp', true);
		request.send();
	}, 2000);
};	
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>뉴스 내용</th>
		</tr>
		<tr>
			<td id="news">...........................................</td>
		</tr>
	</table>
</body>
</html>
```

```jsp
<%@ page language="java" contentType="text/plain; charset=UTF-8"%> 
<% String news[] = { "교황 [세월호 유족 고통 앞에 중립 지킬 수 없어], 감동의 메시지 전달",
		"미래부, 'HTML5 지원' 웹브라우저 업그레이드 캠페인 실시",
		"이달 내 HTML5 기반 공인인증서 기술 보급된다",
  	    "액티브X 배제, 간편결제 활성화… 정부, ‘전자상거래 결제 간편화 방안’ 발표",
		"미래부, 공공정보 개방 확대...2016년까지 404종 개방"}; %>
<% response.setHeader("Cache-Control", "no-cache"); %>
<% int num = (int)(Math.random() * 5); %>
{ 
	"news" : "<%= news[num] %>"
}
```

