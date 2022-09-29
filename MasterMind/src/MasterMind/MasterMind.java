package MasterMind;

import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class MasterMind {
    private int m_amountColours;
    private Code m_codeToBreak;
    private ArrayList<Row> m_board;
    private MasterMindIO m_IOHandler;
    private int m_maxScore, m_scorePlayer1, m_scorePlayer2; // score
    private int m_currentPlayer;
    public int COLS; // len of code
    public int ROWS; // number of tries

    private RandomStrategy m_strat;

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

        boolean gameFinished = false;
        while (!gameFinished){
            m_codeToBreak = this.askCodeFromCodeMaker();
            mainLoop();
            if (m_scorePlayer1 < m_maxScore && m_scorePlayer2 < m_maxScore){
                gameFinished = true;
                
            }
        }
    }

    private void mainLoop(){
        boolean isCodeGuessed = false;
        while (!isCodeGuessed && m_board.size() < ROWS ){
            Code code = inputCode();
            
            m_board.add(new Row(code));
            
            m_IOHandler.printBoard(this);
            
            isCodeGuessed = m_codeToBreak.compare(code);
        }
        if (isCodeGuessed)
            System.out.println("You guessed the code!");
        else
            System.out.println("You failed to guess the code...");
        roundOver();
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

    private Code askCodeFromCodeMaker(){
        Code code = new Code(m_IOHandler.getCode("CodeMaker give a code:", COLS, m_amountColours))
        MasterMindIO.clearConsole();
        return code;
    }

    private Code inputCode(){
        int[] code_raw;
        if (m_strat != null || m_currentPlayer == 2)
            code_raw = m_strat.guessCode();
        else
            code_raw = m_IOHandler.getCode("Give a code: ", COLS, m_amountColours);
            
        return new Code(code_raw);
    }

    /**
     * Round is over, swap players and increment scores
     */
    private void roundOver() {
        int score = m_board.size();
        if (m_currentPlayer == 1){
            m_scorePlayer1 += score;
            m_currentPlayer = 2;
        }
        else{
            m_scorePlayer2 += score;
            m_currentPlayer = 1;
        }

    };

    public int getScorePlayer1(){
        return m_scorePlayer1;
    }

    public int getScorePlayer2(){
        return m_scorePlayer2;
    }

    public ArrayList<Row> getBoard(){
        return m_board;
    }
}
