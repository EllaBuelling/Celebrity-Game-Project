package Celebrity_Game;

public class Player {
    private String name;
    private int score;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    public Player() {
        this.name = "";
        this.score = 0;
    }

    public String getName() {return name;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public void incrementScore() {this.score++;}
}
