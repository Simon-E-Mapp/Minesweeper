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

    //prints out
    public void showBoard() {
        System.out.print(" |");
        for (int x = 0; x < width; x++) {
            System.out.print(x + "|");
        }
        System.out.println();
        for (int y = 0; y < height; y++) {
            System.out.print(y + "|");
            for (int x = 0; x < width; x++) {
                System.out.print("+|");
            }
            System.out.println();
        }
    }

    //print out all cells visible
    public void showFullBoard() {
        System.out.print(" |");
        for (int x = 0; x < width; x++) {
            System.out.print(x + "|");
        }
        System.out.println();

        for (int y = 0; y < height; y++) {
            System.out.print(y + "|");
            for (int x = 0; x < width; x++) {
                Cell cell = board[x][y];
                if (cell.isMine()) {
                    System.out.print("*|");
                } else {
                    System.out.print("0|");
                }
            }
            System.out.println();
        }
    }

}
