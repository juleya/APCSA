package unit14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab21i.dat"));
		int size = file.nextInt();
		file.nextLine();
		String line = file.nextLine();
		Maze test = new Maze(size, line);
		//Maze test = new Maze();
		System.out.println(test);
		
		size = file.nextInt();
		file.nextLine();
		line = file.nextLine();
		test = new Maze(size, line);
		System.out.println(test);
		
		size = file.nextInt();
		file.nextLine();
		line = file.nextLine();
		test = new Maze(size, line);
		System.out.println(test);
		
		size = file.nextInt();
		file.nextLine();
		line = file.nextLine();
		test = new Maze(size, line);
		System.out.println(test);
		
		size = file.nextInt();
		file.nextLine();
		line = file.nextLine();
		test = new Maze(size, line);
		System.out.println(test);
		
		size = file.nextInt();
		file.nextLine();
		line = file.nextLine();
		test = new Maze(size, line);
		System.out.println(test);
	}
}