package MasterMind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ivan Molenaers, GroepNr. 8
 **/

public class MasterMindIO {
    private final Scanner m_scan;

    public MasterMindIO(){
        m_scan = new Scanner(System.in);
    }

    /**
     * Based on question s you can ask input from players.
     * Method handles non integer inputs on its own.
     *
     * @param s Question to ask game player
     * @return answer of game player
     */
    public int getIntInput(String s){
        int ret = 0;
        boolean success = false;
        while (!success){
            try{
                System.out.print(s);
                ret = m_scan.nextInt();
                success = true;
            } catch(Exception e){
                System.out.println("WRONG, must be integer. Thank you!");
                m_scan.next();
            }
        }
        return ret;
    }

    public void printBoard(MasterMind mm){
        printPlayerScores(mm.getScorePlayer1(), mm.getScorePlayer2());
        printRows(mm.getCodeLength(), mm.getBoard());
    }

    private void printRows(int codeLength, ArrayList<Row> board){
        //----------------------------
        //        1 | W G G R | W R R
        System.out.println(multiply(codeLength, "-"));
        for (int i=0; i<board.size(); i++){
            String row = Integer.toString(i+1) + " | ";
            row += board.get(i).getRowAsString();
        }
    }

    private void printPlayerScores(int p1, int p2){
        //Player1: x         Player2: y
        //System.out.printf("Player1: " + );
    }

    public static String multiply(int times, String s) {
        String ret = "";
        for (int i = 0; i < times; i++)
            ret += s;
        return ret;
    }
}
