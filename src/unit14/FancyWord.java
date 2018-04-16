package unit14;

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
	
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mat[i][j] = ' ';
			}
		}

	}

   public FancyWord(String s)
	{
	   int size = s.length();
	   mat = new char[size][size];
	   mat[0] = s.toCharArray();
	   mat[size - 1] = s.toCharArray();
	   
	   for (int i = 1; i < size - 1; i++) {
		   char[] line = new char[size];
		   
		   for (int j = 0; j < size; j++) {
			   line[j] = ' ';
		   }
		   
		   line[i] = mat[0][i];
		   line[size - 1 - i] = mat[0][size - 1 - i];
		   mat[i] = line;
		}
	
	   

	}

	public String toString()
	{
		String output="";
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				output += mat[i][j];
			}
			output += "\n";
		}
		

		return output+"\n\n";
	}
}