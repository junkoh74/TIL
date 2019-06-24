## Visitor Page

update visitor set id = visitor_seq.nextval

reqeust.getHeader("referer") : 이번 요청을 보내온 클라이언트 웹페이지의 URL을 추출해 준다.

수정 기능은 어떤 요청 방식?
	-- 미팅 정보 수정 이미지 버튼이 클릭 되었을 시 정보를 수정하기위한 입력 폼 화면 출력 -- GET방식
    -- 미팅 정보 수정 폼에서 '수정하기' 버튼이 클릭 되었을 때 - POST (HIDDEN 타입)

visitorForm.html -----> / <u>visitor ====> /jspexam/visitorView.jsp</u>
									For Client, it considers as one format, even though it has separate development page, while 									operating, client treats as one page (merged)

```sql
alter table visitor add id number(4)

create sequence visitor_seq
start with 1
increment by 1
```

Request by link, href, a tag, etc. all of those should use the method as "get"

```java
conn = DriverManager.getConnection("JDBCURL문자열", "계정", "암호");
pstmt = conn.prepareStatement("INSERT INTO datetest_t VALUES (?, ?)");
SimpleDateFormat df = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
java.util.Date d=df.parse(year+"년"+month+"월"+date+"일 "+hour+"시"+minute+"분");
pstmt.setString(1, name);
pstmt.setTimestamp(2, new java.sql.Timestamp(d.getTime()));
pstmt.executeUpdate();
```

Date format as in JAVA



## Meeting Exercise::

FILE INFO ==  MeetingDAO.java (interface), meetingform.html, MeetingJDBCDAO.java, MeetingServlet.java, Meeting.java

**MeetingDAO.java (interface)**

```java
package model.dao;

import java.util.List;
import model.vo.MeetingVO;

public interface MeetingDAO {
	public List<MeetingVO> listAll();
	public boolean insert (MeetingVO vo);
	public List<MeetingVO>search(String keyword);
	public boolean delete(int eNo);
	public boolean update (MeetingVO vo);
}
```

**meetingform.html**

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>미팅 리스트</h1>
<hr>
<form method = "post" action = "/mvc/meeting">

<label id = name>이름 : </label>
<input type = "text" name = "name">
<br>
<br>
<label id = title>메모 : </label>
<br>
<textarea name = "title" rows = "10" cols = "30"></textarea>
<br>
<br>
<label id = date>날짜 : </label>
<input type = "datetime-local" name = "date">
<br>
<!-- <br>
<label id = time>시간 : </label>
<input type = "time" name = "time">
<br> -->
<br>
<input type = "submit" value = "등록">
<input type = "reset" value = "재작성">

</form>
<form method = "get" action = "/mvc/meeting">
검색어 : <input type = "search" name = "keyword">
<input type = "submit" value = "검색">
</form>
<br>
<br>
<button onclick = "schedule()">전체 미팅 스케줄</button>

<script>

function schedule() {
	location.href = "/mvc/meeting";
}

</script>

</body>
</html>
```

**MeetingJDBCDAO.java**

```java
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.vo.MeetingVO;

public class MeetingJDBCDAO implements MeetingDAO {
	public ArrayList<MeetingVO> listAll() {
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("select id, name, title, meetingDate from meeting");) {
			MeetingVO vo;
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean insert(MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				PreparedStatement pstmt = conn
						.prepareStatement("insert into meeting values(meeting_seq.nextval" + ", ? , ?, to_date(?, 'yyyy-mm-dd\"T\"hh24:mi'))");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getDate());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public List<MeetingVO>search(String keyword) {
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select id, name, title, meetingDate from meeting" 
						+ " where title like '%" + keyword + "%'");) {
			MeetingVO vo;
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean delete(int eNo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				PreparedStatement pstmt = conn.prepareStatement("delete from meeting where id = ?");) {
			pstmt.setInt(1, eNo);
			int deleteNum = pstmt.executeUpdate();
			if (deleteNum != 1) {
				result = false;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public boolean update (MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				PreparedStatement pstmt = conn
						.prepareStatement("update meeting set "
											+ "name = ?"
											+ ", title = ?"
											+ ", meetingDate = to_date(?, 'yyyy-mm-dd\"T\"hh24:mi')"
											+ " where id = ?");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getDate());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}
```

**MeetingServlet.java**

```java
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MeetingJDBCDAO;
import model.vo.MeetingVO;

/**
 * Servlet implementation class MeetingServlet
 */
@WebServlet("/meeting")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URL = "/jspexam/meetingView2.jsp";
		String keyword = request.getParameter("keyword");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		if (keyword == null) {
			if (action == "delete") {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "글이 삭제되었습니다.");
				} else {
					request.setAttribute("msg", "글 삭제를 실패하였습니다.");
				}
			}
			request.setAttribute("list", dao.listAll());
//		} else if (action == "update") {
//				boolean result = dao.selectOne(Integer.parseInt(id));
//				if (result) {
//					request.setAttribute("msg", "글이 삭제되었습니다.");
//				} else {
//					request.setAttribute("msg", "글 삭제를 실패하였습니다.");
//				}
//			}
		} else {
			request.setAttribute("list", dao.listAll());
			ArrayList<MeetingVO> list = (ArrayList<MeetingVO>) dao.search(keyword);
			if (list.size() == 0) {
				request.setAttribute("msg", keyword + "를 담고있습니다.");
			} else {
				request.setAttribute("list", dao.search(keyword));
			}
		} request.getRequestDispatcher(URL).forward(request,response);

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String URL = "/jspexam/meetingView2.jsp";
		response.setContentType("text/html; charset = utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String date = request.getParameter("date");

		MeetingJDBCDAO dao = new MeetingJDBCDAO();
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setDate(date);
		boolean result = dao.insert(vo);
		if (result) {
			request.setAttribute("msg", name + "님의 글이 성공적으로 입력되었습니다.");
		} else {
			request.setAttribute("msg", name + "님의 글이 입력에 실패하였습니다.");
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher(URL).forward(request, response);
		;
	}

}
```

**MeetingVO.java**

```java
package model.vo;

public class MeetingVO {
	private int id;
	private String name;
	private String title;
	private String meetingDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return meetingDate;
	}
	public void setDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	
	@Override
	public String toString() {
		return "MeetingVO [id = " + id + ", name = " + name + ""
				+ ", title = " + title + ", meetingdate = " + meetingDate + "]";
	}
	
	
}
```

