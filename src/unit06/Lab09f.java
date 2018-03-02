package unit06;

public class Lab09f
{
	public static void main( String args[] )
	{
		LetterRemover test1 = new LetterRemover();
		test1.setRemover("I am Sam I am", 'a');
		test1.removeLetters();
		System.out.println(test1.toString());
		
		LetterRemover test2 = new LetterRemover();
		test2.setRemover("ssssssssxssssesssssesss", 's');
		test2.removeLetters();
		System.out.println(test2.toString());
		
		LetterRemover test3 = new LetterRemover();
		test3.setRemover("qwertyqwertyqwerty", 'a');
		test3.removeLetters();
		System.out.println(test3.toString());
		
		
											
	}
}