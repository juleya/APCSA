package unit07;

public class Triples
{
	private int number;

	public Triples()
	{
		number = 110;
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int min;
		if (a < b) {
			min = a;
		} else min = b;
		
		if (min > c) {
			min = c;
		}
			
		for (int i = min; i >= 2; i-- ) {
			if (a % i == 0 && b % i == 0 && c % i == 0) {
				return i;
			}
		}
		return 1;
		
	}

	public void String()
	{
		
		for (int i = 1; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				for (int k = j + 1; k < number; k++) {
					if (greatestCommonFactor(i, j, k) == 1 && (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2))) {
						System.out.printf(" %d, %d, %d\n", i, j, k);
					}
				}
			}
		}
		
	}
}