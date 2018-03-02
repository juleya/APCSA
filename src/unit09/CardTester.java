package unit09;

public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card test = new Card("hearts", "seven", 7);
		System.out.println(test.suit());
		System.out.println(test.rank());
		System.out.println(test.pointValue());
		System.out.println(test.toString() + "\n");
		
		Card test2 = new Card("diamonds", "queen", 12);
		System.out.println(test2.suit());
		System.out.println(test2.rank());
		System.out.println(test2.pointValue());
		System.out.println(test2.toString());
		System.out.println(test2.matches(test) + "\n");
		
		Card test3 = new Card("clubs", "jack", 11);
		System.out.println(test3.suit());
		System.out.println(test3.rank());
		System.out.println(test3.pointValue());
		System.out.println(test3.toString());
		System.out.println(test3.matches(test2) + "\n");
		
		Card test4 = new Card("hearts", "seven", 7);
		System.out.println(test4.suit());
		System.out.println(test4.rank());
		System.out.println(test4.pointValue());
		System.out.println(test4.toString());
		System.out.println(test.matches(test4) + "\n");
		
		
	}
}