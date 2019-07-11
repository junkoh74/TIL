package trainproj.spring.springtrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
public class RegisterController {
	@Autowired
	MemberDAO dao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView regControl(MemberVO vo, String action) {
		ModelAndView mav = new ModelAndView();
		System.out.println("start");
		System.out.println("get POST");
		if (vo.getUser_id() != null && vo.getEmail() != null && vo.getPasswd() != null) {
			boolean result = dao.register(vo);
			if (action != null && action.equals("register")) {
				System.out.println("조건 충족");
				if (result) {
					mav.addObject("msg", vo.getUser_id() + "님 가입을 환영합니다.");
				} else {
					mav.addObject("msg", "다시 써 임마");
				}
			}
		}
		System.out.println("완료 finish POST");
		mav.setViewName("registerView");
		return mav;
	}
}
