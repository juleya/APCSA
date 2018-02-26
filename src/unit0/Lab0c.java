package unit0;

import java.util.Scanner;

public class Lab0c {
	public static void main(String[] args) {
		int intOne, intTwo;
		double doubleOne;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		intOne = keyboard.nextInt();
		
		System.out.print("Enter an integer: ");
		intTwo = keyboard.nextInt();
		
		System.out.print("Enter a double: ");
		doubleOne = keyboard.nextDouble();
		
		System.out.println("integer one = " + intOne);
		System.out.println("integer two = " + intTwo);
		System.out.println("double = " + doubleOne);
		
		keyboard.close();
		
		
		
	}
}
