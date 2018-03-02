package unit01;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      head( window );
      
      upperBody( window );
      
      lowerBody( window );

      
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 200);

      window.setColor(Color.BLACK);
      
      window.fillOval(350, 150, 25, 25);
      
      window.fillOval(425, 150, 25, 25);
      
      window.setColor(Color.BLUE);
      
      window.fillPolygon(new int[] {390, 400, 410}, new int[] {250, 175, 250}, 3);
      
      window.setColor(Color.RED);
      
      window.drawArc(325, 275, 100, 50, 45, 45);
				
   }

   public void upperBody( Graphics window )
   {
	   window.setColor(Color.GRAY);
	   
	   window.fillPolygon(new int[] {300, 400, 500}, new int[] {500, 300, 500}, 3);
   }

   public void lowerBody( Graphics window )
   {

	   window.setColor(Color.BLACK);
	   
	   window.fillRect(340, 500, 25, 100);
	   
	   window.fillRect(430, 500, 25, 100);

   }
}