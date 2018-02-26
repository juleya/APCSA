package unit5;

import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{
		theChar = 'a';

	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;

	}

	public void setChar(char c)
	{
		theChar = c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if (getASCII() >= 65 && getASCII() <=90 )
			return true;
		return false;
	}

	public boolean isLower( )
	{
		if (getASCII() >= 97 && getASCII() <=122 )
			return true;
		return false;
	}
	
	public boolean isNumber( )
	{
		if (getASCII() >= 48 && getASCII() <=57 )
			return true;
		return false;
	}	

	public int getASCII( )
	{
		int ascii = (int) theChar;
		return ascii;
	}

	public String toString()
	{
		if (isUpper()) {
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		}
		
		if (isLower()) {
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";	  
	
		}
		
		if (isNumber()) {
			return ""+getChar() + " is a digit. ASCII == " + getASCII() + "\n";	  
	
		}
		
		return "";
		
	}
}