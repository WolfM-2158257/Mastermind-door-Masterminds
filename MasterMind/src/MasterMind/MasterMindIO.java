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

    public void printBoard(ArrayList<Row> board){
        printPlayerScores();
        printRows(board);
    }

    private void printRows(ArrayList<Row> board){
        //----------------------------
        //        1  |  W  G  G  R  |  W  R  R
        for (int i=0; i<board.size(); i++){
            String s;
            //String s = board[i].getAsString();

        }
    }

    private void printPlayerScores(){
        //Player1: x         Player2: y
        //System.out.printf("Player1: " + );
    }
}
