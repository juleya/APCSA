package unit10;

public class Lab16d
{
	public static void main( String args[] )
	{
		//System.out.println(System.getProperty("user.dir"));
		String madLibFile = "/story.dat";
		MadLib test = new MadLib(madLibFile);
		System.out.println(test);
		System.out.println("\n");
	}
}
