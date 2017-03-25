package blackjack;

public class Blackjack {

    public static final int WINNING_SCORE = 21;
    private final Deck deck;
    private final MoveGen generator;
    private final Player player1;
    private final Player player2;
    private int numOfRounds;

    public enum Move {
        HIT,
        STAY
    }

    public Blackjack(MoveGen generator, int numOfRounds) {
        this.generator = generator;
        this.numOfRounds = numOfRounds;

        System.out.println("Welcome to blackjack.");
        System.out.println("Num of rounds to be played = " + this.numOfRounds);

        player1 = new Player("player1");
        player2 = new Player("player2");

        deck = new Deck();
        deck.shuffle();

        System.out.println("Get two cards for player 1");

        player1.addCard(deck.drawCard());
        player1.addCard(deck.drawCard());

        System.out.println("Get two cards for player 2");

        player2.addCard(deck.drawCard());
        player2.addCard(deck.drawCard());

	}

	public void runGame(){

        boolean moveSwitch = true;

        int roundCount = 1;
        boolean gameWasWon = false;
        System.out.println("Starting Round num : " + roundCount);
        while (!player1.checkIfWon() && !player2.checkIfWon() && !player1.checkIfBusted() && !player2.checkIfBusted() && roundCount <= this.numOfRounds) {
            if(moveSwitch){
                System.out.println("blackjack.Player 1 Move");
            } else {
                System.out.println("blackjack.Player 2 Move");

            }

            Move move = generator.getNextMove();

            if(move == Move.HIT){
                if(moveSwitch) {
                    player1.addCard(deck.drawCard());
                }
                else{
                    player2.addCard(deck.drawCard());
                }
            }

            moveSwitch = !moveSwitch;
            if(moveSwitch){
                roundCount++;
                System.out.println("Starting Round num : " + roundCount);
            }
        }


        if(player1.checkIfWon()){
            System.out.println("blackjack.Player 1 was won has exact points");
        }else if(player2.checkIfWon()){
            System.out.println("blackjack.Player 2 was won has exact points");
        }else if(player1.checkIfBusted()){
            System.out.println("blackjack.Player 2 was won other player was busted");
        }else if(player2.checkIfBusted()){
            System.out.println("blackjack.Player 1 was won other player was busted");
        } else{
            int player1RelativeScore = player1.getScore();
            int player2RelativeScore = player2.getScore();
            if(player1RelativeScore == player2RelativeScore){
                System.out.println("No Winner , Score is same draw");
            }
            if(Math.abs(player1RelativeScore - Blackjack.WINNING_SCORE) > Math.abs(player2RelativeScore - Blackjack.WINNING_SCORE)){
                System.out.println("blackjack.Player 2 wins , Score is closer");
            }
            else{
                System.out.println("blackjack.Player 1 wins , Score is closer");
            }
        }

        System.out.println("Game is Finished");
    }

}