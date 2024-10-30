import java.util.Scanner;

public class InputHandler {
    private static Scanner sc = new Scanner(System.in);

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

    //Handles strings in the menu
    public static String getPlayerName() {
        String playerName = sc.nextLine();
        System.out.println("Hi, " + playerName + "!");
        return playerName;
    }

}
