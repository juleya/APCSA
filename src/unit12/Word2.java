package unit12;

import static java.lang.System.*;

public class Word2 implements Comparable<Word2>
{
	private String word;

	public Word2( String s)
	{
		word = s;

	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		char[] array = word.toCharArray();

		char[] vls = vowels.toCharArray();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < vls.length ; j++) {
				if (array[i] == vls[j]) {
					vowelCount++;
				}
			}

		}
		
		return vowelCount;
	}

	public int compareTo(Word2 rhs)
	{

		Word2 w = (Word2)rhs;
		
		if (this.numVowels() == w.numVowels()) return 0;
		else if (this.numVowels() > w.numVowels()) return 1;
		else return -1;
		
	}

	public String toString()
	{
		return word;
	}
}