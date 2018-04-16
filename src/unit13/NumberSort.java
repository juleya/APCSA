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

		
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		
		for (int i = 0; i < sorted.length; i++) {
			if (number > 0) {
				int digit = number % 10;
				sorted[i] = digit;
				number -= digit;
				number/= 10;
			}
			
		}
		
		for (int i = 0; i < sorted.length; i++) {
			for (int j = 0; j < sorted.length && j != i; j++) {
				if (sorted[i] < sorted[j]) {
					int temp = sorted[i];
					sorted[i] = sorted[j];
					sorted[j] = temp;
				}
			}
		}
		
		return sorted;
	}
}