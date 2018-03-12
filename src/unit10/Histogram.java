package unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;
	private ArrayList<String> data;

	public Histogram()
	{
		
		fileName = "lab16e1.dat";
		letters.add('a');
		letters.add('b');
		letters.add('c');
		
	}

	public Histogram(char[] values, String fName) throws IOException
	{
		letters = new ArrayList();
		for (char c: values) {
			letters.add(c);
		}
		
		fileName = fName;
		
		
		out.println("search letters = " + letters);
		
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		data = new ArrayList();
		
		Scanner keyboard = new Scanner(new File("/Users/juliayang/eclipse-workspace/APCSA/" + fileName));
		
		while (keyboard.hasNextLine()) {
			data.add(keyboard.nextLine());
		}

	}

	public char mostFrequent()
	{
		count = new ArrayList();
		
		for (int ch = 0; ch < letters.size(); ch++) {
			int counter = 0;
			for (int i = 0; i < data.size(); i++) {
				String s = data.get(i);
				for (int j = 0; j < s.length(); j++) {
					if (letters.get(ch) == s.charAt(j)) {
						counter++;	
					}
				}
			}
			count.add(counter);
		}
		
		int max = Collections.max(count);
		int index = count.indexOf(max);
		
		
		return letters.get(index);
	}

	public char leastFrequent()
	{
		for (int ch = 0; ch < letters.size(); ch++) {
			int counter = 0;
			for (int i = 0; i < data.size(); i++) {
				String s = data.get(i);
				for (int j = 0; j < s.length(); j++) {
					if (letters.get(ch) == s.charAt(j)) {
						counter++;	
					}
				}
			}
			count.set(ch, counter);
		}
		
		int min = Collections.min(count);
		int index = count.indexOf(min);
		
		
		return letters.get(index);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}