package Funky_Game;

// This is an abstract class representing the game token to be manipulated 
public abstract class FunkyToken {
    protected int row, col;          // This shows the current column and row of the token 
    protected boolean active;        // Indicates if the token is still in the game
    protected char token;            // Uses a symbol to represent the given tokens that is &, $, @


    public FunkyToken(char token) {
        this.token = token;
        this.active = true;
    }

    public abstract void move(FunkyBoard board);
}

