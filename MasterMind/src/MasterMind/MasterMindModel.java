package MasterMind;

import java.util.*;

/**
 * @author Lorrens Pantelis, Groepsnr. 8
 */
public class MasterMindModel extends Observable {
    public static enum GameType {
        PlayervPlayer, PlayerVComputer
    }

    private int m_amountColours;
    private Code m_codeToBreak;
    private ArrayList<Row> m_board;

    private int m_maxScore, m_scorePlayer1, m_scorePlayer2; // score
    private int m_currentPlayer;
    public int COLS; // len of code
    public int ROWS; // number of tries

    private RandomStrategy m_strat;

    /**
     * Starts game
     */
    public void start(int amountColours, int cols, int rows, int maxScore, int gameMode) {
        m_amountColours = amountColours;
        COLS = cols;
        ROWS = rows;
        m_maxScore = maxScore;
        m_strat = new RandomStrategy(m_amountColours, COLS);

        this.init();
        this.mainLoop();
    }

    /**
     * The mainloop of MasterMind
     */
    private void mainLoop() {
        boolean gameFinished = false;
        this.roundLoop();
        gameFinished = checkGameOver();
    }

    /**
     * Check if a player has won the game.
     * 
     * @return false if game not over, true if game over
     */
    private boolean checkGameOver() {
        if (m_scorePlayer1 >= m_maxScore) {
            System.out.println("Player 1 won.");
            return true;
        } else if (m_scorePlayer2 >= m_maxScore) {
            System.out.println("Player 2 won.");
            return true;
        } else
            return false;
    }

    /**
     * Inits game parameters
     */
    private void init() {
        m_currentPlayer = 2;

        GameType game_type = GameType.PlayerVComputer;
        if (game_type == GameType.PlayerVComputer) {
            this.m_strat = new RandomStrategy(m_amountColours, COLS);
        }
        m_board = new ArrayList<Row>(ROWS);
    }

    public void setCodeBase(String code) {
        m_codeToBreak = new Code(code);
    }

    private void inputCode(String codeStr) {
        Code code = new Code(codeStr);

        m_board.add(new Row(code, m_codeToBreak));

        boolean isCodeGuessed = m_codeToBreak.compare(code);
        if (isCodeGuessed){
            System.out.println("You guessed the code!");
            roundOver();
        }
        else
            System.out.println("You failed in guessing the code... \nThe code was: " + m_codeToBreak.toString());
        
        MasterMindUpdate info = new MasterMindUpdate();
        setChanged();
        notifyObservers(info);
    }

    /**
     * Round is over, swap players and increment scores
     */
    private void roundOver() { 
        int score = m_board.size();
        if (m_currentPlayer == 1){
               m_currentPlayer = 2;
        }
        else{
            m_scorePlayer2 += score;
            m_currentPlayer = 1;
        }


        // m_IOHandler.printPlayerScores(m_scorePlayer1, m_scorePlayer2);
        
        m_board = new ArrayList<>();
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
     * @return the length of t he codes
     */
    public int getCodeLength(){
        return COLS;
    }
}
