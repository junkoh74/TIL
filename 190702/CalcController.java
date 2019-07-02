package my.spring.springedu;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;


@RequestMapping("/calcCon")
	public ModelAndView model(int firstNum, int secondNum, String operator) {
	ModelAndView mav = new ModelAndView();
		String calc = "/calcResult";
		String error = "/errorResult";
//		String msg = "나눗셈 연산시 두번째 숫자는 0 일 수 없습니다.";
		int numCalc = 0;
		
		if (operator.equals("mul")) {
			numCalc = firstNum * secondNum;
		}
		else if (operator.equals("div")){
			if (secondNum == 0) {
				mav.addObject("errorMsg", "나눗셈 연산시 두 번째 숫자는 0일 수 없습니다.");
				mav.setViewName(error);
				return mav;
			} else {
				numCalc = firstNum / secondNum;
			}
		}
		else if (operator.equals("sum")) {
			numCalc = firstNum + secondNum;
		}
		else if (operator.equals("sub")) {
			numCalc = firstNum - secondNum;
		}
		mav.addObject("result", numCalc);
		mav.setViewName(calc);
		return mav;
	}

}
