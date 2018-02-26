package unit7;

import java.util.Scanner;

public class Lab10e
{
	public static void Game() {
		System.out.println("Guessing Game - how many numbers? ");
		Scanner keyboard = new Scanner(System.in);
		
		int input = keyboard.nextInt();
		GuessingGame test1 = new GuessingGame(input);
		test1.playGame();
		System.out.println(test1.toString());
		
		System.out.println("\nDo you want to play again? Press '1' for yes.");
		input = keyboard.nextInt();
		
		if (input == 1) {
			Game();
		} else keyboard.close();
	}
	public static void main(String args[])
	{
		Game();

	}
}