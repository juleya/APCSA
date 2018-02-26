package unit7;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		size = 3;
		letter = "A";
	}

	public TriangleThree(int count, String let)
	{
		setTriangle(count, let);
	}

	public void setTriangle(int count, String let)
	{
		size = count;
		letter = let;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output = "";
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size - i; j++) {
				output = output + " ";
			}
			for (int k = 1; k <= i; k++) {
				output = output + letter;
			}
			
			output = output + "\n";
		}
		return output;
	}
	
	
}