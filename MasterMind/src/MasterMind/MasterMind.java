package MasterMind;



import java.util.*;

public class MasterMind {
    private int m_amountColours;
    private final Scanner m_scan = new Scanner(System.in);
    private ArrayList<Row> m_board;

    private int scorePlayer1, scorePlayer2; // score
    public int COLS; // len of code
    public int ROWS; // number of try's

    public static void main(String[] args){
        MasterMind game = new MasterMind();
        game.start();
    }

    /**
     * starts game
     */
    private void start(){
        this.init();
        // TODO: get code from codemaker
        // TODO: keep asking try from codebreaker and check
    }


    /**
     * inits game parameters
     */
    private void init(){
        ROWS = getIntInput("How many codebreaker tries? ");
        COLS = getIntInput("How long can the code be? ");
        m_amountColours = getIntInput("How many colours? ");
        m_board = new ArrayList<Row>(ROWS);
    }
    /**
     * Based on question s you can ask input from players.
     * Method handles non integer inputs on its own.
     *
     * @param s Question to ask game player
     * @return answer of game player
     */
    private int getIntInput(String s){
        int ret = 0;
        boolean success = false;
        while (!success){
            try{
                System.out.print(s);
                ret = m_scan.nextInt();
                success = true;
            } catch(InputMismatchException e){
                System.out.println("You gave wrong input, must be integer. Thank you!");
                m_scan.next();
            }
        }
        return ret;
    }
}
