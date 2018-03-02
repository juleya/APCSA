package unit07;

import java.util.Scanner;
import java.lang.Math;

public class GuessingGame
{
	private int upperBound;
	public int tempCounter;

	public GuessingGame(int stop)
	{
		upperBound = stop;

	}

	public void playGame()
	{
		int number = (int) (Math.random() * (upperBound - 1) + 1);
		Scanner keyboard = new Scanner(System.in);
		
		int guess;
		int counter = 0;
		
		do {
			System.out.println("Enter a number between 1 and " + upperBound);
			guess = keyboard.nextInt();
			counter ++;
		} while (guess != number); 
		
		tempCounter = counter;
		System.out.println("It took " + counter + " guesses to guess " + number + ".");
		
	}

	public String toString()
	{
		String output = "You guessed wrong " + (100 * (tempCounter - 1) / upperBound) + " percent of the time.";
		return output;
		
		
	}
}