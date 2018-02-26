package magpie;

import java.util.Scanner;

public class MagpieRunner3
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie3 maggie = new Magpie3();
		
		System.out.println (maggie.getGreeting());
		Scanner keyboard = new Scanner(System.in);
		String statement = keyboard.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = keyboard.nextLine();
		}

	}

}
