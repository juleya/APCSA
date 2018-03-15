package unit12;

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;

	}
	
	public int length() {
		return word.length();
	}

	public int compareTo( Word rhs )
	{
		Word w = (Word)rhs;
		
		if (this.length() == w.length()) return 0;
		else if (this.length() > w.length()) return 1;
		else return -1;
		
	
	}

	public String toString()
	{
		return word;
	}
}
