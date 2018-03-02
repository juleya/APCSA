package unit02;

import java.util.Scanner;

public class Lab02E {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is the radius of your circle?");
		double radius = keyboard.nextDouble();
		
		Circle solve = new Circle();
		
		solve.setRadius(radius);
		
		solve.calculateArea();
		
		solve.print();
		
		keyboard.close();
	}
}
