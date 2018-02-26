package unit4;

public class Name
{
	private String name;

	public Name()
	{
		name = "John Doe";

	}

	public Name(String s)
	{
		name = s;

	}

   public void setName(String s)
   {
	   name = s;

   }

	public String getFirst()
	{
		String[] splited = name.split("\\s+");
		return splited[0];
	}

	public String getLast()
	{
		String[] splited = name.split("\\s+");
		return splited[1];
	}

 	public String toString()
 	{
 		return name;
	}
}