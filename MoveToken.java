package Funky_Game;

import java.util.Random;

public class MoveToken extends FunkyToken {

    // This is meant to call the superclass constructor in order to set token symbol
    public MoveToken(char token) {
        super(token);
    }

    // establishes the move action for MoveToken 
    @Override
    public void move(FunkyBoard board) {
        // Jump movement if the token is deactivated
        if (!active) return;

        Random rand = new Random();

        // This represents all arrays for all intented directions that is down, left, up, right and diagonals
        int[][] directions = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, // diagonals
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}   // up, down, left, right
        };

        // This tries random directions until an ultimate move is found
        while (true) {
            int[] dir = directions[rand.nextInt(directions.length)];
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // If new position is within board limits, move there
            if (board.isInBounds(newRow, newCol)) {
                board.placeToken(this, newRow, newCol);
                break; 
            }
        }
    }
}
