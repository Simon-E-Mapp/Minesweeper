import java.util.Random;

public class GameBoard {
    private Cell[][] board;
    private int width;
    private int height;
    private int mines;

    public GameBoard(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.board = new Cell[width][height];
        fillBoard();
    }

    public void fillBoard() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = new Cell();
            }
        }
        placeMines();
    }

    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < mines) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (!board[x][y].isMine()) {
                board[x][y].setMine(true);
                placedMines++;
            }
        }
    }

    public boolean revealCell(int x, int y) {
        if (!isValidMove(x, y)) {
            System.out.println("Invalid move! Please try again.");
            return true;
        }

        Cell cell = board[x][y];
        // Check if player hit a mine
        if (cell.isMine()) {
            cell.show();  // Reveal the mine
            return false;
        }
        // Calculate and display the number of adjacent mines
        int count = countAdjacentMines(x, y);
        cell.show();
        cell.setNearbyMines(count);
        return true;
    }
    // Check if the coordinates are within board boundaries
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private int countAdjacentMines(int x, int y) {
        int count = 0;
        // Check all 8 surrounding cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int adjacentX = x + i;
                int adjacentY = y + j;
                // If adjacent cell is valid and contains a mine, increment counter
                if (isValidMove(adjacentX, adjacentY) && board[adjacentX][adjacentY].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void showBoard() {
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (board[x][y].isVisible()) {
                    if (board[x][y].isMine()) {
                        System.out.print("*|");
                    } else {
                        System.out.print(board[x][y].getNearbyMines() + "|");
                    }
                } else {
                    System.out.print("+|");
                }
            }
            System.out.print(" " + y);  // prints out row number to the right
            System.out.println();
        }
        System.out.print(" ");
        for (int x = 0; x < width; x++) {
            char columnLabel = (char) ('A' + x); // convert the number to char
            System.out.print(columnLabel + " "); // prints the column number
        }
        System.out.println();
    }

    //print out all cells visible
    public void showFullBoard() {
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                Cell cell = board[x][y];
                if (cell.isMine()) {
                    System.out.print("*|");
                } else {
                    System.out.print(countAdjacentMines(x, y) + "|");
                }
            }
            System.out.print(" " + y);
            System.out.println();
        }
        System.out.print(" ");
        for (int x = 0; x < width; x++) {
            char columnLabel = (char) ('A' + x);
            System.out.print(columnLabel + " ");
        }
        System.out.println();
    }
}