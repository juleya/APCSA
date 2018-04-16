package unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y) {
		super(x,y);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height, Color c) {
		super(x, y, width, height, c);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int width, int height, int xS, int yS) {
		super(x, y, width, height);
		xSpeed = xS;
		ySpeed = yS;
	}
	
	public Ball(int x, int y, int width, int height, Color c, int xS, int yS) {
		super(x, y, width, height, c);
		xSpeed = xS;
		ySpeed = yS;
	}
	
	public void setXSpeed(int x) {
		xSpeed = x;
	}
	
	public void setYSpeed(int y) {
		ySpeed = y;
	}
   

   public void moveAndDraw(Graphics window)
   {
	  draw(window, Color.white);


      setX(getX() + xSpeed);
      setY(getY() + ySpeed);
      

      draw(window, Color.black);
   }
   
	public boolean equals(Object obj)
	{

		Ball m = (Ball)obj;

		
		if (this.getXSpeed() == m.getXSpeed() && this.getYSpeed() == m.getYSpeed()) {
			return super.equals(m);
		}
	
		return false;
	}   

   public int getXSpeed() {
	   return xSpeed;
   }
   
   public int getYSpeed() {
	   return ySpeed;
   }
   
 
   
   public boolean didCollideLeft(Object obj) {
	   Block b = (Block) obj;
	   
	   if (this.getX() <= b.getX() + b.getWidth() 
	   && this.getX() > b.getX()
	   && (this.getY() >= b.getY()
	   && this.getY() <= b.getY() + b.getHeight())) 
		   return true;
	
	   return false;
   }
   
   public boolean didCollideRight(Object obj) {
	   Block b = (Block) obj;
	   
	   if (this.getX() + this.getWidth() >= b.getX() - Math.abs(getXSpeed())
			   && this.getX() < b.getX()
			   && (this.getY()>= b.getY()
			   && this.getY() <= b.getY() + b.getHeight())) {
		   
			return true;
			
		}
	   
	   return false;
   }
   
   public boolean didCollideTop(Object obj) {
	   	Block b = (Block) obj;
	   	
		if((this.getX() >= b.getX() 
				&& b.getX() + b.getWidth() >= this.getX() + this.getWidth())
				&& this.getY() + this.getHeight() >= b.getY() - Math.abs(this.getYSpeed())
				&& this.getY() < b.getY() + b.getHeight()) {
			return true;
		}
		return false;
	   
   }
   
   public boolean didCollideBottom(Object obj) {
	   
	   	Block b = (Block) obj;
	   	
		if((this.getX() >= b.getX()
				&& this.getX() + this.getWidth() <= b.getX() + b.getWidth())
				&& this.getY() + this.getHeight() > b.getY() - Math.abs(this.getYSpeed())
				&& this.getY() - Math.abs(this.getYSpeed()) <= b.getY() + b.getHeight()) {
			return true;
		}
		return false;
   }
   

   public String toString() {
	   return super.toString() + " " + getXSpeed() + " " + getYSpeed();
   }
}