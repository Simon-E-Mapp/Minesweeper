import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    GameBoard board;
    public void startGame(int width, int height, int mines){
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                board = new GameBoard(5, 5, 5); // easy
                break;
            case 2:
                board = new GameBoard(10, 10, 10); // medium
                break;
            case 3:
                board = new GameBoard(15, 15, 15); // hard
                break;
            default:{
                board = new GameBoard(5, 5, 5); // easy
            }
        }board.showBoard();
    }
}
