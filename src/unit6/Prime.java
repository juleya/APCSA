package unit6;

public class Prime
{
	private int number;

	public Prime()
	{
		number = 24;

	}

	public Prime(int num)
	{
		number = num;

	}

	public void setPrime(int num)
	{
		number = num;

	}

	public boolean isPrime()
	{
		boolean isPrime = false;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = true;
			}
		}

		return isPrime;
	}

	public String toString()
	{
		String output="";

		if (isPrime() == false) {
			output = number + " is prime.";
		}
		else if (isPrime() == true){
			output = number + " is not prime.";
		}

		return output;
	}
}