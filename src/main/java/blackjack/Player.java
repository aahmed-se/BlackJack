package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int aceCount;
    final List<Card> cards;
    final String name;

    public Player(String name){
        this.name = name;
        aceCount = 0;
        cards = new ArrayList<>();
    }

    public void addCard(Card c){
        cards.add(c);
        if(c.getValue() == Card.Ranks.ACE){
            aceCount++;

        }
    }

    public boolean checkIfBusted(){
        if(this.getScore() > Blackjack.WINNING_SCORE){
            return true;
        }
        return false;
    }

    public boolean checkIfWon(){
        if(this.getScore() == Blackjack.WINNING_SCORE){
            return true;
        }
        return false;
    }

    public int getScore(){

        int points = 0;
        int aceAdjustedPoints = 0;
        for(Card card : this.cards){
            points += card.getPointValue();
            aceAdjustedPoints += card.getPointValue();
        }

        if(aceCount > 0){
            aceAdjustedPoints -= 10 * aceCount;
            int closest = points;
            if(Math.abs(closest - Blackjack.WINNING_SCORE) > Math.abs(aceAdjustedPoints - Blackjack.WINNING_SCORE)){
                return aceAdjustedPoints;
            }
        }

        System.out.println("Debug :: current points for player : " + this.name + " : " + points);

        return points;
    }

}
