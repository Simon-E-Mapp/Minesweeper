import java.util.Random;
public class Board {
    private Cell[][] cells;
    private int rows;
    private int columns;
    private int numMines;

    public Board(int rows, int columns, int numMines) {
        this.rows = rows;
        this.columns = columns;
        this.numMines = numMines;
        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
        placeMines();
    }

    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(columns);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    public void printBoard() {
        // Print column numbers
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print rows
        for (int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < columns; j++) {
                System.out.print(". ");
            }
            System.out.println();
        }
    }

    public void printBoardAndMines() {
        // Print column numbers
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print rows
        for (int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < columns; j++) {
                if (cells[i][j].isMine()) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}


