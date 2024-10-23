import java.io.*;

public class Player {

    private String name, time;
    private int score;

    public Player(){}

    /**
     * Method to print the names and result from the highscore list
     *
     * @throws IOException
     */
    public void getHighScore() throws IOException{

        var inData = new BufferedReader(new FileReader("src/DATA.txt"));
        int rowNr = 0;

        while(true){
            String row = inData.readLine();
            if(row == null)  //end of file?
                break;       //yes
            rowNr ++;    //NO continue to print read  line
            System.out.println(rowNr + ": " + row);
        }
    }

    public void saveHighScore(Player player, String Time ) throws IOException{ //Change to current parameters





        }



    }






