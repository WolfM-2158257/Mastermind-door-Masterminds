package MasterMind;

import java.util.*;

public class MasterMind {
    private int m_amountColours;
    private Code m_codeToBreak;
    private ArrayList<Row> m_board;
    private MasterMindIO m_IOHandler;
    private int m_scorePlayer1, m_scorePlayer2; // score
    public int COLS; // len of code
    public int ROWS; // number of tries

    private RandomStrategy m_strat;

    public static void main(String[] args){
        MasterMind game = new MasterMind();
        game.start();
    }

    /**
     * Starts game
     */
    private void start(){
        this.init();
        // TODO: get code from codemaker
        // TODO: keep asking try from codebreaker and check
        m_IOHandler.printBoard(this);
        MasterMindIO.clearConsole();
    }


    /**
     * Inits game parameters
     */
    private void init(){
        m_IOHandler = new MasterMindIO();

        ROWS = m_IOHandler.getIntInput("How many codebreaker tries? ");
        COLS = m_IOHandler.getIntInput("How long can the code be? ");
        m_amountColours = m_IOHandler.getIntInput("How many colours? ");
        m_board = new ArrayList<Row>(ROWS);
        m_codeToBreak = this.askCodeFromCodeMaker();
    }

    private Code askCodeFromCodeMaker(){
        return new Code(m_IOHandler.getCode("CodeMaker give a code:", COLS, m_amountColours));
    }

    /**
     *
     * @return score of player 1
     */
    public int getScorePlayer1(){
        return m_scorePlayer1;
    }

    /**
     *
     * @return score of player 2
     */
    public int getScorePlayer2(){
        return m_scorePlayer2;
    }

    /**
     *
     * @return the complete board
     */
    public ArrayList<Row> getBoard(){
        return m_board;
    }

    /**
     *
     * @return the length of the codes
     */
    public int getCodeLength(){
        return COLS;
    }
}
