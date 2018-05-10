package finalProject;

import javax.swing.JFrame;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Game extends JFrame{
	private static final int WIDTH = 900;
	private static final int HEIGHT = 900;
	
	public Game() {
		
		setSize(WIDTH,HEIGHT);
		
		Board board = new Board();
		((Component)board).setFocusable(true);
		getContentPane().add(board);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Game run = new Game();
	}
}
