package unit14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("Lab24d.dat"));
		int size = file.nextInt();
		file.nextLine();
		
		for (int i = 0; i < size; i++) {
			String line = file.nextLine();
			TicTacToe test = new TicTacToe(line);
			System.out.println(test);
		}







	}
}

