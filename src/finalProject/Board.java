package finalProject;

import java.awt.Color;
import java.awt.Image;
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
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font.*;

import javax.imageio.ImageIO;
import javax.swing.RepaintManager;


public class Board extends Canvas implements KeyListener, Runnable{
	
	private Blocks blocks;
	private boolean[] keys;
	private BufferedImage back;
	private int score;
	private boolean drawnIntro = false;
	private IntroScreen intro;
	private boolean keyPressed = false;

	public Board() {

		setBackground(Color.white);
		
		blocks = new Blocks();
		
		keys = new boolean[5];
		
		intro = new IntroScreen();
		
		score = 0;
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
		new RepaintManager();
		
	}
	

	public void update(Graphics window) {
		paint(window);
	}
	
	public void paint(Graphics window) {
		
		
		Graphics2D twoDGraph = (Graphics2D)window;
		if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
		
		Graphics graphToBack = back.createGraphics();
		
		if (drawnIntro == false) {
			intro.draw(graphToBack); 

			if (keyPressed) {
				drawnIntro = true;
				graphToBack.setColor(Color.white);
				graphToBack.fillRect(0,0,710,525);
				blocks.draw(graphToBack);

			}
		} else {
			graphToBack.setColor(Color.white);
			graphToBack.fillRect(0,0,710,525);
			
			blocks.draw(graphToBack);
		}
		
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
		if (blocks.winsGame() == true) {
			graphToBack.setColor(Color.red);
			Font f = new Font("Comic Sans MS", Font.BOLD, 125);
			graphToBack.setFont(f);
			graphToBack.drawString("YOU WON", 10, 200);
			
			graphToBack.setColor(Color.black);
			graphToBack.fillRect(20, 250, 425, 50);
			graphToBack.setColor(Color.white);
			f = new Font("Monospaced", Font.PLAIN, 20);
			graphToBack.setFont(f);
			graphToBack.drawString("PLAY AGAIN? PRESS 'Y' TO CONTINUE", 30, 280);
			
			if (keys[4] == true) {
				graphToBack.setColor(Color.white);
				graphToBack.fillRect(0,0,710,525);
				blocks.startOver();
			}
		}
		if (blocks.movePossible() == false) {
			graphToBack.setColor(Color.red);
			Font f = new Font("Comic Sans MS", Font.BOLD, 125);
			graphToBack.setFont(f);
			graphToBack.drawString("you lose :(", 10, 200);
			
			graphToBack.setColor(Color.black);
			graphToBack.fillRect(20, 250, 425, 50);
			graphToBack.setColor(Color.white);
			f = new Font("Monospaced", Font.PLAIN, 20);
			graphToBack.setFont(f);
			graphToBack.drawString("PLAY AGAIN? PRESS 'Y' TO CONTINUE", 30, 280);
			
			if (keys[4] == true) {
				graphToBack.setColor(Color.white);
				graphToBack.fillRect(0,0,710,525);
				blocks.startOver();
			}
		}
		
		twoDGraph.drawImage(back, null, 0, 0);

	}

	public void keyPressed(KeyEvent e)
	{
		keyPressed = true;
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
		if (e.getKeyCode() == KeyEvent.VK_Y)
			keys[4] = true;
		
		repaint();
	}
	
	public void keyReleased(KeyEvent e)
	{
		keyPressed = false;
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
		if (e.getKeyCode() == KeyEvent.VK_Y)
		{
			keys[4] = false;
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
