package blackjack;

import java.util.Scanner;
import static java.lang.System.in;

public class Driver {

    static class ConsoleMoveGenerator implements MoveGen{

        final Scanner inputScanner = new Scanner(in);

        public Blackjack.Move getNextMove(){
            char entry = inputScanner.next().toLowerCase().charAt(0);

            switch (entry){
                case 'h' : return Blackjack.Move.HIT;
                case 's' : return Blackjack.Move.STAY;
                default: {
                    System.err.println("Error State : cannot parse move");
                    System.exit(-1);
                    return null;
                }
            }
        }
    }


    public static void main(String[] args){
        System.out.println(" *** Black Jack Simulator : Use key H for HIT and S for stay ***");
        int numOfRounds = 3;
        Blackjack blackjack =  new Blackjack(new ConsoleMoveGenerator(), numOfRounds);
        blackjack.runGame();
    }
}
