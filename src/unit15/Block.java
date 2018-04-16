package unit15;

import java.awt.Color;
import java.awt.Graphics;

import unit12.Monster;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.BLACK;

	}
	
	public Block(int x, int y) {
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		color = Color.BLACK;
	}
	
	public Block(int x, int y, int w, int h, Color c) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}
	
	public Block(int x, int y, int w, int h) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLACK;
	}
	
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void setX(int x) {
		xPos = x;
	}
	
	public void setY(int y) {
		yPos = y;
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   color = col;
	   draw(window);

   }
   
	public boolean equals(Object obj)
	{
		Block m = (Block)obj;
		if (this.getX() == m.getX() && this.getY() == m.getY() && this.getWidth() == m.getWidth() && this.getHeight() == m.getHeight() && this.getColor() == m.getColor()) {
			return true;
		}

		return false;
	}   

   public int getX() {
	   return xPos;
   }
    
   public int getY() {
	   return yPos;
   }
   
   public int getWidth() {
	   return width;
   }
   
   public int getHeight() {
	   return height;
   }
   
   public Color getColor() {
	   return color;
   }

   public String toString() {
	   String output = getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
	   return output;
   }
   
}