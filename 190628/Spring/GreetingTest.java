package exam3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam3/bean.xml");


		LocalDateTime bean = (LocalDateTime) factory.getBean("hello");
		int hour = bean.getHour();
//		System.out.println(hour);
		Greeting greet;
		
		if (hour >= 6 && hour <= 12) {
			greet = (Greeting) factory.getBean("morning");
		} else if (hour > 12 && hour <= 17) {
			greet = (Greeting) factory.getBean("afternoon");
		} else if (hour > 17 && hour <= 22) {
			greet = (Greeting) factory.getBean("evening");
		} else	{
			greet = (Greeting) factory.getBean("night");
		}
		greet.greet();
		((ClassPathXmlApplicationContext) factory).close();
	}
}
