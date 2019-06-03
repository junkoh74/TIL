package sbs1;

import java.util.ArrayList;
import java.util.Scanner;

public class Prob10172 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
         
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (input == null || input.isEmpty()) {
            	break;            
            } else {
            list.add(input);
            }
        }
        scan.close();
        if (list.size() < 100 ) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
        }
    }
}