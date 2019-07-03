package my.spring.springedu;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.ProductVO;

@Controller
public class ProductController {
	@RequestMapping("/productView")
	public String productCount(String pid, HttpSession s) {
	
	if(s.getAttribute("product") == null) {
		s.setAttribute("product", new ProductVO());
	}
	
	
	ProductVO vo = (ProductVO) s.getAttribute("product");
	
	if (pid.equals("p001")) {
		vo.setApple(1);
	} else if (pid.equals("p002")) {
		vo.setBanana(1);
	} else if (pid.equals("p003")) {
		vo.setHala(1);
	}
	return "productView";
}
	
	@RequestMapping(value = "/productView/del", produces = "applicaiton/json; charset=utf-8")
	@ResponseBody
		public String del (HttpSession s) {
		s.removeAttribute("product");
		return "{ \"msg\" : \"장바구니가 비어졌어요.\"}";
	}
	
}
