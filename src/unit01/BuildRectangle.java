package unit01;

import java.awt.Rectangle;

public class BuildRectangle {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(0, 0, 7, 6);
		System.out.println(r.getWidth());
		System.out.println(r.getHeight());
		Rectangle newrect = new Rectangle(0, 0, 12, 9);
		System.out.println(newrect.getWidth());
		System.out.println(newrect.getHeight());
	}

}
