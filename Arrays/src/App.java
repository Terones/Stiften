/**
 * 
 * @author Youri Tjang
 *
 */
public class App {

	/**
	 * App die onze datastructuur test.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.fillDeck();
		deck.shuffle();
		//System.out.println(deck.toString());
		
		Card card = new Card(Card.eNumber.Ace, Card.eSuit.hearts);
		int testIndex = 30;
		deck.insertAt(card, testIndex);
		
		//System.out.println(deck.toString());
		
		System.out.print("Sequential search ...");
		int foundIndex = deck.sequentialSearch(card);
		System.out.println(foundIndex);
		System.out.println((foundIndex == testIndex)?"Win":"Fail");
		System.out.print("Binary search...");
		deck.sort();
		foundIndex = deck.binarySearch(card);
		System.out.println(foundIndex);

		
	}
}
