package unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private Random ran;
	
	public MadLib()
	{
	
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		
		loadVerbs();
		loadNouns();
		loadAdjectives();

	}

	public MadLib(String fileName)
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		
		loadVerbs();
		loadNouns();
		loadAdjectives();
	
		
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + fileName));
			boolean set = true;
			
			while (set) {
				
				if (file.hasNext() == false) {
					set = false;
					break;
				}
				String temp = file.next();
				if (temp.equals("#")) {
					System.out.print(getRandomNoun() + " ");
				}
				else if (temp.equals("@")) {
					System.out.print(getRandomVerb() + " ");
				}
				else if (temp.equals("&")) {
					System.out.print(getRandomAdjective() + " ");
				}
				else {
					System.out.print(temp + " ");
				}
			}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void loadNouns()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("/Users/juliayang/eclipse-workspace/APCSA/nouns.dat"));
			while (keyboard.hasNext()) {
				nouns.add(keyboard.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns failed to load");
		}	
		
	}
	
	public void loadVerbs()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("/Users/juliayang/eclipse-workspace/APCSA/verbs.dat"));
			while (keyboard.hasNext()) {
				verbs.add(keyboard.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("verbs failed to load");
		}	
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("/Users/juliayang/eclipse-workspace/APCSA/adjectives.dat"));			
			while (keyboard.hasNext()) {
				adjectives.add(keyboard.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("adj failed to load");
		}	
	}

	public String getRandomVerb()
	{
		ran = new Random();
		int index = ran.nextInt(verbs.size());
		return (String) verbs.get(index);
	}
	
	public String getRandomNoun()
	{
		ran = new Random();
		int index = ran.nextInt(nouns.size());
		return (String) nouns.get(index);
	}
	
	public String getRandomAdjective()
	{
		ran = new Random();
		int index = ran.nextInt(adjectives.size());
		return (String) adjectives.get(index);
	}		

	public String toString()
	{
	   return "\n\n\n";
	}
}