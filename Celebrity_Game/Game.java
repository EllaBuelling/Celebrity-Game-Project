package Celebrity_Game;
import java.util.Scanner;

public class Game {
    private int roundNumber; 
    private int maxRounds; 
    private Player winner; 
    private Player loser;
    private Celebrity currentCelebrity;
    private int celebritiesRevealed;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Celebrity RyanCoogler;
    private Celebrity BenicioDelToro;
    private Celebrity TimotheeChalame;
    private Celebrity KateHudson;
    private Celebrity ChloeZhao;
    private Celebrity JacobElordi;



    public Game() {
        this.roundNumber = 0;
        this.winner = null;
        this.celebritiesRevealed = 0;

        RyanCoogler = new Celebrity("Ryan Coogler", "Who directed Sinners?");
        BenicioDelToro = new Celebrity("BenicioDelToro", "Who is a supporting actor in One Battle After Another?");
        TimotheeChalame = new Celebrity("Timothee Chalame", "Who is the leading actor in Marty Supreme?");
        KateHudson = new Celebrity("Kate Hudson", "Who is the leading actress in Song Sung Blue?");
        ChloeZhao = new Celebrity("Chloe Zhao", "Who is the director of Hamnet?");
        JacobElordi = new Celebrity("Jacob Elordi", "Who is the supporting actor in Frankenstein?");
    }

    public void playGame(Player player1, Player player2, int maxRounds) {
        this.maxRounds = maxRounds;
        this.player1 = player1;
        this.player2 = player2;
        for (int i = 0; i < maxRounds; i++) {
            playRound();
        }

        if (player1.getScore() > player2.getScore()) {
            winner = player1;
            loser = player2;
        } else if (player2.getScore() > player1.getScore()) {
            winner = player2;
            loser = player1;
        } else {
            winner = null; // It's a tie
        }
    }

    public void endGame() {
        if (winner != null) {
            System.out.println("The winner is " + winner.getName());
            System.out.println("Final Score: " + winner.getScore() + " - " + loser.getScore());
        } else {
            System.out.println("The game ended in a tie!");
        }

        System.out.println(); 
        System.out.println("Thanks for playing!");

        System.exit(0); 
    }

    public void determineStartingPlayer(Player player1, Player player2) {
        double result = Math.random();
        if (result < 0.5) {
            this.currentPlayer = player1;
        } else {
            this.currentPlayer = player2;
        }
    }

    public void resetRoundData() {
        this.currentCelebrity = null;
        this.celebritiesRevealed = 0;
    }

    public void playRound() {
        roundNumber++;
        System.out.println(); 
        System.out.println("--------------------------------");
        System.out.println("Starting Round " + roundNumber);
        this.determineStartingPlayer(player1, player2);

        while ( celebritiesRevealed < 6 ) {
            System.out.println(currentPlayer.getName() + " revealed a celebrity!");

            // choosing a random unrevealed celebrity
            Celebrity[] celebrities = {RyanCoogler, BenicioDelToro, TimotheeChalame, KateHudson, ChloeZhao, JacobElordi};
            Celebrity chosenCelebrity = celebrities[(int)(Math.random() * celebrities.length)];
            while (chosenCelebrity.myRevealedYet) {
                chosenCelebrity = celebrities[(int)(Math.random() * celebrities.length)];
            }
            this.currentCelebrity = chosenCelebrity;
            chosenCelebrity.setMyRevealedYet(true);
            celebritiesRevealed++;

            System.out.println("Here is the celebrity. Don't reveal this to your team.");
            System.out.println("Celebrity: " + currentCelebrity.getName());
            System.out.println("Do you need a hint? (y/n)"); 
            Scanner scanner = new Scanner(System.in);
            String hintResponse = scanner.nextLine();
            if (hintResponse.equalsIgnoreCase("y")) {
                System.out.println("Hint: " + currentCelebrity.getClue());
            } else if (hintResponse.equalsIgnoreCase("n")) {
                System.out.println("No hint will be provided.");
            } else {
                System.out.println("Invalid input. No hint will be provided.");
            }

            System.out.println(currentPlayer.getName() + ", please enter your guess for the celebrity's name:");
            String playerGuess = scanner.nextLine();
            if (playerGuess.equalsIgnoreCase(currentCelebrity.getName())) {
                System.out.println("Correct! " + currentPlayer.getName() + " earns a point.");
                currentPlayer.incrementScore();
            } else {
                System.out.println("Incorrect. The correct answer was: " + currentCelebrity.getName());
            }

            // Switch turns
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        resetRoundData();
    }
}
