import java.util.Arrays;
import java.util.Random;

/**
 * Een deck met Cards
 * 
 * @author Youri Tjang
 *
 */
public class Deck {
	Card[] cardArray;

	/**
	 * Constructor
	 */
	Deck(){
		cardArray = new Card[0];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fillDeck() {
		cardArray = new Card[52];
		for (int i=0 ; i <52 ; i++){
			cardArray[i] = new Card(i);
		}
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
		if (index >= cardArray.length || index < 0){ throw new ArrayIndexOutOfBoundsException();}
		cardArray = this.addElement(cardArray, card, index);
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
		if (index >= cardArray.length || index < 0){ throw new ArrayIndexOutOfBoundsException();}
		cardArray = this.removeElement(cardArray, index);
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
		Random rand = new Random();
		for (int i=0 ; i <52 ; i++){
			int nr = rand.nextInt(52);
			Card tempCard = cardArray[nr];
			int nr2 = rand.nextInt(52);
			cardArray[nr] = cardArray[nr2];
			cardArray[nr2] = tempCard;
			
		}
		
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
		for (int i =0; i < cardArray.length; i++)
        {
            if (cardArray[i].compareTo(card) == 0)
            {
                return i;
            }
        }
		throw new ArrayIndexOutOfBoundsException("Card not found");
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
		Arrays.sort(cardArray);
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbart p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		this.sort();
		return Arrays.binarySearch(cardArray,card);

	}

	/**
	 *  Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0; i<cardArray.length;i++){
			str += "\n"+ i + ": " + cardArray[i];
		}
		return str;
		
	}
	private Card[] removeElement(Card[] original, int index){
		Card[] n = new Card[original.length - 1];
        System.arraycopy(original, 0, n, 0, index);
        System.arraycopy(original, (index+1), n, index, ((original.length-index)-1) );
        return n;
	}
	private Card[] addElement(Card[] original, Card element, int index){
		Card[] n = new Card[original.length + 1];
        System.arraycopy(original, 0, n, 0, index);
        n[index] = element;
        System.arraycopy(original, index, n, index + 1, original.length - index);
	    return n;
	}
}
