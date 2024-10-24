import java.util.Scanner;

public class Game {
    private GameBoard board;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void startGame(int width, int height, int mines) {
        this.board = new GameBoard(width, height, mines);
        System.out.println("Game started!");

        while (true) {
            board.showBoard();
            System.out.println("\nEnter your move (e.g., 'A 5' for column A, row 5):");
            // Get player input - column as letter, row as number
            String column = scanner.next().toUpperCase();
            int row = scanner.nextInt();

            boolean isAlive = makeMove(column, row);
            if (!isAlive) {
                System.out.println("Game Over! You hit a mine!");
                board.showFullBoard();
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }

    private boolean makeMove(String column, int row) {
        try {
            int x = column.charAt(0) - 'A';     // Convert column letter to array index (A=0, B=1, etc.)
            return board.revealCell(x, row);
        } catch (Exception e) {
            scanner.nextLine(); // Clear scanner buffer
            return true; // Don't end game on invalid input
        }
    }
}