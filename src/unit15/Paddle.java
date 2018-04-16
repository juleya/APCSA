package unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
	   speed =5;
   }


   public Paddle(int x, int y, int width, int height, Color c, int s) {
	   super(x, y, width, height, c);
	   speed = s;
	   
   }
   
   public Paddle(int x, int y) {
	   super(x, y);
	   speed = 5;
   }
   
   public Paddle(int x, int y, int s) {
	   super(x, y);
	   speed = s;
   }
   
   public Paddle(int x, int y, int width, int height, int s) {
	   super (x, y, width, height);
	   speed = s;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   
	   setY(getY() - speed);
	   
	   draw(window, Color.red);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.white);
	   
	   setY(getY() + speed);
	   
	   draw(window, Color.red);

   }
   

   public int getSpeed() {
	   return speed;
   }
   
   public String toString() {
	   return super.toString() + " " + speed;
   }
}