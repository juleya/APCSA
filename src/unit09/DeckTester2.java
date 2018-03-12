package unit09;

public class DeckTester2 {

	/**
	 * The main method in this class checks the Deck2 operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck2 test = new Deck2(new String[] {"A", "B", "C"}, new String[] {"Giraffes", "Lions"}, new int[] {2, 1, 6});
		System.out.println("UNSHUFFLED");
		System.out.println(test.toString());
		test.shuffle();
		System.out.println(test.isEmpty());
		System.out.println(test.size());
		System.out.println(test.deal());
		System.out.println("\nSHUFFLED");
		System.out.println(test.toString());
		
		Deck2 standard = new Deck2(new String[] {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"}, new String[] {"hearts", "spades", "clubs", "diamonds"}, new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11});
		System.out.println("UNSHUFFLED");
		System.out.println(standard.toString());
		standard.shuffle();
		System.out.println("\nSHUFFLED");
		System.out.println(standard.toString());
		
		}
}
