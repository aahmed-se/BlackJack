package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
	    this.deck = new ArrayList<>();
        for (Card.Suits s : Card.Suits.values()) {
            for (Card.Ranks r : Card.Ranks.values()) {
                this.deck.add(new Card(s,r));
            }
        }
	}
	
	public void shuffle() {
        Collections.shuffle(deck);
    }
	
	public Card drawCard() {
	    if(deck.size() == 0){
	        System.err.println("Error State , deck is empty");
	        System.exit(-1);
        }
        Card drawn = deck.remove(0);
	    System.out.println("blackjack.Card Drawn : " + drawn.toString());
        return drawn;
    }
}