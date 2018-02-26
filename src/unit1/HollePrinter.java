package unit1;

import java.util.Scanner;


public class HollePrinter {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		//String input = keyboard.next();
		String input = "Hello World!";
		
		String str = input.replace('e', 'a');
		String newstr = str.replace('o', 'e');
		String newstr2 = newstr.replace('a', 'o');
		System.out.println(newstr2);
	}

}
