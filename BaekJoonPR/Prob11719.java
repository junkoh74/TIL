package sbs1;

import java.util.ArrayList;
import java.util.Scanner;

public class Prob11719 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		while (true) {
			String input = scan.nextLine();
			if (input == "break") {
				break;
			} else {
				list.add(input);
			}
			}
		
		scan.close();
		if (list.size() < 100) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
