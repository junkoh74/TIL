package edu.spring.springnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired
	NewsDAO dao;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	protected ModelAndView select1(NewsVO vo, String keyword, String action) {
		ModelAndView mav = new ModelAndView();
		System.out.println("start");
//		if (vo.getWriter() != null && vo.getTitle() != null && vo.getContent() != null) {
//			if ((action != null && action.equals("insert"))) { // insert
//				boolean result = dao.insert(vo);
//				System.out.println(2);
//				if (result) {
//					mav.addObject("msg", "성공적으로 저장되었어요.");
//				} else {
//					mav.addObject("msg", "작성을 실패했어요.");
//				}
//				List<NewsVO> list = dao.listAll();
//				mav.addObject("list", list);
//			} else if (action != null && !action.equals("insert")) { // update
//				System.out.println(3);
//				vo.setId(Integer.parseInt(action));
//				vo.setCnt(vo.getCnt()+1);
//				boolean result = dao.update(vo);
////				dao.countNews(vo);
//				if (result) {
//					mav.addObject("msg", vo.getId() + "번 글이 업데이트 되었습니다.");
//				} else {
//					mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
//				}
//				List<NewsVO> list = dao.listAll();
//				if (list.size() != 0) {
//					mav.addObject("list", list);
//				} else {
//					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
//				}
//			}
//		} 				
			System.out.println("get begin");
			if (vo.getId() != 0 && action.equals("delete")) { // delete
				System.out.println("delete");
				System.out.println(vo.getId());
				boolean result = dao.delete(vo.getId());
				if (result) {
					mav.addObject("msg", vo.getId() + "번 글이 삭제되었습니다.");
				} else {
					mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
				}
				List<NewsVO> list = dao.listAll();
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
				} 
			} 
//			else if (vo.getId() == 0 && keyword == null) { // List All
//				List<NewsVO> list = dao.listAll();
//				if (list.size() != 0) {
//					mav.addObject("list", list);
//				} else {
//					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
//				}
//			} 
			else if (vo.getId() != 0 && action.equals("select")) {
				System.out.println("listone");
				System.out.println("cnt = " + vo.getCnt());
				List<NewsVO> list = dao.listOne(vo);
				if (list != null) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "해당 글이 없습니다.");
				}  
			} else if (vo.getWriter() != null && action.equals("listwriter")) {
				System.out.println("listwriter");
				List<NewsVO> list = dao.listWriter(vo.getWriter());
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
				}  
			} 	else if (keyword != null && action.equals("search")) { // searchTitle
				System.out.println("search");
				System.out.println();
				System.out.println("title " + vo.getTitle());
				List<NewsVO> list = dao.search(keyword);
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", keyword + "로 검색된 미팅 정보가 없습니다.");
				}
			} else {
				System.out.println("listall");
				List<NewsVO> list = dao.listAll();
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
				}  
			}
			
//		else { // searchTitle
//			System.out.println("22");
//			System.out.println(keyword);
//			System.out.println("title " + title);
//			List<NewsVO> list = dao.search(keyword);
//			if (list.size() != 0) {
//				mav.addObject("list", list);
//			} else {
//				mav.addObject("msg", keyword + "로 검색된 미팅 정보가 없습니다.");
//			}
//		}
			System.out.println("finish get");
			mav.setViewName("newsView");
			return mav;
		}
//	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	protected ModelAndView select2(NewsVO vo, String keyword, String action) {
		ModelAndView mav = new ModelAndView();
		System.out.println("post begin");
		if (vo.getWriter() != null && vo.getTitle() != null && vo.getContent() != null) {
			System.out.println("setting begin");
			if ((action != null && action.equals("insert"))) { // insert
				System.out.println("insert");
				boolean result = dao.insert(vo);
				System.out.println("insert");
				System.out.println("content" + vo.getContent());
				System.out.println("title" + vo.getTitle());
				if (result) {
					mav.addObject("msg", "성공적으로 저장되었어요.");
				} else {
					mav.addObject("msg", "작성을 실패했어요.");
				}
				List<NewsVO> list = dao.listAll();
				mav.addObject("list", list);
			} else if (action != null && !action.equals("insert")) { // update
				System.out.println("update");
				vo.setId(Integer.parseInt(action));
				vo.setCnt(vo.getCnt() + 1);
				boolean result = dao.update(vo);
				System.out.println("result = " + result);
				System.out.println(vo.toString());
//				dao.countNews(vo);
				if (result) {
					mav.addObject("msg", vo.getId() + "번 글이 업데이트 되었습니다.");
				} else {
					mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
				}
				List<NewsVO> list = dao.listAll();
				if (list.size() != 0) {
					mav.addObject("list", list);
				} else {
					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
				}
			}
//		else if (vo.getId() != 0) { // delete
//			System.out.println(vo.getId());
//			boolean result = dao.delete(vo.getId());
//			if (result) {
//				mav.addObject("msg", vo.getId() + "번 글이 삭제되었습니다.");
//			} else {
//				mav.addObject("msg", vo.getId() + "번 글이 존재하지 않습니다.");
//			}
//			List<NewsVO> list = dao.listAll();
//			if (list.size() != 0) {
//				mav.addObject("list", list);
//			} else {
//				mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
//			}
//		}
//			else if (vo.getId() == 0 && keyword == null) { // List All
//				List<NewsVO> list = dao.listAll();
//				if (list.size() != 0) {
//					mav.addObject("list", list);
//				} else {
//					mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
//				}
//			}
//		else if (vo.getId() != 0) {
//			System.out.println("listone");
//			List<NewsVO> list = dao.listOne();
//			if (list.size() == 1) {
//				mav.addObject("list", list);
//			} else {
//				mav.addObject("msg", "해당 글이 없습니다.");
//			}
//		} 
//		else if (vo.getWriter() != null) {
//			List<NewsVO> list = dao.listWriter();
//			if (list.size() != 0) {
//				mav.addObject("list", list);
//			} else {
//				mav.addObject("msg", "추출된 미팅 정보가 없습니다.");
//			}
//		} 

		}
		mav.setViewName("newsView");
		return mav;
	}
}

//		if (action != null) {
//			if (id != null && action.equals("delete")) {
//				System.out.println(2);
//				boolean result = dao.delete(Integer.parseInt(id));
//				if (result) {
//					request.setAttribute("msg", "글 삭제 성공");
//				} else {
//					request.setAttribute("msg", "글 삭제 실패");
//				}
//				request.setAttribute("list", dao.listAll());
//			} else if (action.equals("search")) {
//				List<NewsVO> list = dao.search(searchType, key);
//				if (list.size() == 0) {
//					request.setAttribute("msg", id + "값과 일치하는 글이 없음");
//				} else {
//					request.setAttribute("list", list);
//				}
//				System.out.println(6);
//			} else if (action.equals("listWriter")) {
//				List<NewsVO> list = dao.listWriter(writer);
//				if (list.size() == 0) {
//					request.setAttribute("msg", id + "값과 일치하는 글이 없음");
//				} else {
//					request.setAttribute("list", list);
//				}
//			}
//			else if (id != null && action.equals("update")) {
//				NewsVO vo = dao.listOne(Integer.parseInt(id));
//				System.out.println(dao.update(vo));
//				vo = dao.listOne(Integer.parseInt(id));
//				request.setAttribute("select", true);
//				request.setAttribute("writer", vo.getWriter());
//				request.setAttribute("title", vo.getTitle());
//				request.setAttribute("content", vo.getContent());
//				request.setAttribute("list", dao.listAll());
//			}
//		} else {
//			request.setAttribute("list", dao.listAll());
//		}
//		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		System.out.println("a");
//		String action = request.getParameter("action");
//		String id = request.getParameter("id");
//		String writer = request.getParameter("writer");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		NewsDAO dao = new NewsDAO();
//		NewsVO vo = new NewsVO();
//		vo.setWriter(writer);
//		vo.setTitle(title);
//		vo.setContent(content);
//		System.out.println("b");
//		if (action.equals("insert")) {
//				System.out.println("c");
//				boolean result = dao.insert(vo);
//				if (result) {
//					request.setAttribute("msg", writer + "님의 글 게시등록 성공");
//				} else {
//					request.setAttribute("msg", writer + "님의 글 게시등록 실패");
//				}
//			} else {
//				System.out.println("e");
//				vo.setId(Integer.parseInt(action));
//				boolean result = dao.update(vo);
//				if (result) {
//					request.setAttribute("msg", writer + "님의 게시글 수정 성공");
//					System.out.println("f");
//				} else {
//					request.setAttribute("msg", writer + "님의 게시글 수정 실패");
//					System.out.println("g");
//				}
//		}
//		System.out.println("h");
//		request.setAttribute("list", dao.listAll());
//		System.out.println("i");
//		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
//	}
//
//}
