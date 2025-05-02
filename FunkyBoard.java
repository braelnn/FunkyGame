package Funky_Game;

public class FunkyBoard {
    
    private int size; // This defines the size of the board in all dimensions
    private FunkyToken[][] grid; // 2D array to represent the board with respective tokens

    // Constructor: establishes the board with the board size but in an empty grid
    public FunkyBoard(int size) {
        this.size = size;
        grid = new FunkyToken[size][size];
    }

    // Returns the board size
    public int getSize() {
        return size;
    }

    // confirms if the position is in the range of the board
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public void placeToken(FunkyToken token, int newRow, int newCol) {
        // Remove token from its previous position
        if (grid[token.row][token.col] == token) {
            grid[token.row][token.col] = null;
        }

        // If target spot has another token, eat the token. 
        if (grid[newRow][newCol] != null) {
            grid[newRow][newCol].active = false;
        }

        // Update token's new position after deactivating the previous token
        token.col = newCol;
        token.row = newRow;
        grid[newRow][newCol] = token; // Place token on new spot
    }

    // Checks the whole board and return the overall winner as the active token.
    public FunkyToken getWinner() {
        FunkyToken winner = null;
        int count = 0;
        for (FunkyToken[] row : grid) {
            for (FunkyToken t : row) {
                if (t != null && t.active) {
                    winner = t;
                    count++;
                }
            }
        }
        return count == 1 ? winner : null; // Return winner if only one token is left on the board
    }

    // Displays for the user the current board state 
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null && grid[i][j].active) {
                    System.out.print(grid[i][j].token + " "); // display token symbol
                } else {
                    System.out.print("- "); // Empty space
                }
            }
            System.out.println(); 
        }
        System.out.println(); 
    }
}
