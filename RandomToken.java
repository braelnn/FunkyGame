package Funky_Game;

import java.util.Random;

public class RandomToken extends FunkyToken {
    public RandomToken(char token) {
        super(token);
    }

    @Override
    public void move(FunkyBoard board) {
        if (!active) return;

        Random rand = new Random();
        int newRow, newCol;

        do {
            newRow = rand.nextInt(board.getSize());
            newCol = rand.nextInt(board.getSize());
        } while (newRow == row && newCol == col); // Avoid jumping to same spot

        board.placeToken(this, newRow, newCol);
    }
}
