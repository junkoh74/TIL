# NEWS PAGE Project

(1) SQL DB 테이블 생성
(2) NewsVO.java 생성
(3) NewsDAO.java 생성
-------------------------------------------- JUnit 테스트
(4) NewsServlet.java
(5) news.jsp 생성

(1) SQL DB 테이블 생성

```sql
CREATE TABLE news (
    id NUMBER(8)
    , writer VARCHAR2(18) NOT NULL
    , title VARCHAR2(120) NOT NULL
    , content VARCHAR2(900) NOT NULL
    , writedate DATE
    , cnt NUMBER
);
```



(2) NewsVO

```java
package model.vo;

public class NewsVO {
	private int id;
	private String writer;
	private String title;
	private String content;
	private String writedate;
	private int cnt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "NewsVO [id=" + id + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", writedate=" + writedate + ", cnt=" + cnt + "]";
	}
}
```

(3) NewsDAO.java

```java
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.MeetingVO;
import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest"
            		, "jdbctest");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
		return conn;
	}
	
private void close(Connection conn, Statement stmt, ResultSet rs) {
		try{
			if(stmt != null) {
				stmt.close();
			}
            if(rs != null) {
            	rs.close();
			}
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	

	public boolean insert(NewsVO vo) {
		boolean result = true;
		Connection conn = connectDB();
		try (PreparedStatement pstmt = conn.prepareStatement("insert into news values(news_seq.nextval"
						+ ", ?"
						+ ", ?"
						+ ", ?"
						+ ", to_date(sysdate, 'yyyy-mm-dd')"
						+ ", ?)");) {
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt());
			pstmt.executeUpdate();
			close(conn, null, null);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
		
	public boolean update (NewsVO vo) {
		boolean result = true;
		Connection conn = connectDB();
		try (PreparedStatement pstmt = conn.prepareStatement(
						"update news set"
						+ " writer=?"
						+ ", title=?"
						+ ", content=?"
						+ ", writedate=to_date(sysdate, 'yyyy-mm-dd')"
						+ ", cnt=? "
						+ "where id = ?");) {
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(4, vo.getCnt());
			pstmt.executeUpdate();
			close(conn, null, null);
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		Connection conn = connectDB();
		try (PreparedStatement pstmt = conn.prepareStatement("delete from news where id = ?");) {
			pstmt.setInt(1, id);
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
	public ArrayList<NewsVO> listAll() {
		Connection conn = connectDB();
		ArrayList<NewsVO> list = new ArrayList<NewsVO>();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
								"select "
								+ "id, "
								+ "writer, "
								+ "title, "
								+ "content, "
								+ "to_char(writedate, 'yyyy-MM-dd'), "
								+ "cnt "
								+ "from news");) {
			NewsVO vo;
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
				list.add(vo);
			}
			close(conn, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public NewsVO listOne(int id) {
		Connection conn = connectDB();
		NewsVO vo = null;
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
                    "select id"
                    ", writer"
                    ", title"
                    ", content"
                    ", to_char(writedate, 'yyyy-mm-dd')"
                    ", cnt from news where id="+ id);) {
			while (rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWritedate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
			}
			close(conn, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<NewsVO> listWriter(String writer) {

		return null;
	}
}
```

현재 : 새로쓰기 O

​		홈 O
​		업데이트 X
​		삭제 O

important to remember to allow => Post method request.setCharacterEncoding("UTF-8");

NewsServlet.java

```java
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
//		String key = request.getParameter("search");
//		String searchType = request.getParameter("searchType");

		NewsDAO dao = new NewsDAO();
//		System.out.println(3);
		if (action != null) {
			if (id != null && action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(id));
				if (result) {
					request.setAttribute("msg", "글 삭제 성공");
				} else {
					request.setAttribute("msg", "글 삭제 실패");
				}
			}
//			else if(action.equals("search")) {
//				List<NewsVO> list = dao.search(key, searchType);
//				if(list.size() == 0) {
//					request.setAttribute("msg", id+"값과 일치하는 글이 없음");
//				} else {
//					request.setAttribute("list", list);
//				}
//			}
//		}	else {
//			ArrayList<NewsVO> list = (ArrayList<NewsVO>) dao.search(key);
//			if (list.size() == 0) {
//				request.setAttribute("msg", key + "를 담고있습니다.");
//			} else {
//				request.setAttribute("list", dao.search(key));
//			}
		}
//		System.out.println(1);
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
//		System.out.println(1);
		if (action.equals("insert")) {
			boolean result = dao.insert(vo);
//			System.out.println(1);
			if (result) {
				request.setAttribute("msg", writer + "님의 글 게시등록 성공");
//				System.out.println(2);
			} else {
				request.setAttribute("msg", writer + "님의 글 게시등록 실패");
			}
		} else {
			vo.setId(Integer.parseInt(action));
//			System.out.println(5);
			System.out.println(vo.getId());
//			System.out.println(6);
			boolean result = dao.update(vo);
			if (result) {
//				System.out.println(7);
				request.setAttribute("msg", writer + "님의 게시글 수정 성공");
//				System.out.println(8);
			} else {
//				System.out.println(9);
				request.setAttribute("msg", writer + "님의 게시글 수정 실패");
//				System.out.println(10);
			}
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}

}
```

