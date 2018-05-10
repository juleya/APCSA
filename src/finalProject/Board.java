package finalProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.RepaintManager;


public class Board extends Canvas implements KeyListener, Runnable{
	
	private Blocks blocks;
	private boolean[] keys;
	private BufferedImage back;
	private boolean done = false;
	private int score;
	private String font = "Arial";
	
	public Board() {
		setBackground(Color.black);
		
		blocks = new Blocks();
		
		keys = new boolean[4];
		
		score = 0;
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
		new RepaintManager();
		
	}
	
	public void newGame() {
		
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
		
		blocks.draw(graphToBack);
		
		if(keys[0] == true)
		{
			blocks.move("LEFT");
			
			keys[0] = false;

		}

		if (keys[1] == true) {
			blocks.move("RIGHT");
			
			keys[1] = false;
		}
		
		if (keys[2] == true) {
			blocks.move("UP");
			
			keys[2] = false;
		}
		
		if (keys[3] == true) {
			blocks.move("DOWN");
			
			keys[3] = false;
		}
		
		if (blocks.movePossible() == false) {
			window.setColor(Color.red);
			Font f = new Font(font, Font.BOLD, 30);
			window.setFont(f);
			window.drawString("YOU LOSE", 450, 800);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);

	}

	public static int assignRandom() {
		Random ran = new Random();
		if (ran.nextInt(2) == 1) {
			return 2;
		} else {
			return 4;
		}
	}
	
	public static int genY(int x) {
		Random r = new Random();
		int y = 0;
		
		if (x == 0 || x == 3) {
			return r.nextInt(4);
		}
		else if (x == 1 || x == 2) { 
			y = r.nextInt(2);
			if (y == 1) {
				return 3;
			} 
		}
		return y;
	}
	
	public void genRandom() {
		done = true;
		if (done == true) {
			done = false;
			Random r = new Random();
			int x, y = 0;
			
			x = r.nextInt(4);
			System.out.println("x = " + x);

			if (x == 0 || x == 3) {
				y = r.nextInt(4);
			}
			else if (x == 1 || x == 2) { 
				y = r.nextInt(2);
				if (y == 1) {
					y = 3;
				} 
			}
			
			System.out.println("y = " + y);

			
			if (blocks.blockAt(x, y).getValue() == 0) {
				done = false;
				System.out.println(x + " " + y);
				blocks.blockAt(x, y).setValue(assignRandom());
			} 
		}
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
