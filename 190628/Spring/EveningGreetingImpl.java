package exam3;

import org.springframework.stereotype.Component;

@Component("evening")
public class EveningGreetingImpl implements Greeting {
	@Override
	public void greet() {
		System.out.println("����� ����Ǽ���");
	}
}
