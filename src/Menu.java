import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    boolean menuOpen = true;
    int input = -1;

    // Constructor:
    public Menu(){
        displayMenu();
    }

    /*Call Player class to create a new player object??
    Player playerName = new Player();*/

    // displayMenu method
    private void displayMenu() {
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
            System.out.println("3) Print Highscore");
            System.out.println("4) Exit Game");
            System.out.print("\n\033[0m");

            // Takes input from player
            input = getPlayerInt();

            switch (input) {

                // GAME START
                case 1:
                    /*if playerName = ""{
                        make a new player. Player class yadda yadda.
                    }
                    */

                    // Call game method from the Game class to start game?
                    continue;

                    // DIFFICULTY SUBMENU
                case 2:
                    // ??call settings from within another class?
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

                        input = sc.nextInt();
                        switch (input) {
                            case 1:
                                // Set game to easy difficulty
                                System.out.println("\033[3mDifficulty set to Easy\n\033[0m");
                                subMenuOpen = false;
                                break;
                            case 2:
                                // Set game to medium difficulty
                                System.out.println("\033[3mDifficulty set to Medium\n\033[0m");
                                subMenuOpen = false;
                                break;
                            case 3:
                                // Set game to hard difficulty
                                System.out.println("\033[3mDifficulty set to Hard\n\033[0m");
                                subMenuOpen = false;
                                break;

                            // Goes back to the main menu
                            case 4:
                                subMenuOpen = false;
                                break;

                            // Displays error message
                            default:
                                System.out.println("Please select a number between 1-4");
                                // Clears the scanner and waits for the player to press a key before going back
                                sc.nextLine();
//                                continue;
                        }
                    } while (subMenuOpen);


                    // HIGHSCORE
                case 3:
                    // Get highscore from inside player class?
                    continue;

                    // EXIT
                case 4:
                    menuOpen = false;
                    //closes the scanner, not sure if necessary?:
                    sc.close();
                    break;

                // ERROR MESSAGE
                default:
                    System.out.println("Please enter a number between 1-4");
                    sc.nextLine();
//                    continue;
            }
        } while (menuOpen);
    }

    // Prevents crashes if the player enters anything but an integer
    public int getPlayerInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a number between 1-4");
            sc.nextLine();
        }
        int playerInt = sc.nextInt();
        sc.nextLine();
        return playerInt;
    }
}