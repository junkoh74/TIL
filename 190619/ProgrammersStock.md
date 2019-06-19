Programmers Stack/Que Stock

```java
package binary_serach_tree;

class Solution2 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int count = 0;
		for (int  i = 0; i < prices.length; i++) {
			for (int j = i; j < answer.length; j++)
			if (prices[i] < prices[j]) {
				count++;
				answer [i] = count;
			} else if (j+1 < answer.length && prices[i] > prices[j+1])
				answer[i] = 1; 
			count = 0;
		}
		return answer;
	}
}

public class Stock {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		Solution2 answer = new Solution2();
		int [] arr = answer.solution(prices);
		for (int data : arr) {
			System.out.println(data);
		}
		
	}
}

```

