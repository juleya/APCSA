package finalProject;

import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;

public class Blocks {
	
	private Block[][] blocks;
	private static int prevScore;
	private static int score;
	
	public Blocks() {
		
		blocks = new Block[4][4];
		
		score = 0;
		prevScore = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				blocks[i][j] = new Block(0, i * 120 + 20, j * 120 + 20);
			}
		}
		
		newGame();
	}
	
	public void newGame() {
		
		Random ran = new Random();
		
		int x1 = ran.nextInt(4);
		int y1 = ran.nextInt(4);
		int x2 = ran.nextInt(4);
		int y2 = ran.nextInt(4);
		
		int num = assignRandom();
		if (num == 4) {
			blocks[x1][y1].setValue(num);
			blocks[x2][y2].setValue(2);
		} else {
			blocks[x1][y1].setValue(2);
			blocks[x2][y2].setValue(assignRandom());
		}

	}
	
	public int length() {
		return blocks.length;
	}
	
	
	public Block blockAt(int row, int column) {
		return blocks[row][column];
	}
	
	public static int assignRandom() {
		Random ran = new Random();
		if (ran.nextInt(2) == 1) {
			return 2;
		} else {
			return 4;
		}
	}
	
	public boolean movePossible() {
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (blocks[i][j].getValue() > 0) {
					counter++;
				}
			}
		}
		if (counter != 16) {
			return true;
		} 
		//combining left
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (blocks[i + 1][j].getValue() == blocks[i][j].getValue()) {
					return true;
				}	
			}
		}
		
		//combining right
		for (int j = 0; j < 4; j++) {
			for (int i = 3; i > 0; i--) {
				if (blocks[i - 1][j].getValue() == blocks[i][j].getValue()) {
					return true;
				}	
			}
		}
		
		//combining up
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				if (blocks[j][i + 1].getValue() == blocks[j][i].getValue()) {
					return true;
				}	
			}
		}
		
		//combining down
		for (int j = 0; j < 4; j++) {
			for (int i = 3; i > 0; i--) {
				if (blocks[j][i - 1].getValue() == blocks[j][i].getValue()) {
					return true;
				}
			}
		}	
			
		return false;
	}
	
	public int getScore() {
		return score;
	}
	
	public static void writeOverScore(Graphics window) {
		window.setColor(Color.black);
		window.drawString("Score: " + prevScore, 700, 100);
		prevScore = score;
	}

	
	public static void drawScore(Graphics window) {
		window.setColor(Color.white);
		window.drawString("Score: " + score, 700, 100);
	}

	public void genRandom() {

		Random r = new Random();
		int x, y = 0;
		
		do {
			x = r.nextInt(4);
			if (x == 0 || x == 3) {
				y = r.nextInt(4);
			}
			else if (x == 1 || x == 2) { 
				y = r.nextInt(2);
				if (y == 1) {
					y = 3;
				} 
			}
			
		} while (blocks[x][y].getValue() != 0);
		
		blocks[x][y].setValue(assignRandom());
	
	}
	
	public void draw(Graphics window) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				blocks[i][j].draw(window);
			}
		}
		
		writeOverScore(window);
		drawScore(window);
		
	}
	
	public void move(String direction) {
		if (direction == "LEFT") {
			
			boolean change = false;
			
			//shift
			for (int j = 0; j < 4; j++) {
				for (int index = 1; index < 4; index++) {
					for (int i = 0; i < index; i++) {
						if (blocks[i][j].getValue() == 0 && blocks[index][j].getValue() > 0) {
							blocks[i][j].setValue(blocks[index][j].getValue());
							blocks[index][j].setValue(0);
							change = true;
						}

					}
				}

			}
			
			//combining
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++) {
					if (blocks[i + 1][j].getValue() == blocks[i][j].getValue()) {
						blocks[i][j].setValue(blocks[i][j].getValue() * 2);
						blocks[i + 1][j].setValue(0);
						score += blocks[i][j].getValue();
						change = true;
					}	
				}
			}
			
			//reshift
			for (int j = 0; j < 4; j++) {
				for (int index = 1; index < 4; index++) {
					for (int i = 0; i < index; i++) {
						if (blocks[i][j].getValue() == 0 && blocks[index][j].getValue() > 0) {
							blocks[i][j].setValue(blocks[index][j].getValue());
							blocks[index][j].setValue(0);
							change = true;
						}

					}
				}

			}

			if (change == true) {
				genRandom();
			}

			
			
		}
		if (direction == "RIGHT") {
			
			boolean change = false;
			
			//shift
			for (int j = 0; j < 4; j++) {
				for (int index = 2; index >= 0; index--) {
					for (int i = 3; i > index; i--) {
						if (blocks[i][j].getValue() == 0 && blocks[index][j].getValue() > 0) {
							blocks[i][j].setValue(blocks[index][j].getValue());
							blocks[index][j].setValue(0);
							change = true;
						}

					}
				}

			}
			
			//combining
			for (int j = 0; j < 4; j++) {
				for (int i = 3; i > 0; i--) {
					if (blocks[i - 1][j].getValue() == blocks[i][j].getValue()) {
						blocks[i][j].setValue(blocks[i][j].getValue() * 2);
						blocks[i - 1][j].setValue(0);
						score += blocks[i][j].getValue();
						change = true;
					}	
				}
			}
			
			//reshift
			for (int j = 0; j < 4; j++) {
				for (int index = 2; index >= 0; index--) {
					for (int i = 3; i > index; i--) {
						if (blocks[i][j].getValue() == 0 && blocks[index][j].getValue() > 0) {
							blocks[i][j].setValue(blocks[index][j].getValue());
							blocks[index][j].setValue(0);
							change = true;
						}

					}
				}

			}

			if (change == true) {
				genRandom();
			}

			
		}
		if (direction == "UP") {
			
			boolean change = false;
			
			//shift
			for (int j = 0; j < 4; j++) {
				for (int index = 1; index < 4; index++) {
					for (int i = 0; i < index; i++) {
						if (blocks[j][i].getValue() == 0 && blocks[j][index].getValue() > 0) {
							blocks[j][i].setValue(blocks[j][index].getValue());
							blocks[j][index].setValue(0);
							change = true;
						}

					}
				}

			}
			
			//combining
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++) {
					if (blocks[j][i + 1].getValue() == blocks[j][i].getValue()) {
						blocks[j][i].setValue(blocks[j][i].getValue() * 2);
						blocks[j][i + 1].setValue(0);
						score += blocks[j][i].getValue();
						change = true;
					}	
				}
			}
			
			//reshift
			for (int j = 0; j < 4; j++) {
				for (int index = 1; index < 4; index++) {
					for (int i = 0; i < index; i++) {
						if (blocks[j][i].getValue() == 0 && blocks[j][index].getValue() > 0) {
							blocks[j][i].setValue(blocks[j][index].getValue());
							blocks[j][index].setValue(0);
							change = true;
						}

					}
				}

			}
			if (change == true) {
				genRandom();
			}
			
		}
		if (direction == "DOWN") {
			
			boolean change = false;
			
			//shift
			for (int j = 0; j < 4; j++) {
				for (int index = 2; index >= 0; index--) {
					for (int i = 3; i > index; i--) {
						if (blocks[j][i].getValue() == 0 && blocks[j][index].getValue() > 0) {
							blocks[j][i].setValue(blocks[j][index].getValue());
							blocks[j][index].setValue(0);
							change = true;
						}

					}
				}

			}
			
			//combining
			for (int j = 0; j < 4; j++) {
				for (int i = 3; i > 0; i--) {
					if (blocks[j][i - 1].getValue() == blocks[j][i].getValue()) {
						blocks[j][i].setValue(blocks[j][i].getValue() * 2);
						blocks[j][i - 1].setValue(0);
						score += blocks[j][i].getValue();
						change = true;
					}	
				}
			}
			
			//reshift
			for (int j = 0; j < 4; j++) {
				for (int index = 2; index >= 0; index--) {
					for (int i = 3; i > index; i--) {
						if (blocks[j][i].getValue() == 0 && blocks[j][index].getValue() > 0) {
							blocks[j][i].setValue(blocks[j][index].getValue());
							blocks[j][index].setValue(0);
							change = true;
						}

					}
				}

			}
			if (change == true) {
				genRandom();
			}
			
		}
	}

}
