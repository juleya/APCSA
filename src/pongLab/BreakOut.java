package pongLab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;


// 	USING A & D INSTEAD OF W & Z
// USING NEW MOVERIGHT AND LEFT METHODS FROM PADDLE


public class BreakOut extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	//privateSpeedUpBall ball;
	//private BlinkyBall ball;
	
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int score = 0;

	private Block brick1, brick2, brick3, brick4, brick5, brick6, brick7, brick8, brick9, brick10, brick11,
	brick12, brick13, brick14, brick15, brick16, brick17, brick18, brick19, brick20;

	public BreakOut()
	{
		System.out.println("Julia Yang");
		System.out.println("Period 4");
		System.out.println("04/04/18");
		System.out.println("Computer Number: 37");
		
		//set up all variables related to the game
		ball = new Ball (300, 20, 10, 10, Color.blue, 3, 2);		
		paddle = new Paddle (20, 430, 15, 100, Color.red, 5);
		
		brick1 = new Block (625, 5, 10, 100);
		brick2 = new Block (625, 120, 10, 100);
		brick3 = new Block (625, 240, 10, 100);
		brick4 = new Block (625, 360, 10, 100);
		brick5 = new Block (625, 480, 10, 100);
		
		brick6 = new Block (675, 5, 10, 100);
		brick7 = new Block (675, 120, 10, 100);
		brick8 = new Block (675, 240, 10, 100);
		brick9 = new Block (675, 360, 10, 100);
		brick10 = new Block (675, 480, 10, 100);
		
		brick11 = new Block (725, 5, 10, 100);
		brick12 = new Block (725, 120, 10, 100);
		brick13 = new Block (725, 240, 10, 100);
		brick14 = new Block (725, 360, 10, 100);
		brick15 = new Block (725, 480, 10, 100);
		
		brick16 = new Block (775, 5, 10, 100);
		brick17 = new Block (775, 120, 10, 100);
		brick18 = new Block (775, 240, 10, 100);
		brick19 = new Block (775, 360, 10, 100);
		brick20 = new Block (775, 480, 10, 100);

		keys = new boolean[2];

		setBackground(Color.WHITE);
		
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }
   
   public void writeOverScore(Graphics window) {
	   
	   	window.setColor(Color.white);

		window.drawString("Score: " + score, 50, 200);

		
  }
  public void updateScore(Graphics window) {
	   
		window.setColor(Color.blue);

		window.drawString("Score: " + score, 50, 200);

  }

   public void paint(Graphics window)
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

		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		
		updateScore(graphToBack);
		
		

				
		brick1.draw(graphToBack);		
		brick2.draw(graphToBack);
		brick3.draw(graphToBack);
		brick4.draw(graphToBack);
		brick5.draw(graphToBack);	
		
		brick6.draw(graphToBack);		
		brick7.draw(graphToBack);
		brick8.draw(graphToBack);
		brick9.draw(graphToBack);
		brick10.draw(graphToBack);
		
		brick11.draw(graphToBack);		
		brick12.draw(graphToBack);
		brick13.draw(graphToBack);
		brick14.draw(graphToBack);
		brick15.draw(graphToBack);

		brick16.draw(graphToBack);		
		brick17.draw(graphToBack);
		brick18.draw(graphToBack);
		brick19.draw(graphToBack);
		brick20.draw(graphToBack);
	
		if (ball.didCollideRight(paddle) || ball.didCollideLeft(paddle)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		
		else if (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle)){
			
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			
		}
		
		else if (ball.didCollideTop(brick1)|| ball.didCollideBottom(brick1) || ball.didCollideLeft(brick1) || ball.didCollideRight(brick1)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick1.draw(graphToBack, Color.WHITE);
			
			brick1.setWidth(0);
			brick1.setHeight(0);
		}
		else if (ball.didCollideTop(brick2)|| ball.didCollideBottom(brick2) || ball.didCollideLeft(brick2) || ball.didCollideRight(brick2)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick2.draw(graphToBack, Color.WHITE);

			brick2.setWidth(0);
			brick2.setHeight(0);
		}
		else if (ball.didCollideTop(brick3)|| ball.didCollideBottom(brick3) || ball.didCollideLeft(brick3) || ball.didCollideRight(brick3)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick3.draw(graphToBack, Color.WHITE);

			brick3.setWidth(0);
			brick3.setHeight(0);
		}
		else if (ball.didCollideTop(brick4)|| ball.didCollideBottom(brick4) || ball.didCollideLeft(brick4) || ball.didCollideRight(brick4)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick4.draw(graphToBack, Color.WHITE);

			brick4.setWidth(0);
			brick4.setHeight(0);
		}
		else if (ball.didCollideTop(brick5)|| ball.didCollideBottom(brick5)|| ball.didCollideLeft(brick5) || ball.didCollideRight(brick5)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick5.draw(graphToBack, Color.WHITE);

			brick5.setWidth(0);
			brick5.setHeight(0);
		}

		
		else if (ball.didCollideTop(brick6)|| ball.didCollideBottom(brick6)|| ball.didCollideLeft(brick6) || ball.didCollideRight(brick6)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick6.draw(graphToBack, Color.WHITE);

			brick6.setWidth(0);
			brick6.setHeight(0);
		}
		
		else if (ball.didCollideTop(brick7)|| ball.didCollideBottom(brick7)|| ball.didCollideLeft(brick7) || ball.didCollideRight(brick7)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick7.draw(graphToBack, Color.WHITE);

			brick7.setWidth(0);
			brick7.setHeight(0);
		}
		
		else if (ball.didCollideTop(brick8)|| ball.didCollideBottom(brick8)|| ball.didCollideLeft(brick8) || ball.didCollideRight(brick8)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick8.draw(graphToBack, Color.WHITE);

			brick8.setWidth(0);
			brick8.setHeight(0);
		}
		
		else if (ball.didCollideTop(brick9)|| ball.didCollideBottom(brick9)|| ball.didCollideLeft(brick9) || ball.didCollideRight(brick9)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick9.draw(graphToBack, Color.WHITE);

			brick9.setWidth(0);
			brick9.setHeight(0);
		}
		
		else if (ball.didCollideTop(brick10)|| ball.didCollideBottom(brick10)|| ball.didCollideLeft(brick10) || ball.didCollideRight(brick10)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick10.draw(graphToBack, Color.WHITE);

			brick10.setWidth(0);
			brick10.setHeight(0);
		}		
		else if (ball.didCollideTop(brick11)|| ball.didCollideBottom(brick11)|| ball.didCollideLeft(brick11) || ball.didCollideRight(brick11)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick11.draw(graphToBack, Color.WHITE);

			brick11.setWidth(0);
			brick11.setHeight(0);
		}
		else if (ball.didCollideTop(brick12)|| ball.didCollideBottom(brick12)|| ball.didCollideLeft(brick12) || ball.didCollideRight(brick12)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick12.draw(graphToBack, Color.WHITE);

			brick12.setWidth(0);
			brick12.setHeight(0);
		}
		else if (ball.didCollideTop(brick13)|| ball.didCollideBottom(brick13)|| ball.didCollideLeft(brick13) || ball.didCollideRight(brick13)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick13.draw(graphToBack, Color.WHITE);

			brick13.setWidth(0);
			brick13.setHeight(0);
		}
		else if (ball.didCollideTop(brick14)|| ball.didCollideBottom(brick14)|| ball.didCollideLeft(brick14) || ball.didCollideRight(brick14)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick14.draw(graphToBack, Color.WHITE);

			brick14.setWidth(0);
			brick14.setHeight(0);
		}
		else if (ball.didCollideTop(brick15)|| ball.didCollideBottom(brick15)|| ball.didCollideLeft(brick15) || ball.didCollideRight(brick15)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick15.draw(graphToBack, Color.WHITE);

			brick15.setWidth(0);
			brick15.setHeight(0);
		}
		else if (ball.didCollideTop(brick16)|| ball.didCollideBottom(brick16)|| ball.didCollideLeft(brick16) || ball.didCollideRight(brick16)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick16.draw(graphToBack, Color.WHITE);

			brick16.setWidth(0);
			brick16.setHeight(0);
		}
		else if (ball.didCollideTop(brick17)|| ball.didCollideBottom(brick17)|| ball.didCollideLeft(brick17) || ball.didCollideRight(brick17)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick17.draw(graphToBack, Color.WHITE);

			brick17.setWidth(0);
			brick17.setHeight(0);
		}
		else if (ball.didCollideTop(brick18)|| ball.didCollideBottom(brick18)|| ball.didCollideLeft(brick18) || ball.didCollideRight(brick18)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick18.draw(graphToBack, Color.WHITE);

			brick18.setWidth(0);
			brick18.setHeight(0);
		}
		else if (ball.didCollideTop(brick19)|| ball.didCollideBottom(brick19)|| ball.didCollideLeft(brick19) || ball.didCollideRight(brick19)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick19.draw(graphToBack, Color.WHITE);

			brick19.setWidth(0);
			brick19.setHeight(0);
		}
		else if (ball.didCollideTop(brick20)|| ball.didCollideBottom(brick20)|| ball.didCollideLeft(brick20) || ball.didCollideRight(brick20)) {
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
			writeOverScore(graphToBack);
			score++;
			updateScore(graphToBack);
			brick20.draw(graphToBack, Color.WHITE);

			brick20.setWidth(0);
			brick20.setHeight(0);
		}

		if(!(ball.getX()>=5))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			writeOverScore(graphToBack);
			score = 0;
			updateScore(graphToBack);
				

			ball.draw(graphToBack, Color.white);
			ball.setColor(Color.black);
			ball = new Ball(200,300,10,10,Color.BLUE,2,1);
				
		}
		
		
		if(!(ball.getY()>=0 && ball.getY()<=550))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		
		if (!(ball.getX() <= 785)) {
			ball.setXSpeed(-ball.getXSpeed());
		}

		//see if the paddles need to be moved

		if (keys[0] == true)
		{
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			paddle.moveDownAndDraw(graphToBack);

		}

		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;

		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}