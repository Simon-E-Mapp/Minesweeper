import java.util.Random;

public class GameBoard {
    private Cell[][] board;
    private int width;
    private int height;
    private int mines;

    private static final String RESET = "\u001B[0m";
    private static final String RED_BACKGROUND = "\u001B[41m";
    private static final String[] NUMBER_COLORS = {
            "\u001B[97m",  // WHITE for 0
            "\u001B[34m",  // BLUE for 1
            "\u001B[32m",  // GREEN for 2
            "\u001B[31m",  // RED for 3
            "\u001B[35m",  // PURPLE for 4
            "\u001B[33m",  // YELLOW for 5
            "\u001B[36m",  // CYAN for 6
            "\u001B[37m",  // WHITE for 7
            "\u001B[90m"   // GRAY for 8
    };

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

    public boolean revealCell(int x, int y) {
        if (!isValidMove(x, y)) {
            System.out.println("Invalid move! Please try again.");
            return true;
        }

        Cell cell = board[x][y];

        // Check if player hit a mine
        if (cell.isMine()) {
            cell.show();  // Reveal the mine
            System.out.println("Game Over! You hit a mine!");
            return false;
        }
        // Calculate and display the number of adjacent mines
        int count = countAdjacentMines(x, y);
        cell.show();
        cell.setNearbyMines(count);

        //if there is no nearbyMines start openAdjacentCells method
        if (count == 0){
            openAdjacentCells(x,y);
        }

        //Checking for win-condition
        if (isGameWon()) {
            System.out.println("Congratulations! You Won!");
            return false;
        }
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
    private void openAdjacentCells(int x, int y){
        //check all the surrounding cells
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                int adjacentX = x + i;
                int adjacentY = y + j;

                //if the move is within the board and the chosen cell is not already visible or a mine then continue
                if (isValidMove(adjacentX, adjacentY)){
                    Cell adjacentCell = board[adjacentX][adjacentY];
                    if (!adjacentCell.isVisible() && !adjacentCell.isMine()){
                        //get the value of the cell with countAdjacentMines and open the cell and set mines count
                        int adjacentCount = countAdjacentMines(adjacentX, adjacentY);
                        adjacentCell.show();
                        adjacentCell.setNearbyMines(adjacentCount);

                        //keep running the method if the newly opened cell is a 0
                        if (adjacentCount == 0){
                            openAdjacentCells(adjacentX, adjacentY);
                        }
                    }
                }
            }
        }
    }

    //Check for winning-conditions
    public boolean isGameWon(){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (!board[x][y].isMine() && !board[x][y].isVisible()){
                    return false; //if the cell is not a mine and not visible return false
                }
            }
        }
        return true; //if all cells have been checked and only cells containing a mine is hidden return true
    }

    public void showBoard() {
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (board[x][y].isVisible()) {
                    if (board[x][y].isMine()) {
                        System.out.print(RED_BACKGROUND + "*" + RESET + "|");
                    } else {
                        int mineCount = board[x][y].getNearbyMines();
                        System.out.print(NUMBER_COLORS[mineCount] + mineCount + RESET + "|");
                    }
                } else {
                    System.out.print("+|");
                }
            }
            System.out.print(" " + y);  // prints out row number to the right
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
                    System.out.print(RED_BACKGROUND + "*" + RESET + "|");
                } else {
                    int mineCount = countAdjacentMines(x, y);
                    System.out.print(NUMBER_COLORS[mineCount] + mineCount + RESET + "|");
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
