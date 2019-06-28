package exam3;

import org.springframework.stereotype.Component;

@Component("afternoon")
public class AfternoonGreetingImpl implements Greeting {
	@Override
	public void greet() {
		System.out.println("즐거운 오후되세요");
	}
}
