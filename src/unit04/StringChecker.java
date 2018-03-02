package unit04;

public class StringChecker
{
	private String word;

	public StringChecker()
	{
		word = "chicken";

	}

	public StringChecker(String s)
	{
		word = s;

	}

   public void setString(String s)
   {
   		word = s;
   }

	public boolean findLetter(char c)
	{
		
		if (word.contains(String.valueOf(c))) {
			return true;
		} return false;
		
	}
	
	public boolean findSubString(String s)
	{
		if (word.contains(s)) {
			return true;
		} return false;
		
	}

 	public String toString()
 	{
 		return "\n\n";
	}
}