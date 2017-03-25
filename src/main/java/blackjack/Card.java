package blackjack;

public class Card {

    public enum Suits {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;
    }

    public enum Ranks {
        ACE,
        NUM2,
        NUM3,
        NUM4,
        NUM5,
        NUM6,
        NUM7,
        NUM8,
        NUM9,
        NUM10,
        JACK,
        QUEEN,
        KING

    }

	private final Suits suit;
	private final Ranks rank;

	public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
	}

	public Suits getSuit() {
		return suit;
	}

	public Ranks getValue() {
		return rank;
	}

	public String getSuitAsString() {
		switch ( suit ) {
			case SPADES:   return "Spades";
			case HEARTS:   return "Hearts";
			case DIAMONDS: return "Diamonds";
			case CLUBS:    return "Clubs";
			default:       return "N/A";
		}
	}

	public String getValueAsString() {
		switch ( rank ) {
            case ACE : return "Ace";
			case NUM2:   return "2";
			case NUM3:   return "3";
			case NUM4:   return "4";
			case NUM5:   return "5";
			case NUM6:   return "6";
			case NUM7:   return "7";
			case NUM8:   return "8";
			case NUM9:   return "9";
			case NUM10:  return "10";
            case JACK:  return "Jack";
            case QUEEN:  return "Queen";
            case KING:  return "King";
			default:  return "N/A";
		}
	}

    public int getPointValue() {
        switch ( rank ) {
            case ACE : return 11;
            case NUM2:   return 2;
            case NUM3:   return 3;
            case NUM4:   return 4;
            case NUM5:   return 5;
            case NUM6:   return 6;
            case NUM7:   return 7;
            case NUM8:   return 8;
            case NUM9:   return 9;
            case NUM10:  return 10;
            case JACK:  return 10;
            case QUEEN:  return 10;
            case KING:  return 10;
            default:  return 0;
        }
    }

	public String toString() {
		return getValueAsString() + " of " + getSuitAsString();
	}

}