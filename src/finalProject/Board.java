package finalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font.*;

public class Board extends Canvas implements KeyListener, Runnable{
	
	private Block[][] blocks;
	private boolean[] keys;
	private BufferedImage back;
	
	public Board() {
		setBackground(Color.black);
		blocks = new Block[4][4];

		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				blocks[i][j] = new Block(assignRandom(), i * 120 + 20, j * 120 + 20);
			}


		}
		
		keys = new boolean[4];
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	
	public void newGame() {
		
	}
	
	public static int assignRandom() {
		Random ran = new Random();
		if (ran.nextInt(2) == 1) {
			return 2;
		} else {
			return 4;
		}
	}
	
	public int length() {
		return blocks.length;
	}
	
	public Block blockAt(int row, int column) {
		return blocks[row][column];
	}
	
	public void update(Graphics window) {
		paint(window);
	}
	
	public void paint(Graphics window) {
		
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		Graphics graphToBack = back.createGraphics();
		
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				blocks[i][j].draw(graphToBack);
			}

		}
		
		if(keys[0] == true)
		{
			
		}

		if (keys[1] == true) {
			
		}
		
		if (keys[2] == true) {
			
		}
		
		if (keys[3] == true) {
			
		}
		
		twoDGraph.drawImage(back, null, 0, 0);

	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {

	}

	public void run()
	{
		try
		{
			while(true)
			{
   		   Thread.currentThread().sleep(5);
            repaint();
   			}
	      }catch(Exception e)
	      {
	      }
	  	}

	
}
