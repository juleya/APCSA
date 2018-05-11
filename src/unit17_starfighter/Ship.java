package unit17_starfighter;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private Image image2;
	private Image temp;

	public Ship()
	{
		this(0,0,0);
	}

	public Ship(int x, int y)
	{
		this(x,y,0);
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("ship.jpg"));
			temp = ImageIO.read(new File("ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("cant find ship");
		}
		
		try
		{
			image2 = ImageIO.read(new File("shipWithShield.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("cant find ship w shield");
		}
	}


	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void changeImage() {
		image = image2;
	}
	
	public void changeBack() {
		image = temp;
	}
	
	public boolean isPowerUp() {
		return (image == image2);

	}
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}

	public void draw(Graphics window, Image image) {
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	
	public void drawNew(Graphics window) {
		
		window.drawImage(image2, getX(), getY(), 80, 80, null);
	}
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}