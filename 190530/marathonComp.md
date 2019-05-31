# ArrayList / Collections.sort

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

```java
package skilltest;

import java.util.ArrayList;
import java.util.Collections;

public class NumberK {
	public static void main(String[] args) {

//			int[] answer = {};
////			ArrayList<Integer> arrList = new ArrayList<Integer>();
//			int arrList [] = new int [array.length];
//			for (int i = 0; i < array.length; i++) {
//				arrList[i] = array[i];
//			}
//
//			int[][] comm = new int[3][3];
//			for (int i = 0; i < comm.length; i++) {
//				for (int j = 0; j < commands[i].length; j++) {
//					comm[i][j] = commands[i][j];
//				}
//			}
//			
//					i = commands[c][0] + 1;
//					j = commands[c][1] + 1;
//					k = commands[c][2] + 1;
//					System.out.print(temp);
		int[] answer = new int [comList.length];
        int[] arrayList = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] comList = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		ArrayList<Integer> temp = null;

		for (int i = 0; i < comList.length; i++) {
			temp = new ArrayList<Integer>();
			for (int j = comList[i][0]; j <= comList[i][1]; j++) {
				temp.add(arrayList[j - 1]);
			}

			Collections.sort(temp);
			System.out.println(temp);
			answer[i] = temp.get(comList[i][2] - 1);
		}
		for (int data : answer) {
			System.out.println(data);
		}

	}

}

```

1. 프로그래머스 내 가이드에서 주어진 모든것을 바꾸는것이 가능하다
2. ArrayList 메소드 선언법 : ArrayList<E> 변수명 = new ArrayList <E>(); 
3. Sorting은 Collection.sort(배열 변수명); 을 사용한다면 LinkedList, ArrayList, Array 등 거의 모든 배열 정렬이 가능함
4. 생각을 코드로 표현하는 것이 익숙치가 않음
5. 지속적인 문제 풀이로 인하여 코드와 친숙해지는 시간이 필요 (최대한 많이 풀어 소요 기간을 단축)