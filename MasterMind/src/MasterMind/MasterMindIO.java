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
     * @param message Question to ask game player
     * @return answer of game player
     */
    public int getIntInput(String message){
        int ret = 0;
        boolean success = false;
        while (!success){
            try{
                System.out.print(message);
                ret = m_scan.nextInt();
                success = true;
            } catch(Exception e){
                System.out.println("WRONG, must be integer. Thank you!");
                m_scan.next();
            }
        }
        return ret;
    }

    public int[] getCode(String message, int max_len, int colourAmount){
        int[] ret = new int[max_len];
        System.out.println(message);
        for (int i = 0; i < max_len; i++) {
            boolean success = false;
            int input = 0;
            while (!success){
                input = getIntInput("CodeBlock " + (i + 1) + ": ");
                if (input < colourAmount) success = true;
                else System.out.println("CodeBlock must be less than the amount of colours");
            }
            ret[i] = input;
        }

        return ret;
    }

    public void printBoard(MasterMind mm){
        printPlayerScores(mm.getScorePlayer1(), mm.getScorePlayer2());
        printRows(mm.COLS, mm.getBoard());
    }

    private void printRows(int codeLength, ArrayList<Row> board){
        //----------------------------
        //        1 | W G G R | W R R
        System.out.println(multiply(codeLength, "-"));
        for (int i=0; i<board.size(); i++){
            String row = i+1 + " | ";
            //row += board.get(i).getRowAsString();
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

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.print("\f");
    }
}
