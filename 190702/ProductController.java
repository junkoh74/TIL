package my.spring.springedu;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.ProductVO;

@Controller
public class ProductController {
@RequestMapping("/productView")
public String productCount(String pid, HttpSession s) {
	
	if(s.getAttribute("product") == null) {
		s.setAttribute("product", new ProductVO());
	}
	
	ProductVO vo = (ProductVO) s.getAttribute("product");
	
	if (pid == null) {
		s.removeAttribute("product");
		return "clearBasket";
	} else if (pid.equals("p001")) {
		vo.setApple(1);
	} else if (pid.equals("p002")) {
		vo.setBanana(1);
	} else if (pid.equals("p003")) {
		vo.setHala(1);
	}
	return "productView";

}
}
