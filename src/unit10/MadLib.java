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
		loadVerbs();
		loadNouns();
		loadAdjectives();
	
		
		try{
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				if (file.next().equals("#")) {
					getRandomNoun();
				}
				if (file.next().equals("@")) {
					getRandomVerb();
				}
				if (file.next().equals("&")) {
					getRandomAdjective();
				}
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("nouns.dat"));
			while (keyboard.hasNextLine()) {
				nouns.add(keyboard.nextLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	public void loadVerbs()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("verbs.dat"));
			while (keyboard.hasNextLine()) {
				verbs.add(keyboard.nextLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner keyboard = new Scanner(new File("adjectives.dat"));
			while (keyboard.hasNextLine()) {
				adjectives.add(keyboard.nextLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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