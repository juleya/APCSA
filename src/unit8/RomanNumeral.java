package unit8;

import java.util.Arrays;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
	
		setRoman(str);


	}

	public RomanNumeral(Integer orig)
	{

		setNumber(orig);

	}

	public void setNumber(Integer num)
	{

		number = num;



	}

	public void setRoman(String rom)
	{

		roman = rom;

	}

	public Integer getNumber()
	{
		
		int number = 0;
		for (int k = 0; k < roman.length() - 1; k++) {
			
			String one = roman.substring(k, (k + 1));
			String two = roman.substring((k + 1), (k + 2));
			
			for (int i = 0; i < NUMBERS.length; i++) {
				
				if (one.equals(LETTERS[i])) {
					
					for (int j = 0; j < NUMBERS.length; j++) {
						
						if (two.equals(LETTERS[j])) {
							
							if (NUMBERS[i] < NUMBERS[j])
								number = number - NUMBERS[i];
							else number += NUMBERS[i];
						}
					}	
				}
			}
		}
		
		for (int n = 0; n < NUMBERS.length; n++) {
			if (roman.substring(roman.length() - 1).equals(LETTERS[n])) {
				number += NUMBERS[n];
			}
		}

		return number;
	}
	
	public String toString()
	{
		
		String output = "";
		
		while (number > 0) {
			for (int i = 0; i < NUMBERS.length; i++) {
				if (NUMBERS[i] <= number) {
					output += LETTERS[i];
					number = number - NUMBERS[i];
					break;
				}
			}
		}
		
		return output;
	

	}
}

