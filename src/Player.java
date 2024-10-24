import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Player {

    private String name, level;
    private long time;

    ArrayList<Player> highScore = new ArrayList<>();


    public Player() {
    }

    public Player(String name, long time, String level) {
        this.name = name;
        this.time = time;
        this.level = level;
    }

    /**
     * the method writes to the file highscore.txt
     *
     * @param player object of type Player
     * @throws IOException
     */
    public void writeToHighscore(Player player) throws IOException {

        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("src/Highscore.txt", true)));    //true om vi beålla data i filen

        output.println(player.getName());
        output.println(player.getTime());
        output.println(player.getLevel());

        output.close();

    }

    /**
     * the method reads data from the file Higjscore.txt and
     * saves the information in the highscore list
     * @throws IOException
     */
    public void readHighScore() throws IOException {

        //make stream from file
        BufferedReader input = new BufferedReader(new FileReader("src/Highscore.txt"));

        //read file
        while (true) {
            String name = input.readLine();
            if (name == null)        //end of file??
                break;
            String time = input.readLine();
            String level = input.readLine();

            highScore.add(new Player(name, time, level));
        }
    }

    /**
     * Prints the top 10 of all levels on the console
     *
     * @throws IOException
     */
    public void printHighScore() throws IOException {

        readHighScore();

        List<Player> easyLevel = highScore.stream()                             //make a list of all Easy players
                .filter(player -> "Easy".equals(player.getLevel()))          // use java stream to sort those out
                .toList();

        List<Player> mediumLevel = highScore.stream()                           //make a list of all level Medium Players
                .filter(player -> "Medium".equals(player.getLevel())).toList();

        List<Player> hardLevel = highScore.stream()                          //make a list of all level hard Players
                .filter(player -> "Hard".equals(player.getLevel())).toList();

        //TODO method that will sort the high score


        System.out.println("******* HARD *********");
        for(int i = 0; i < hardLevel.size(); i++)
            System.out.println(i + ". "+ hardLevel.get(i).getName() + " " + hardLevel.get(i).getTime());

        System.out.println("******* MEDIUM *********");
        for(int i = 0; i < mediumLevel.size(); i++)
            System.out.println(i + ". "+ mediumLevel.get(i).getName() + " " + mediumLevel.get(i).getTime());

        System.out.println("******* EASY *********");
        for(int i = 0; i < easyLevel.size(); i++)
            System.out.println(i + ". "+ easyLevel.get(i).getName() + " " + easyLevel.get(i).getTime());

    }


    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}










