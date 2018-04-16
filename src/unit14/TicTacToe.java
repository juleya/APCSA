package unit14;

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[3][3];

	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
	
		mat[0] = game.substring(0, 3).toCharArray();
		mat[1] = game.substring(3, 6).toCharArray();
		mat[2] = game.substring(6, 9).toCharArray();
	
	}

	public String getWinner()
	{

		for (int i = 0; i < 3; i++) {
		
			if (mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2]) {
				return mat[i][0] + " wins horizontally!";
			}


			else if (mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i]) {
				return mat[0][i] + " wins vertically!";
			}
			
		
		}
		
		if ((mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]) || (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])) {
			return mat[0][2] + " wins diagonally!";
		} 
		
		return "cat's game - no winner!";


	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				output += mat[i][j] + " ";
			}
			output += "\n";
		}
		
		output += getWinner();


		return output+"\n\n";
	}
}
