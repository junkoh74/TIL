# Spring FW 3rd

```java
@Controller
public class PathController {
	@RequestMapping
	     (value="/character/detail/{name}/{number}") // {} 안에 변수를 주면 detail/뒤에 오는 어떠한 것이든 name으로 저장이 되며 {name}/뒤에는 number라는 이름으로 값이 저장된다 == ?name=example이 없어도 된다
    // character/deatil은 정적임으로 주소를 적을때 무조건적으로 필요하며 {}안에 있는 주소는 동적
    	 public String getAllBoards(@PathVariable("number") int num, 
	                             @PathVariable String name, Model model){
		 System.out.println(model.getClass().getName());
	     if(name.equals("kakao")) {
	    	 if (num == 1) 
	    		 model.addAttribute("imgname", "ryan");
	    	 else if (num == 2) 
	    		 model.addAttribute("imgname", "muzicon");
	    	 else if (num == 3) 
	    		 model.addAttribute("imgname", "apeach");
	    	 else if (num == 4) 
	    		 model.addAttribute("imgname", "jayg");
	    	 else if (num == 5) 
	    		 model.addAttribute("imgname", "frodoneo");
	    	 else if (num == 6) 
	    		 model.addAttribute("imgname", "tube");
	     } // 모델에 넣어서 
           return "detailView"; // "detailView 에 전달"
	 }
```

컨트롤러에 커맨드 객체를 생성 할 수 있으며 이는 vo와 같은 역할을 한다 (정보를 저장하여 view에 저장)
Map => HashMap
Model
ModelMap

```
학습계획
- 로또 컨트롤러
  - service 객체 :
  - DAO 객체 : Data를 acess할 수 있게 해주면 DAO, 꼭 DB와 연결되어야 하지는 않다
  - VO 객체 : 
  - view : html 과 jsp로 나누어짐 (응답 뿐만 아니라 요청 페이지도 포함)
```



Annotation 의 종류
@Component => Spring IOC에서는 통합하지만 mvc에서는 아래 3개의 annotation으로 분류가 가능해진다
		@Controller : SpringFW에서 컨트롤러로써의 객체를 생성
		@Service : SpringFW에서 서비스 로직을 지원하는 객체를 생성
		@Repository : SpringFW에서 저장과 관련된 annotation