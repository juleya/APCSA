package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		String s = sentence.trim();
		int size = s.split("\\s+").length;
		wordRay = new String[size];
		String[] temp = s.split("\\s+");
		
		for (int i = 0; i < size; i++) {
			wordRay[i] = temp[i];
		}
	}

	public String toString()
	{
		int size = wordRay.length;
		String output="";
		int max = Integer.MIN_VALUE;
		int count = 1;
		int tempCount = 0;
		for (String s: wordRay) {
			if (s.length() > max) {
				max = s.length();
			}
		}
		
		for (int j = 0; j < max; j++) {
			for (int i = size - 1; i >= 0; i--) {
				String word = wordRay[i];
				int wordSize = word.length();
				
				if (wordSize - count >= 0) {
					output += word.charAt(wordSize - count);	
				} else output += " ";
				
				tempCount++;
				
				if (tempCount == size) {
					tempCount = 0;
					count++;
					output += "\n";
				}
				
			}

		}
		

		return output+"\n";
	}
}