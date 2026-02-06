package Celebrity_Game;

import java.util.Scanner;

public class CelebrityGameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // starting setup
        System.out.println(); 
        System.out.println("Welcome to the Celebrity Game!"); 
        System.out.println("--------------------------------"); 
        
        System.out.println("Please enter Player 1's name: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.println("Please enter Player 2's name: ");
        Player player2 = new Player(scanner.nextLine());

        System.out.println("How many rounds would you like to play? (Suggested: 3)");
        int rounds = scanner.nextInt();

        Game game = new Game();
        game.playGame(player1, player2, rounds);
        game.endGame();
        scanner.close();
    }
}
