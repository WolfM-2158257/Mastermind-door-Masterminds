package MasterMind;

import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class MasterMind {
    public static enum GameType{PlayervPlayer, PlayerVComputer}
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
     * Starts game
     */
    private void start(){
        this.init();
        this.mainLoop();
    }

    /**
     * The mainloop of MasterMind
     */
    private void mainLoop(){
        boolean gameFinished = false;
        while (!gameFinished){
            m_codeToBreak = this.askCodeFromCodeMaker();
            this.roundLoop();
            gameFinished = checkGameOver();
        }
    }

    /**
     * Singular roundLoop, breaker keeps guessing till he's out of tries,
     * or he guessed the code
     */
    private void roundLoop(){
        boolean isCodeGuessed = false;
        while (!isCodeGuessed && m_board.size() < ROWS ){
            Code code = inputCode();

            Row r = new Row(code);
            r.calcPins(m_codeToBreak);
            m_board.add(r);
            
            m_IOHandler.printBoard(this);
            
            isCodeGuessed = m_codeToBreak.compare(code);
        }
        if (isCodeGuessed)
            System.out.println("You guessed the code!");
        else
            System.out.println("You failed to guess the code...");
        roundOver();
    }

    private boolean checkGameOver(){
        if (m_scorePlayer1 >= m_maxScore){
            System.out.println("Player 1 won.");
            return true;
        }
        else if (m_scorePlayer2 >= m_maxScore){
            System.out.println("Player 2 won.");
            return true;
        }
        else
            return false;
    }

    /**
     * Inits game parameters
     */
    private void init(){
        m_IOHandler = new MasterMindIO();

        ROWS = m_IOHandler.getIntInput("How many codebreaker tries? ");
        COLS = m_IOHandler.getIntInput("How long can the code be? ");
        m_amountColours = m_IOHandler.getIntInput("How many colours? ");
        m_maxScore = m_IOHandler.getIntInput("What is the max score of the game? ");
        GameType game_type = m_IOHandler.getGameType();
        if (game_type == GameType.PlayerVComputer){
            this.m_strat = new RandomStrategy(m_amountColours, COLS);
        }
        m_board = new ArrayList<Row>(ROWS);
    }
    /**
     * Get code from codemaker
     * @out code from user input
     */
    private Code askCodeFromCodeMaker(){
        Code code = new Code(m_IOHandler.getCode("CodeMaker give a code:", COLS, m_amountColours));
        System.out.println(code);
        MasterMindIO.clearConsole();
        return code;
    }

    private Code inputCode(){
        int[] code_raw;
        if (m_strat != null || m_currentPlayer == 2)
            code_raw = m_strat.guessCode();
        else
            code_raw = m_IOHandler.getCode("CodeBreaker give a code: ", COLS, m_amountColours);
            
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
