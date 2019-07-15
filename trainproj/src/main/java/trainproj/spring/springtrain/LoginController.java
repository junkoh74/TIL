package trainproj.spring.springtrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemberDAO;
import vo.MemberVO;

@Controller
public class LoginController {
	@Autowired
	MemberDAO dao;

// 추가 사항
// 로그인 get방식으로 받은것을 저장
// 출력하지 않음
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin() {
		System.out.println("시작");
	    ModelAndView mav = new ModelAndView("loginView");
	    System.out.println("뷰 셋업");
	    mav.addObject("loginView", new MemberVO());
	    System.out.println("로그인 페이지 로딩 끝");
	    mav.setViewName("loginView");
	    return mav;
	  }

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	protected ModelAndView loginControl(String action, @ModelAttribute("login") MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		System.out.println("login start");
		System.out.println("get POST");
		String viewName = null;
		if (vo.getUser_id() != null && vo.getPasswd() != null) {
			if (action != null && action.equals("login")) {
				System.out.println("액션 : " + action);
				System.out.println("조건 충족");
				System.out.println("vo 프린트 : " + vo.toString());
				boolean result = dao.login(vo);
				if (result) {
					mav.addObject("msg", vo.getUser_id() + "님 반갑습니다.");
					viewName = "welcome";
					System.out.println("맞다");
				} else {
					mav.addObject("msg", "틀렸어 푸쉬업 20개");
					viewName = "loginView";
					System.out.println("틀렸따");
				}
			}
		}
		System.out.println("완료 finish POST");
		mav.setViewName(viewName);
		return mav;
	}
}