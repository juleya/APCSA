package unit14;

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private boolean[][] done;

	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
									
		done = new boolean[10][10];
	}

	public int countAts(int r, int c)
	{
		
		if (r < 10 && c < 10 && r > -1 && c > -1 && atMat[r][c] == '@' && done[r][c] == false) {
			
			done[r][c] = true;
			atCount++;
			
			countAts(r + 1, c);
			countAts(r, c + 1);
			countAts(r - 1, c);
			countAts(r, c - 1);
			
		} 
		
		return atCount;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}