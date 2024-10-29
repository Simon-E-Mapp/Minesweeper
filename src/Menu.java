import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    boolean menuOpen = true;
    int input = -1;
    Player player = new Player();

    Game game;
    private int currentWidth = 10;
    private int currentHeight = 10;
    private int currentMines = 10;

    // Constructor:
    public Menu() throws IOException {
        this.game = new Game();
        displayMenu();
    }

    // displayMenu method
    private void displayMenu() throws IOException {
        do {
            // Prints the banner
            System.out.print("\033[1;94m");
            System.out.println("\n==========|| MAIN MENU ||=========");
            System.out.println("__________________________________");
            System.out.print("\033[0m");

            System.out.println("\033[3mPlease select an option from 1-4:\n\033[0m");

            // Prints Main Menu options
            System.out.print("\033[1;97m");
            System.out.println("1) Start Game");
            System.out.println("2) Change Difficulty");
            System.out.println("3) Print high-score");
            System.out.println("4) Exit Game");
            System.out.print("\n\033[0m");

            // Takes input from player
            input = getPlayerInt();

            switch (input) {

                // GAME START
                case 1:
                    System.out.println("Please enter your name.");
                    player.setName(getPlayerName());

                    // Call game method from the Game class to start game?
                    game.startGame(currentWidth, currentHeight, currentMines, player);
                    break;

                // DIFFICULTY SUBMENU
                case 2:
                    boolean subMenuOpen = true;

                    do {
                        // Write out which difficulty they are on currently somehow
                        System.out.println("\033[3mYour difficulty is currently set to:\n\033[0m");
                        System.out.println("\033[3mPlease select one of following options:\n\033[0m");

                        System.out.print("\033[1;97m");
                        System.out.println("1) Easy");
                        System.out.println("2) Medium");
                        System.out.println("3) Hard");
                        System.out.println("4) Go Back");
                        System.out.print("\n\033[0m");

                        input = getPlayerInt();

                        switch (input) {
                            case 1:
                                // Set game to easy difficulty
                                System.out.println("\033[3mDifficulty set to Easy\n\033[0m");
                                currentWidth = 5;
                                currentHeight = 5;
                                currentMines = 5;
                                subMenuOpen = false;
                                player.setLevel("Easy");   //Da added 28/10
                                break;

                            case 2:
                                // Set game to medium difficulty
                                System.out.println("\033[3mDifficulty set to Medium\n\033[0m");
                                currentWidth = 10;
                                currentHeight = 10;
                                currentMines = 20;
                                subMenuOpen = false;
                                player.setLevel("Medium");  //Da added 28/10
                                break;

                            case 3:
                                // Set game to hard difficulty
                                System.out.println("\033[3mDifficulty set to Hard\n\033[0m");
                                currentWidth = 15;
                                currentHeight = 15;
                                currentMines = 45;
                                subMenuOpen = false;
                                player.setLevel("Hard"); //Da added 28/10
                                break;

                            // Goes back to the main menu
                            case 4:
                                subMenuOpen = false;
                                break;

                            // Displays error message
                            default:
                                System.out.println("Please select a number between 1-4");
                                sc.nextLine();
                        }
                    } while (subMenuOpen);
                    break;

                // HIGHSCORE
                case 3:
                    try {
                        new Player().printHighScore();
                    } catch (Exception e) {
                        System.out.println("There was an error in fetching the high-scores.");
                    }
                    break;

                // EXIT
                case 4:
                    menuOpen = false;
                    sc.close();
                    break;

                // ERROR MESSAGE
                default:
                    System.out.println("Please enter a number between 1-4");
                    sc.nextLine();
            }
        } while (menuOpen);
    }

    // Handles Integers
    private int getPlayerInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a number between 1-4");
            sc.nextLine();
        }
        int playerInt = sc.nextInt();
        sc.nextLine();
        return playerInt;
    }

    //Handles different strings
    //TODO add more functionality beyond "getplayername"
    private String getPlayerName() {
        String playerName = sc.nextLine();
        System.out.println("Hi, " + playerName + "!");
        return playerName;
    }


}