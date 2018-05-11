package finalProject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class IntroScreen {
	private Image image;
	
	public IntroScreen() {
		try
		{
			image = ImageIO.read(new File("intro.png"));
		}
		catch(Exception e)
		{
			System.out.println("cant find intro");
		}
		
	}
	
	public void draw(Graphics window) {
		window.drawImage(image, 0, 0, 710, 525, null);
	}
	
}
