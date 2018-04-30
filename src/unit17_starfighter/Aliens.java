package unit17_starfighter;

import java.util.ArrayList;

public class Aliens {
	private Alien alienOne;
	private Alien alienTwo;
	private ArrayList<Alien> aliens;
	
	public Aliens() {
		alienOne = new Alien(20, 0, 2);
		alienTwo = new Alien(200, 0, -2);
		
		aliens = new ArrayList<Alien>();
		aliens.add(alienOne);
		aliens.add(alienTwo);
		aliens.add(new Alien(400, 0, 5));
		aliens.add(new Alien(50, 100, -2));
		aliens.add(new Alien(400, 100, 4));
		aliens.add(new Alien(20, 100, -5));
		aliens.add(new Alien(20, 200, 3));
		aliens.add(new Alien(200, 200, -4));
		aliens.add(new Alien(50, 200, 2));
	}
	
	public ArrayList<Alien> returnList() {
		return aliens;
	}
}
