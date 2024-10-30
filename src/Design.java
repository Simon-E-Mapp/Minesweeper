public class Design {

    //Colors used in the menu and printed text
    public static final String RESET_TEXT = "\033[0m";
    public static final String BLUE_BOLD = "\033[1;94m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String ITALICS = "\033[3m";
    public static final String WHITE_BOLD = "\033[1;97m";
    public static final String RED_UNDERLINE = "\033[4;31m";
    public static final String GREEN_BOLD = "\033[1;92m";;

    //Colors used on the game board
    public static final String RESET = "\u001B[0m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String[] NUMBER_COLORS = {
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
}
