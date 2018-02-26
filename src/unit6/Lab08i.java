package unit6;

public class Lab08i
{
	public static void main ( String[] args )
	{
		Prime test1 = new Prime(24);
		test1.isPrime();
		System.out.println(test1.toString());
		
		Prime test2 = new Prime(7);
		test2.isPrime();
		System.out.println(test2.toString());
		
		Prime test3 = new Prime(100);
		test3.isPrime();
		System.out.println(test3.toString());
		
	}	
}