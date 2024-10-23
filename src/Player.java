import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private String name, time, level;
    ArrayList<Player> highScore = new ArrayList<>();


    public Player() {
    }

    public Player(String name, String time, String level) {
        this.name = name;
        this.time = time;
        this.level = level;
    }


    public void readHighScore() throws IOException {

        //make stream from file
        var input = new BufferedReader(new FileReader("src/Highscore.txt"));

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

    public void printHighScore() throws IOException {

        readHighScore();

        List<Player> easyLevel = highScore.stream()                             //make a list of all Easy players
                .filter(player -> "Easy".equals(player.getLevel()))          // use java stream to sort those out
                .toList();

        List<Player> mediumLevel = highScore.stream()                           //make a list of all level Medium Players
                .filter(player -> "Medium".equals(player.getLevel())).toList();

        List<Player> hardLevel = highScore.stream()                          //make a list of all level hard Players
                .filter(player -> "Hard".equals(player.getLevel())).toList();


        /* Print to consol the top 10 of each level */

        System.out.println("******* HARD *********");
        for(int i = 0; i < hardLevel.size(); i++)
            System.out.println(i + ". "+ hardLevel.get(i).getName() + " " + hardLevel.get(i).getTime());

        System.out.println("******* MEDIUM *********");
        for(int i = 0; i < mediumLevel.size(); i++)
            System.out.println(i + ". "+ mediumLevel.get(i).getName() + " " + mediumLevel.get(i).getTime());

        System.out.println("******* EASY *********");
        for(int i = 0; i < easyLevel.size(); i++)
            System.out.println(i + ". "+ easyLevel.get(i).getName() + " " + easyLevel.get(i).getTime());



        /*for (Player player : hardLevel) {                                       //Todo endast för test, Tas bort
            System.out.println(player.getName() + " " + player.getLevel());
        }*/


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
}










