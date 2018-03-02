package unit03;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		a = 5;
		b = -8;
		c = 3;

	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;

	}

	public void calcRoots( )
	{
		rootOne = (0 - b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c));
		rootOne = (rootOne)/(2 * a);
		rootTwo = (0 - b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c));
		rootTwo = (rootOne)/(2 * a);

	}

	public void print( )
	{
		System.out.println(rootOne);
		System.out.println(rootTwo);
		
	}
	
}