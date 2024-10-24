import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public void startGame(int width, int height, int mines){
        int input = scanner.nextInt();
        switch (input){
            case 1:
                GameBoard easy = new GameBoard(5, 5, 5);
                 break;
            case 2:
                GameBoard medium = new GameBoard(10, 10, 10);
                break;
            case 3:
                GameBoard hard = new GameBoard(15, 15, 15);
                break;
            default:{
                System.out.println("Invalid option");
            }
        }
    }
}
