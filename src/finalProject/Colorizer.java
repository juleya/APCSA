package finalProject;

import java.awt.Color;

public class Colorizer {
	
	Color color;
	
	public Color getColor(int value) {

		if (value == 2) {
			return new Color(216, 17, 255);
		}
		
		if (value == 4) {
			return new Color(143, 45, 86);
		}
		
		if (value == 8) {
			return new Color(33, 131, 128);			
		}
		
		if (value == 16) {
			return new Color(251, 177, 60);			
		}
		if (value == 32) {
			return new Color(115, 210, 222);			
		}
		if (value == 64) {
			return new Color(88, 178, 66);
		}
		
		if (value == 128) {
			return new Color(66, 120, 178);
		}
		
		if (value == 256) {
			return new Color(198, 148, 91);
		}
		
		if (value == 512) {
			return new Color(81, 70, 58);
		}
		if (value == 1024) {
			return new Color(53, 31, 81);
		}
		
		if (value == 2048) {
			return new Color(219, 86, 65);
		}
		
		return new Color(216, 201, 199);
	}
}
