package Celebrity_Game;

public class Celebrity {
    String myName; 
    String myHint; 
    boolean myRevealedYet;

    public Celebrity(){
        myName = "";
        myHint = "";
        myRevealedYet = false;
    }

    public Celebrity(String name, String hint){
        myName = name;
        myHint = hint;
        myRevealedYet = false;
    }
    
    public String getClue() {
        return myHint;
    }

    public String getName() {
        return myName;
    }

    public String toString() {
        return "Name: " + myName + "\nHint: " + myHint;
    }

    public void setName(String name) {
        myName = name;
    }

    public void setHint(String hint) {
        myHint = hint; 
    }

    public void setMyRevealedYet(boolean revealedYet) {
        myRevealedYet = revealedYet;
    }

}
