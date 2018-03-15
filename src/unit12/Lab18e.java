package unit12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab18d.dat"));
		ArrayList<Word2> list = new ArrayList<Word2>();
		
		int size = file.nextInt();
		file.nextLine();
	
		while (file.hasNextLine()) {
			list.add(new Word2(file.nextLine()));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				
				if (list.get(i).compareTo(list.get(j)) == 0) {
					String one = list.get(i).toString();
					String two = list.get(j).toString();
					if (one.compareTo(two) > 0) {
						Word2 temp = list.get(j);
						list.set(j, list.get(i));
						list.set(i, temp);
					}
				}
			}
		}

		for (Word2 w : list) {
			System.out.println(w);
		}
		




	}
}