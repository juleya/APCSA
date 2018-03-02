package unit02;

import java.util.Scanner;

public class RunwayLength {
	
	static double speed, acceleration, length;
	
	public static void Compute() {
		length = (Math.pow(speed, 2)) / (2 * acceleration);
		System.out.println("Your minimum runway length is: ");
		
		System.out.println(String.format("%.3f", length));
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your speed: ");
		speed = keyboard.nextDouble();
		
		System.out.println("Enter your acceleration: ");
		acceleration = keyboard.nextDouble();
		
		Compute();
		
		keyboard.close();
	}

}
