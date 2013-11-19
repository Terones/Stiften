/**
 * 
 * @author Youri Tjang
 *
 */
public class Card implements Comparable<Card> {
	/**
	 * Klaver, Schoppen, Harten of Ruiten 
	 * Hoeft niet persé van type Object te zijn,
	 * vul zelf in
	 */
	eSuit suit;
	
	/**
	 * 2,3,4,5,6,7,8,9,10,b,v,k,a
	 * Hoeft niet persé van type Object te zijn,
	 * vul zelf in
	 */
	eNumber number;
	
	public Card (){
	}
	
	public Card (int CardID){
		this.fromCardIDtoCard(CardID);
	}
	
	public Card ( eNumber inNumber, eSuit inSuit){
		this.number = inNumber;
		this.suit = inSuit;
	}
	/**
	 * Pretty-print deze Card als string
	 */
	public String toString(){
		if ( suit == null){
			return "card not initialised";
		}
		return "Card: " + number.toString() + " of " + suit.toString() ;
	}
	
	public enum eSuit {
		clubs,    // (♣)
		diamonds, // (♦)
		hearts,   // (♥)
		spades    // (♠)
	}
	public enum eNumber {
		Ace, Two, Three, Four, Five, Six, Seven, 
		Eight, Nine, Ten, Jack, Queen,	King

	}
	
	
	/* @doc this function will calculate a card from a number from 0 to 51 */
	private void fromCardIDtoCard(int CardID){
		switch (CardID % 13) {
		case 0:
			this.number = eNumber.Ace;
			break;
		case 1:
			this.number = eNumber.Two;
			break;
		case 2:
			this.number = eNumber.Three;
			break;
		case 3:
			this.number = eNumber.Four;
			break;
		case 4:
			this.number = eNumber.Five;
			break;
		case 5:
			this.number = eNumber.Six;
			break;
		case 6:
			this.number = eNumber.Seven;
			break;
		case 7:
			this.number = eNumber.Eight;
			break;
		case 8:
			this.number = eNumber.Nine;
			break;
		case 9:
			this.number = eNumber.Ten;
			break;
		case 10:
			this.number = eNumber.Jack;
			break;
		case 11:
			this.number = eNumber.Queen;
			break;
		case 12:
			this.number = eNumber.King;
			break;
		}
	
		switch (CardID/13) {
		case 0:
			this.suit = eSuit.clubs;
			break;
		case 1:
			this.suit = eSuit.spades;
			break;
		case 2:
			this.suit = eSuit.hearts;
			break;
		case 3:
			this.suit = eSuit.diamonds;
			break;
		}
	}

	
	private int fromCardtoCardID(){
		int returnInt = 0;
		
		switch (number) {
		case Ace:
			returnInt = 0;
			break;
		case Two:
			returnInt = 1;
			break;
		case Three:
			returnInt = 2;
			break;
		case Four:
			returnInt = 3;
			break;	
		case Five:
			returnInt = 4;
			break;
		case Six:
			returnInt = 5;
			break;
		case Seven:
			returnInt = 6;
			break;
		case Eight:
			returnInt = 7;
			break;
		case Nine:
			returnInt = 8;
			break;
		case Ten:
			returnInt = 9;
			break;
		case Jack:
			returnInt = 10;
			break;
		case Queen:
			returnInt = 11;
			break;
		case King:
			returnInt = 12;
			break;
		}
	
		switch (suit) {
		case clubs:
			break;
		case spades:
			returnInt +=13;
			break;
		case hearts:
			returnInt += 26;
			break;
		case diamonds:
			returnInt += 39;
			break;
		}
		
		return returnInt;
	}
	@Override
	public int compareTo(Card o) {
		return Integer.compare(this.fromCardtoCardID(), o.fromCardtoCardID());
	}
}

