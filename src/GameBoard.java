import java.util.Random;

public class GameBoard {
    private Cell[][] board;
    private int width;
    private int height;
    private int mines;
    private boolean isGameOver = false;

    public GameBoard(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.board = new Cell[width][height];
        fillBoard();
    }
    public boolean isGameWon(){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (!board[x][y].isMine() && !board[x][y].isVisible()){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isGameOver() {
        return isGameOver;
    }

    public void fillBoard(){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
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

    //prints out board
    public void showBoard() {
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                System.out.print("+|"); // hidden cells shows as "+"
            }
            System.out.print(" " + y); // prints out row number to the right
            System.out.println();
        }

        // prints out column number under the board
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
                    System.out.print("0|");
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
