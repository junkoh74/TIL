package my.spring.springedu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import vo.MemberVO;

@Controller
public class MemberController {
@RequestMapping(value = "/memCon", method = RequestMethod.POST)

	public String memberHandle(@ModelAttribute("mh") MemberVO vo) {
		
		System.out.println(vo.getName());
		
		if (vo.getName().equals("")) {
			vo.setName("없음");
		}
		if (vo.getNumber().equals("")) {
			vo.setNumber("없음");
		} 
		if (vo.getAccount().equals("")) {
			vo.setAccount("없음");
		} 
		if (vo.getPassword().equals("")) {
			vo.setPassword("없음");
		} 
		return "memberView";
	}
}
