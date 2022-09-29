package MasterMind;

import java.util.*;

public class MasterMind {
    private int m_amountColours;
    private ArrayList<Row> m_board;
    private MasterMindIO m_IOHandler;
    private int scorePlayer1, scorePlayer2; // score
    private int COLS; // len of code
    private int ROWS; // number of tries

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
        m_IOHandler.printBoard(this);
    }


    /**
     * inits game parameters
     */
    private void init(){
        m_IOHandler = new MasterMindIO();

        ROWS = m_IOHandler.getIntInput("How many codebreaker tries? ");
        COLS = m_IOHandler.getIntInput("How long can the code be? ");
        m_amountColours = m_IOHandler.getIntInput("How many colours? ");
        m_board = new ArrayList<Row>(ROWS);
    }

    public int getScorePlayer1(){
        return scorePlayer1;
    }

    public int getScorePlayer2(){
        return scorePlayer2;
    }

    public ArrayList<Row> getBoard(){
        return m_board;
    }
}
