package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/memser")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("number");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		MemberVO member = new MemberVO();
		if (name == null) {
			member.setName("없음");
		} else {
			member.setName(name);
		}
		if (phone == null) {
			member.setNumber("없음");
		} else {
			member.setNumber(phone);
		}
		if (account == null) {
			member.setAccount("없음");
		} else {
			member.setAccount(account);
		}
		if (password == null) {
			member.setPassword("없음");
		} else {
			member.setPassword(password);
		}
		request.setAttribute("data", member);
		request.getRequestDispatcher("/jspexam/memberView.jsp").forward(request, response);
	}

}
