<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.NewsVO, java.util.ArrayList"%>
<%
	
%>
<!DOCTYPE html>
<html>
<style>
body {
	text-align: center;
}

table {
	margin-left: 20%;
	margin-right: 20%;
}

td {
	border-bottom: 1px dotted gray;
}

tr:hover {
	background-color: green;
}

td:nth-child(3) {
	width: 300px;
}
</style>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id='view_div'>
		<%
			ArrayList<NewsVO> list = (ArrayList<NewsVO>) request.getAttribute("list");
			if (list != null) {
		%>
		<h1 style="text-align: center">뉴스 게시판</h1>
		<table>
			<tr>
				<th style="color: blue">번호</th>
				<th style="color: red">제목</th>
				<th style="color: pink">작성자</th>
				<th style="color: orange">작성일</th>
				<th style="color: green">조회수</th>
			</tr>
			<%
				for (NewsVO vo : list) {
			%>
			<tr>
				<td class='<%=vo.getId()%>'><%=vo.getId()%></td>
				<td class='<%=vo.getId()%>'><a
					href="/springnews/news?action=select&select=true&id=<%=vo.getId()%>&title=<%=vo.getTitle()%>&writer=<%=vo.getWriter()%>&content=<%=vo.getContent()%>&writedate=<%=vo.getWritedate()%>"><%=vo.getTitle()%></a></td>
				<td class='<%=vo.getId()%>'><a
					href="/springnews/news?action=listwriter&writer=<%=vo.getWriter()%>">
						<%=vo.getWriter()%></a></td>
				<td class='<%=vo.getId()%>'><%=vo.getWritedate()%></td>
				<td class='<%=vo.getId()%>'><%=vo.getCnt()%></td>
				<td class='<%=vo.getId()%>' style="display: none"><%=vo.getContent()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<form Action="/springnews/news" method="get">
			<input type='hidden' name='action' value='search'>			
			<select
				name="searchType">
				<option value="title">title</option>
			</select>
			<input type="text" name="keyword"> 
			<input type="submit" value="뉴스검색">
		</form>
		<%
			}
			if (request.getAttribute("msg") != null) {
		%>
		<script>
			alert('${msg}')
		</script>
		<%
			}
		%>
	</div>
	<button onclick="location.href='/springnews/news'">뉴스 홈</button>
	<input type='submit' value="뉴스작성" onclick="writeNews()">
	<div id='write_div' style="display: none">
		<h1 style="text-align: center">뉴스 내용</h1>
		<form Action="/springnews/news" method="POST">
			<input type='hidden' name='action' value='insert'>
			<input id='m_writer' type='text' name='writer' placeholder="작성자명을 입력해주세요"><br>
			<input id='m_title' type='text' name='title' placeholder="제목을 입력해주세요">
			<br>
			<br>
			<textarea rows="10" cols="30" id='m_content' name="content" placeholder="내용을 입력해주세요"></textarea>
			<br> <input id="first" type='submit' value='저장'>
			<input id="second" type='reset' value='재작성'>
			<input type="button" id="third" value='취소' onclick="display(2)">
		</form>
	</div>
	<%
		if (request.getParameter("select") != null) {
	%>
	<div id='select_div'>
		<h1 style="text-align: center">뉴스 내용</h1>
		<form Action="/springnews/news" method="POST">
			<input type='hidden' name='action'
				value=<%=request.getParameter("id")%>> 
			<input id='u_writer' type='text' name='writer' value="<%=request.getParameter("writer")%>"><br>
			<input id='u_title' type='text' name='title' value="<%=request.getParameter("title")%>"><br>
			<textarea rows="10" cols="30" id='u_content' name="content"><%=request.getParameter("content")%></textarea>
			<br> 
			<input id="first" type='submit' value='확인'>
			<input id="second" type='reset' value='다시쓰기'>
			<input id="third" onclick="selectNews(<%=request.getParameter("id")%>)" type='button' value='삭제'>
		</form>
	</div>
	<%
		}
	%>
	<script>
		function display(type) {
			if (type == 1)
				document.getElementById("write_div").style.display='block';
			else if (type == 2)
				document.getElementById("write_div").style.display='none';
			else if (type == 3)
				document.getElementById("select_div").style.display='block';
			else if (type == 4)
				document.getElementById("select_div").style.display='none';
		}
		function writeNews() {
			display(1);
			display(4);
			document.getElementById("m_writer").value = "";
			document.getElementById("m_title").value = "";
			document.getElementById("m_content").value = "";
			document.querySelector("#first").value = "저장";
			document.querySelector("#first").type = "submit";
			document.querySelector("#second").value = "재작성";
			document.querySelector("#second").type = "reset";
			document.querySelector("#third").value = "취소";
			document.querySelector("#third").type = "button";
			document.getElementById("third").onclick = function() {
			document.getElementById("write_div").style.display = 'none';
			};
			document.querySelector("#write_div [type=hidden]").value = "insert";
		}

		function selectNews(cv) {
			var doms = document.getElementsByClassName(cv);
			if(cv == null){
				document.getElementById("select_div").style.display = 'none';
			}			
			else {
				document.location.href = "/springnews/news?action=delete&id=" + cv;
			}
		}
	</script>
</body>
</html>