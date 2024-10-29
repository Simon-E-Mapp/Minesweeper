import java.util.Scanner;

public class InputHandler {
    private static Scanner sc = new Scanner(System.in);
    Player player = new Player();

    // Handles Integers in the Menu
    public static int getPlayerInt() {
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
    public static String getPlayerName() {
        String playerName = sc.nextLine();
        System.out.println("Hi, " + playerName + "!");
        return playerName;
    }

    public static void printHighScore() {
        try {
            new Player().printHighScore();
        } catch (Exception e) {
            System.out.println("There was an error in fetching the high-scores.");
        }
    }


}
