import java.io.IOException;
import java.util.Scanner;

public class Game {
    private GameBoard board;
    private Scanner scanner;

    private long time;


    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void startGame(int width, int height, int mines, Player player) throws IOException {
        this.board = new GameBoard(width, height, mines);
        System.out.println("Game started!");

        long startTime = System.currentTimeMillis();

        while (true) {
            board.showBoard();
            // add board.showFullBoard(); for easier troubleshooting.
            System.out.println("\nEnter your move (e.g., 'A 5' for column A, row 5):");
            // Get player input - column as letter, row as number
            try {
                String column = scanner.next().toUpperCase();
                int row = scanner.nextInt();

                boolean isAlive = makeMove(column, row);
                if (!isAlive) {
                    board.showFullBoard();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid move! Please use format 'A 5'");
                scanner.nextLine(); // Clear scanner buffer
            }
        }
        System.out.println("Thanks for playing!");

        long endTime = System.currentTimeMillis();
        time = (endTime - startTime);

        if (board.isGameWon()) {
            try {
                player.writeToHighscore(player, time);
            } catch (IOException e) {
                System.out.println("Couldn't save high score!");
            }

        }
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