package Celebrity_Game;

import java.util.Scanner;

public class CelebrityGameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean customGame = false;
        boolean team;
        Celebrity [] celebrityList = new Celebrity[6];
        
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

        System.out.println("Which game mode would you like to play? \n 1. Two players \n 2. Two teams");
        int result = scanner.nextInt();
        if(result == 1) {
            team = false;
        } else {
            team = true;
        }

        System.out.println("Which game type would you like to play? \n 1. Choose our own celebrities and hints \n 2. Random celebrities and hints");
        int gameType = scanner.nextInt();

        if(gameType == 1){
            customGame = true;
            scanner.nextLine(); 
            for(int i = 0; i<=5; i++){
                celebrityList[i] = new Celebrity();
                if(i%2 != 0){
                    System.out.println(player1.getName() + ", enter a celebrity name.");
                    celebrityList[i].setName(scanner.nextLine());
                    System.out.println(player1.getName() + ", enter a hint for " + celebrityList[i].getName());
                    celebrityList[i].setHint(scanner.nextLine());
                }
                if(i%2 == 0){
                    System.out.println(player2.getName() + ", enter a celebrity name.");
                    celebrityList[i].setName(scanner.nextLine());
                    System.out.println(player2.getName() + ", enter a hint for " + celebrityList[i].getName());
                    celebrityList[i].setHint(scanner.nextLine());
                }
            } 
        }

        if(gameType == 2){
            customGame = false;
        }

        Game game = new Game(customGame, celebrityList, team);
        game.playGame(player1, player2, rounds);
        game.endGame();
        scanner.close();
    }
}
