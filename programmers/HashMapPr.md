# 해쉬맵 연습 

### 프로그래머스 완주 문제

```java
package skilltest;

import java.util.HashMap;
import java.util.Set;

public class Marathon {
	public static void main(String[] args) {
		
			String [] part = new String[] {"leo", "kiki", "eden"};
			String [] comp = new String [] {"eden", "kiki"};
			
			String [] part1 = new String [] {"marina", "josipa", "nikola", "vinko", "filipa"};
			String [] comp1 = new String [] {"josipa", "filipa", "marina", "nikola"};
			
			String [] part2 = new String [] {"mislav", "stanko", "mislav", "ana"};
			String [] comp2 = new String [] {"stanko", "ana", "mislav"};
			
			
			System.out.println(getSolution(part, comp));
			System.out.println(getSolution(part1, comp1));
			System.out.println(getSolution(part2, comp2));
			
	}
	public static String getSolution (String [] participant, String [] completion) {
		HashMap<Integer, String> part = new HashMap<Integer, String>();
		
		for (int i = 0; i < participant.length; i++) {
			part.put(i, participant[i]);
		}
		
		 Set <Integer> keyset = part.keySet();
		
		 
		for (int key : keyset) {
			for (int i = 0; i < completion.length; i++)
			if (part.get(key) == completion[i]) {
				part.remove(key);
			} 
		}
		String answer = "";
		for (int key : keyset) {
			answer = part.get(key);
		}
		
		return answer;
	}
}

```

- First time actually used the HashMap.
- At first thought it was one of listing method, but it turns out HashMap does not have orders
  - It is the reason why setting (Set <E> keyset = variable.keySet();) is required.