package unit8;

import java.util.Scanner;

public class Grades
{
	static int classSize;
	static double[] scores;

	public Grades() {
		classSize = 5;
		scores = new double[] {100, 90, 85, 72.5, 95.6};

	}



	public void setGrades() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How large is your class?");
		classSize = keyboard.nextInt();
		scores = new double[classSize];
		
		for (int i = 0; i < classSize; i++) {
			System.out.println("grade " + i + " :: ");
			scores[i] = keyboard.nextDouble();
		}
		
	}

	private double getSum()
	{
		double sum = 0;
		for (double i : scores) {
			sum += i;
		}
		return sum;
	}

	public double getAverage()
	{
		double average = getSum() / classSize;

		return average;
	}


	public String toString() {
		return ("average = " + String.format("%.2f", getAverage()));
	}



}