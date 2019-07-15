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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegisterForm() {
		System.out.println("시작");
	    ModelAndView mav = new ModelAndView("registerView");
	    System.out.println("뷰 셋업");
	    mav.addObject("registerView", new MemberVO());
	    System.out.println("로그인 페이지 로딩 끝");
	    mav.setViewName("registerView");
	    return mav;
	  }

	@RequestMapping(value = "/registerInsert", method = RequestMethod.POST)
	protected ModelAndView regControl(MemberVO vo, String action) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		System.out.println("start");
		System.out.println("get POST");
		if (vo.getUser_id() != null && vo.getEmail() != null && vo.getPasswd() != null) {
			boolean result = dao.register(vo);
			if (action != null && action.equals("register")) {
				System.out.println("조건 충족");
				if (result) {
					mav.addObject("msg", vo.getUser_id() + "님 가입을 환영합니다.");
					viewName = "welcome";
				} else {
					mav.addObject("msg", "다시 써 임마");
					viewName = "registerView";
				}
			}
		}
		System.out.println("완료 finish POST");
		mav.setViewName(viewName);
		return mav;
	}
}
