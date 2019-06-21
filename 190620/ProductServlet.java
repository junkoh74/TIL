package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.ProductVO;

@WebServlet("/productSer")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String transfer = "/jspexam/productView.jsp";
		String empty = "/jspexam/clearBasket.jsp";
		String pid = request.getParameter("pid");
		/*
		 * int apple = Integer.parseInt(request.getParameter("apple")); int banana =
		 * Integer.parseInt(request.getParameter("banana")); int hala =
		 * Integer.parseInt(request.getParameter("hala"));
		 */

		HttpSession session = request.getSession();
		if (session.getAttribute("pid") == null) {
			session.setAttribute("pid", new ProductVO());
		}

		ProductVO product = (ProductVO) session.getAttribute("pid");
		
		if (pid == null) {
			session.invalidate();
			System.out.println(3);
			request.getRequestDispatcher(empty).forward(request, response);
			return;
		}
		
		if (pid.equals("p001")) {
			product.setApple(1);
		} else if (pid.equals("p002")) {
			product.setBanana(1);
		} else if (pid.equals("p003")) {
			product.setHala(1);
		} 
		
		request.getRequestDispatcher(transfer).forward(request, response);
	}

}
