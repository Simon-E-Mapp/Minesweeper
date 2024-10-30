import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    boolean menuOpen = true;
    int input = -1;
    Player player = new Player();

    //Menu handles board size
    Game game;
    private int currentWidth = 10;
    private int currentHeight = 10;
    private int currentMines = 10;

    public Menu() throws IOException {
        this.game = new Game();
        displayMenu();
    }

    // displayMenu method
    private void displayMenu() throws IOException {
        do {
            // Prints the banner
            System.out.print(Design.BLUE_BOLD);
            System.out.println("\n==========|| MAIN MENU ||=========");
            System.out.println("__________________________________");
            System.out.print(Design.RESET_TEXT);

            System.out.println(Design.ITALICS + "\nPlease select an option from 1-4:\n" + Design.RESET_TEXT);

            // Prints Main Menu options
            System.out.print(Design.WHITE_BOLD);
            System.out.println("1) Start Game");
            System.out.println("2) Change Difficulty");
            System.out.println("3) Print high-score");
            System.out.println("4) Exit Game");
            System.out.print(Design.RESET_TEXT);

            // Takes input from player
            input = InputHandler.getPlayerInt();

            switch (input) {

                // GAME START
                case 1:
                    System.out.println(Design.ITALICS + "\nPlease enter your name." + Design.RESET_TEXT);
                    player.setName(InputHandler.getPlayerName());

                    game.startGame(currentWidth, currentHeight, currentMines, player);
                    break;

                // DIFFICULTY SUBMENU
                case 2:
                    boolean subMenuOpen = true;

                    do {
                        // Write out which difficulty they are on currently somehow
                        System.out.println(Design.ITALICS + "\nPlease select one of following options:\n"
                                + Design.RESET_TEXT);

                        System.out.print(Design.WHITE_BOLD);
                        System.out.println("1) Easy");
                        System.out.println("2) Medium");
                        System.out.println("3) Hard");
                        System.out.println("4) Go Back");
                        System.out.print(Design.RESET_TEXT);

                        input = InputHandler.getPlayerInt();

                        switch (input) {
                            case 1:
                                // Set game to easy difficulty
                                System.out.println("\nDifficulty set to Easy\n");
                                currentWidth = 5;
                                currentHeight = 5;
                                currentMines = 5;
                                subMenuOpen = false;
                                player.setLevel("Easy");
                                break;

                            case 2:
                                // Set game to medium difficulty
                                System.out.println("\nDifficulty set to Medium\n");
                                currentWidth = 10;
                                currentHeight = 10;
                                currentMines = 20;
                                subMenuOpen = false;
                                player.setLevel("Medium");
                                break;

                            case 3:
                                // Set game to hard difficulty
                                System.out.println("\nDifficulty set to Hard\n");
                                currentWidth = 15;
                                currentHeight = 15;
                                currentMines = 45;
                                subMenuOpen = false;
                                player.setLevel("Hard");
                                break;

                            // Goes back to the main menu
                            case 4:
                                subMenuOpen = false;
                                break;

                            // Displays error message
                            default:
                                System.out.println(Design.RED_BOLD+"Please select a number between 1-4"+Design.RESET_TEXT);
                        }
                    } while (subMenuOpen);
                    break;

                // HIGHSCORE
                case 3:
                    printHighScore();
                    break;

                // EXIT
                case 4:
                    menuOpen = false;
                    sc.close();
                    break;

                // ERROR MESSAGE
                default:
                    System.out.println(Design.RED_BOLD + "Please enter a number between 1-4" + Design.RESET_TEXT);

            }
        } while (menuOpen);
    }

    private void printHighScore() {
        try {
            new Player().printHighScore();
        } catch (Exception e) {
            System.out.println(Design.RED_BOLD + "There was an error in fetching the high-scores." + Design.RESET_TEXT);
        }
    }


}