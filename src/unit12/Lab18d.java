package unit12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;
import java.util.ArrayList;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("lab18d.dat"));
		ArrayList<Word> list = new ArrayList<Word>();
		
		int size = file.nextInt();
		file.nextLine();
	
		while (file.hasNextLine()) {
			list.add(new Word(file.nextLine()));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				
				if (list.get(i).compareTo(list.get(j)) == 0) {
					String one = list.get(i).toString();
					String two = list.get(j).toString();
					if (one.compareTo(two) > 0) {
						Word temp = list.get(j);
						list.set(j, list.get(i));
						list.set(i, temp);
					}
				}
			}
		}
		
		for (Word w : list) {
			
			System.out.println(w.toString());
			
		}

	}
}