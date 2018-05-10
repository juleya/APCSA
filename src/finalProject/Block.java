package finalProject;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.*;
import javax.swing.*;


public class Block {
	private int value;
	private int xPos;
	private int yPos;
	private String font = "Arial";
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
		
		window.setColor(Color.white);
		window.fillRect(getX(), getY(), 100, 100);
		
		Font f = new Font(font, Font.BOLD, 24);
		window.setFont(f);
		
		if (value != 0) {
			window.setColor(Color.black);
			window.drawString(String.valueOf(getValue()), getX() + 40, getY() + 55);
		}

	}

}
