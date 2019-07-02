# Spring FW 2nd

요청 : Controller
응답 : View

MVC 패턴을 Spring FW로 변환하기

```java
@RequestMapping("/calcCon")
	public ModelAndView model(int firstNum, int secondNum, String operator) { // 매개변수 선언
	ModelAndView mav = new ModelAndView();

@RequestMapping("/querystring5")
	public ModelAndView proc(QueryVO vo) { // 매개변수를 vo객체를 통하여 전달 (매개변수가 많을 경우 유용)
        String name = vo.getTestName();
		int age = vo.getTestAge();
		String addr = vo.getTestAddr();
		mav.addObject("spring", name + "-" + age + "-" + addr); // => spring 객체에 getter변수를 전달
		mav.setViewName("queryView3");
		return mav;
	}	
        
public String memberHandle(@ModelAttribute("kkk") StepVO vo) { // 매개변수를 kkk라는 변수에 vo객체를 저장하여 전달 원래는 stepVo 객체에 저장하지만 위 경우는 kkk에 저장
 
RequestMapping(value="/locale.do") // locale.do는 밑의 query만 출력
	public ModelAndView proc(Locale l) { // Locale 정보는 국가 정보 / 언어 출력
		ModelAndView mav = new ModelAndView();
		mav.addObject("spring", "Processing locale ............"+
		       l.getDisplayCountry()+"_"+l.getDisplayLanguage());
		mav.setViewName("queryView3");
		return mav;
	}
        
        
```

vo 는 멤버변수를 저장해준다
Getter 가 없을경우 Setter변수를 포기하지만 에러대신 null 혹은 0을 반환

Query vo로 전달을 받게다는 선언을 하며 jsp로 전달 하기전 queryVo라는 이름으로 request객체에 보관

HTML 405 에러 : get 혹은 post 지원 방식에 맞지않는 요청으로 인한 에러

```java
@Controller 
@SessionAttributes({"count1", "count2"})
public class CountController {
	@ModelAttribute("count1")
	public CountVO countMethod1() {	
		System.out.println("countMethod1 호출");
		return new CountVO();
	}
	@ModelAttribute("count2")
	public CountVO countMethod2() {
		System.out.println("countMethod2 호출");		
		return new CountVO();
	}	
	@RequestMapping(value="/count")
	public void handle(@ModelAttribute("count1")CountVO vo1, 
			      @ModelAttribute("count2")CountVO vo2, int num1, int num2, HttpSession s, HttpServletRequest req) {
		vo1.setCountNum(num1);
		vo2.setCountNum(num2);
		System.out.println("handle() : "+ 
			      vo1.getCountNum() + " : " + vo2.getCountNum());
		System.out.println("=============================");
	}
	@RequestMapping(value="/countdel")
	public void handle(SessionStatus s) {
		s.setComplete();
		System.out.println("Both count1 and count2 deleted!");	
		System.out.println("=============================");
	}
}
```

리턴값이 void일 경우 매핑명이 jsp 명이 됨으로  @RequestMapping(value="/count") 의 전달 jsp명은 count.jsp 로 된다