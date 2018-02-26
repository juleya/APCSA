package unit5;

import java.util.Scanner;

public class Lab05d
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a letter :: ");
		char letter = keyboard.next().charAt(0);
		CharacterAnalyzer test = new CharacterAnalyzer(letter);
		System.out.println(test);   
		
		System.out.println("Other test cases: ");
		
		CharacterAnalyzer test1 = new CharacterAnalyzer('A');
		System.out.println(test1);
		
		CharacterAnalyzer test2 = new CharacterAnalyzer('1');
		System.out.println(test2);
		
		CharacterAnalyzer test3 = new CharacterAnalyzer('d');
		System.out.println(test3);
		
		
		
		
		
		
		
		

	}
}