package unit17_starfighter;

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
import java.io.File;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Font.*;
import java.awt.Image;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private Aliens allAliens;
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	private int score;
	private boolean done;
	private boolean[] keys;
	private BufferedImage back;
	private ArrayList<Ammo> alienShots;
	private PowerUp pu;
	private Ship ship2;
	private Image image;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[6];
		
		ship = new Ship(300, 500, 2);
		ship2 = new Ship(ship.getX(), ship.getY(), 2);
		
		try
		{
			image = ImageIO.read(new File("shipWithShield.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("cant find pu");
		}
		
		done = false; 
		
		pu = new PowerUp(200, 400, 0);
		/*
		
		alienOne = new Alien(20, 0, 2);
		alienTwo = new Alien(200, 0, -2);
		
		aliens = new ArrayList<Alien>();
		aliens.add(alienOne);
		aliens.add(alienTwo);
		aliens.add(new Alien(400, 0, 5));
		aliens.add(new Alien(50, 100, -2));
		aliens.add(new Alien(400, 100, 4));
		aliens.add(new Alien(20, 100, -5));
		aliens.add(new Alien(20, 200, 3));
		aliens.add(new Alien(200, 200, -4));
		aliens.add(new Alien(50, 200, 2));
		*/
		allAliens = new Aliens();
		aliens = allAliens.returnList();
		
		shots = new ArrayList<Ammo>();
		alienShots = new ArrayList<Ammo>();

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }
   
   public void writeOverScore(Graphics window) {
	   
	   	window.setColor(Color.black);

		window.drawString("Score: " + score, 50, 500);
		
  }
  public void updateScore(Graphics window) {
	   
		window.setColor(Color.yellow);

		window.drawString("Score: " + score, 50, 500);
  }
  
  public void displayLose(Graphics window) {
		window.setColor(Color.RED);
		window.drawString("You lose! Play again? Press Y to continue.", 200, 500);
		
		if (keys[5] == true) {
			score = 0;
			ship.changeBack();
			ship.setPos(300, 500);
			
			if (pu.getX() > 1000) {
				pu.setPos(pu.getX() - 1000, pu.getY() - 1000);
			}
			
			for (Alien alien: aliens) {
				if (alien.getX() >= 1000) {
					alien.setPos(alien.getX() - 1000, alien.getY() - 1000);

				}
				int speed = 0;
				do {
					Random rand = new Random();
					speed = rand.nextInt((5 + 1 + 5) - 5);
				} while (speed == 0);

				alien.setSpeed(speed);

			}

		}
		
  }
  
  public void displayWin(Graphics window) {
		window.setColor(Color.RED);
		window.drawString("You win! Play again? Y to continue.", 200, 500);
		
		if (keys[5] == true) {
			score = 0;
			ship.changeBack();
			ship.setPos(300, 500);
			if (pu.getX() > 1000) {
				pu.setPos(pu.getX() - 1000, pu.getY() - 1000);
			}

			for (Alien alien: aliens) {
				alien.setPos(alien.getX() - 1000, alien.getY() - 1000);
			}

		}
		
  }
  
  	public void pauseAliens() {
  		for (Alien alien: aliens) {
  			alien.setSpeed(0);

  			
  		}
  	}
  	

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		pu.draw(graphToBack);
		
		ship.draw(graphToBack);
		updateScore(graphToBack);
		
		if (ship.getX() >= pu.getX()
				&& ship.getX() <= pu.getX() + 80
				&& ship.getY() >= pu.getY()
				&& ship.getY() <= pu.getY() + 80
			|| (pu.getX() >= ship.getX()
			&& pu.getX() <= ship.getX() + 80
			&& pu.getY() >= ship.getY()
			&& pu.getY() <= ship.getY() + 80)) {
				pu.setPos(pu.getX() + 1000, pu.getY() + 1000);
				ship.changeImage();
				ship.draw(graphToBack);

		}
		
		for (Alien alien: aliens) {
			alien.draw(graphToBack);
			
			alienShots.add(new Ammo(alien.getX() + 40, alien.getY() + 80, -1));
			
			if (alien.getX() <= 0 || alien.getX() > 720) 
				alien.setSpeed(- alien.getSpeed());
			
			
			if (ship.getX() >= alien.getX()
					&& ship.getX() <= alien.getX() + 80
					&& ship.getY() >= alien.getY()
					&& ship.getY() <= alien.getY() + 80
				|| (alien.getX() >= ship.getX()
				&& alien.getX() <= ship.getX() + 80
				&& alien.getY() >= ship.getY()
				&& alien.getY() <= ship.getY() + 80)) {
					pauseAliens();
					for (Ammo shot: alienShots) {
						shot.setSpeed(0);
						shot.setPos(1000, 1000);
					}
					displayLose(graphToBack);

			}

		}
		
		for (int i = 0; i < alienShots.size(); i += 100) {
			alienShots.get(i).draw(graphToBack);
			if (!ship.isPowerUp()
					&& alienShots.get(i).getX() >= ship.getX() 
					&& alienShots.get(i).getX() + 10 <= ship.getX() + 80 
					&& alienShots.get(i).getY() + 10 <= ship.getY() + 80
					&& alienShots.get(i).getY() >= ship.getY()) {
				
				alienShots.get(i).setPos(getX() + 1000, getY() + 1000);
				alienShots.get(i).setSpeed(0);
				writeOverScore(graphToBack);
				score--;
				updateScore(graphToBack);
			}

		}

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}

		if (keys[1] == true) {
			ship.move("RIGHT");
		}
		
		if (keys[2] == true) {
			ship.move("DOWN");
		}
		
		if (keys[3] == true) {
			ship.move("UP");
		}

		if (keys[4] == true) {
			
			shots.add(new Ammo(ship.getX() + 40, ship.getY(), 5));
			
			keys[4] = false;
		}
		
		
		for (Ammo ammo: shots) { 
			ammo.draw(graphToBack);
			
			for (Alien alien: aliens) {
				if (ammo.getX() >= alien.getX() 
						&& ammo.getX() + 10 <= alien.getX() + 80 
						&& ammo.getY() + 10 <= alien.getY() + 80
						&& ammo.getY() >= alien.getY()) {

					alien.setPos(alien.getX() + 1000, alien.getY() + 1000);
					writeOverScore(graphToBack);
					score++;
					updateScore(graphToBack);
				}

			}
		
		}

		int counter = 0;
		for (Alien alien : aliens) {
			if (alien.getX() > 1000) {
				counter++;
			}
		}
		if (counter == 9) {
			displayWin(graphToBack);

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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		if (toUpperCase(e.getKeyChar()) == 'Y')
		{
			keys[5] = true;
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		if (toUpperCase(e.getKeyChar()) == 'Y')
		{
			keys[5] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

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