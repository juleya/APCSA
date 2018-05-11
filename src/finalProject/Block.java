package finalProject;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;


public class Block extends Colorizer{
	private int value;
	private int xPos;
	private int yPos;
	private String font = "Helvetica Neue";
	//private Font newFont;
	
	public Block(int num, int x, int y) {
		value = num;
		xPos = x;
		yPos = y;
	}

	public void setValue(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setX(int x) {
		xPos = x;
	}
	
	public void setY(int y) {
		yPos = y;
	}
	
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public void draw(Graphics window) {
		
		//Graphics2D g2d = (Graphics2D)window;

		
		
		
		window.setColor(getColor(value));
		window.fillRect(getX(), getY(), 100, 100);
		
		Font f = new Font(font, Font.BOLD, 36);
		window.setFont(f);
		
		if (value != 0) {
			Graphics2D g2d = (Graphics2D) window;
			FontMetrics fm = window.getFontMetrics();
			Rectangle2D r = fm.getStringBounds(String.valueOf(getValue()), g2d);
	        int x = (100 - (int) r.getWidth()) / 2;
	        int y = (100 - (int) r.getHeight()) / 2 + fm.getAscent();
			
			window.setColor(Color.white);
			window.drawString(String.valueOf(getValue()), getX() + x, getY() + y);
		}

	}

}
