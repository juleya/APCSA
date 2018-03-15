package unit13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab15d.dat"));
		int number = file.nextInt();

		file.nextLine();
		
		ArrayList<FancyWords> list = new ArrayList<FancyWords>();
		
		while (file.hasNextLine()) {
			list.add(new FancyWords(file.nextLine()));
		}

		for (FancyWords s : list) {
			System.out.println(s.toString());
		}

		


	}
}