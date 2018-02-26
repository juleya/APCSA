package unit6;

public class Lab08g
{
	public static void main ( String[] args )
	{
		LoopStats test1 = new LoopStats();
		System.out.println(test1.toString());
		System.out.println("total " + test1.getTotal());
		System.out.println("even count " + test1.getEvenCount());
		System.out.println("odd count " + test1.getOddCount() + "\n");
		
		LoopStats test2 = new LoopStats(2, 8);
		System.out.println(test2.toString());
		System.out.println("total " + test2.getTotal());
		System.out.println("even count " + test2.getEvenCount());
		System.out.println("odd count " + test2.getOddCount() + "\n");
		
		LoopStats test3 = new LoopStats(5, 15);
		System.out.println(test3.toString());
		System.out.println("total " + test3.getTotal());
		System.out.println("even count " + test3.getEvenCount());
		System.out.println("odd count " + test3.getOddCount());
		
		
		
		
					
	}
}
