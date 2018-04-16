package unit14;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private ArrayList<Integer> list;
   private boolean[][] done;

	public Maze()
	{
		list = new ArrayList<Integer>();
		maze = new int[][] {{1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}, {0, 0, 1, 0, 1}, {0, 1, 1, 1, 0},{0, 0, 0, 0, 1}};

	}

	public Maze(int size, String line)
	{
		list = new ArrayList<Integer>();
		Scanner s = new Scanner(line);
		maze = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				maze[i][k] = s.nextInt();
			}

		}
		
		done = new boolean[size][size];

	}

	public boolean hasExitPath(int r, int c)
	{
		if (r < maze.length && c < maze.length && r >-1 && c > -1 && maze[r][c] == 1 && done[r][c] == false) {
			
			done[r][c] = true;
			list.add(c);
			
			hasExitPath(r + 1, c);
			hasExitPath(r, c + 1);
			hasExitPath(r - 1, c);
			hasExitPath(r, c - 1);
			
			
		}
		
		if (list.contains(maze.length - 1)) {
			return true;
		}
		
		return false;
	}

	public String toString()
	{
		String output="exit not found";
		
		if (hasExitPath(0, 0)) {
			output = "exit found";
		}

		return output;
	}
}