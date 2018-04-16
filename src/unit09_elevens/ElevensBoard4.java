package unit09_elevens;


import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard4 extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard4() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		
		System.out.println("Julia Yang");
		System.out.println("Period 4");
		System.out.println("03/28/18");
		System.out.println("Computer Number 37");
		
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			
			return containsPairSum11(selectedCards);
			
		} else if (selectedCards.size() == 3) {
			
			return containsJQK(selectedCards);
		}
		
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		List<Integer> board = cardIndexes();

		return containsPairSum11(board) || containsJQK(board);
		
	}


	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		
        if (selectedCards.size() < 2) {
            return false;
        }
        
        for (int i = 0; i < selectedCards.size() - 1; i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {
            	
                if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() == 11) {
                    return true;
                    
                    
                }
            }
        }
            
        	
        for (int i = 0; i < selectedCards.size() - 2; i++) {
            for (int j = i + 1; j < selectedCards.size() - 1; j++) {
            		for (int k = j + 1; k < selectedCards.size(); k++) {
            			if (i != j && j!= k && i!=k) {
                            if (cardAt(selectedCards.get(i)).pointValue() + cardAt(selectedCards.get(j)).pointValue() + cardAt(selectedCards.get(k)).pointValue() == 11) {
                            		return true;
                                
                            }
            			}

            		}
            	

            }
        }
        
    
   
        
        return false;
	
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		
		int jack = 0, queen = 0, king = 0;
		
		for (int i : selectedCards) {
			
			if (cardAt(i).rank() == "jack") {
				jack++;
			} 
			
			else if (cardAt(i).rank() == "queen") {
				queen++;
			} 
			
			else if (cardAt(i).rank() == "king") {
				king++;
			}
			
		}
		
		if (jack > 0 && queen > 0 && king > 0)
			return true;
		
		else if (jack == 2 || queen == 2 || king == 2) {
			return true;
		} 
		
		
		return false;
        
	}
	
	public static void printCards(ElevensBoard board) {
		
		List<Integer> cIndexes = board.cardIndexes();
		for (int i : cIndexes) {
				System.out.println(i);
		
		}
		
	}
}