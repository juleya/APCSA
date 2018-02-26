package unit6;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		setRemover("The world is abundant", 'd');
	}

	public LetterRemover(String s, char rem) {
		setRemover(s, rem);
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		
		while (sentence.indexOf(lookFor) >= 0) {
			sentence = sentence.replace(Character.toString(lookFor), "");
		}

		return sentence;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor;
	}
}