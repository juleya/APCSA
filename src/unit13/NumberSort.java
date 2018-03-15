package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	public static int getNumDigits(int number)
	{
		int count = 0;
		while (number > 0) {
			int digit = number % 10;
			count++;
			number -= digit;
			number/= 10;
		}

		System.out.println(count);
		
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits()];
		
		
		
		
		


		return sorted;
	}
}