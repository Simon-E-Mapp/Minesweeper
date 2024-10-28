import java.io.*;
import java.util.*;


public class Player extends Game{

    private String name, level;
    private long time;

    ArrayList<Player> highScore = new ArrayList<>();


    public Player() {
    super();
    }

    public Player(String name,long time, String level) { //removed long time
        this.name = name;
       this.time = super.getTime();
        this.level = level;
    }

    /**
     * the method writes to the file highscore.txt
     *
     * @param player object of type Player
     * @throws IOException
     */
    // TODO writeToHighscore
    public void writeToHighscore(Player player, long time) throws IOException {

        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("src/Highscore.txt", true)));    //true om vi beålla data i filen

        output.println(player.getName());
        output.println(time);
        output.println(player.getLevel());

        output.close();

    }

    /**
     * the method reads data from the file Higjscore.txt and
     * saves the information in the highscore list
     *
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
            long time = Long.parseLong(input.readLine());
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



        //convert all highscore list to sorted list
        List<Player> sortedHardLevel = sortHighScoreList(hardLevel);
        List<Player> sortedMediumLevel = sortHighScoreList(mediumLevel);
        List<Player> sortedEasyLevel = sortHighScoreList(easyLevel);

        System.out.println("******* HARD *********");
        for (int i = 0; i < sortedHardLevel.size(); i++)
            System.out.println(1 + i + ". " + sortedHardLevel.get(i).getName() + " " + convertToHourMinSec(sortedHardLevel.get(i).getTime()));

        System.out.println("******* MEDIUM *********");
        for (int i = 0; i < sortedMediumLevel.size(); i++)
            System.out.println(1 + i + ". " + sortedMediumLevel.get(i).getName() + " " + convertToHourMinSec(sortedMediumLevel.get(i).getTime()));


        System.out.println("******* EASY *********");
        for (int i = 0; i < sortedEasyLevel.size(); i++)
            System.out.println(1 + i + ". " + sortedEasyLevel.get(i).getName() + " " + convertToHourMinSec(sortedEasyLevel.get(i).getTime()));

    }

    /**
     * For ease of sorting the times, its saved in milliseconds.
     * This method converts to a string with the format HH:MIN:SEC
     * @param time in milliseconds
     * @return String in format HH:MIN:SEC
     */

    public String convertToHourMinSec(long time) {

        long hour, sec, min;

        sec = (time / 1000) % 60;
        min = (time / (1000 * 60)) % 60;
        hour = time / (1000 * 60 * 60);

        return hour + ":" + min + ":" + sec;

    }

    /**
     *method sorts a list in order of lowest time to highest time
     *
     * @param highScore list to be sorted
     * @return a sorted list
     */
    public List<Player> sortHighScoreList(List<Player> highScore) {

        //kopiera listan för att inte göra ändringar i orginalet
        List<Player> sortedList = new ArrayList<>(highScore);

        Collections.sort(sortedList, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Long.compare((p1.getTime()), p2.getTime());
            }
        });


        return sortedList;
    }


    public String getName() {
        return name;
    }

    public long getTime() {

        return time;// / 1000;     //Convert in to seconds from milliseconds
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // (Elin) added a setter here to get the name in the menu
    public void setName(String name) {
        this.name = name;
    }

    public void setTime(long time) {   //??
        this.time = time;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", time='" + time + '\'' + ", level='" + level + '\'' + '}';
    }
}










