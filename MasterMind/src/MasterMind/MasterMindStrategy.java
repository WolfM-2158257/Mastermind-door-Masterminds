package MasterMind;

/**
 * @author Wolf Moyaers, Groepsnr. 8
 */
abstract public class MasterMindStrategy {
    protected int m_amountColorsGame;
    protected int m_colsGame;
    
    /**
     * 
     * @param amountColors the amount of colors in the game
     * @param cols : amount of digits a code can have
     */
    public MasterMindStrategy(int amountColors, int cols){
        m_amountColorsGame = amountColors;
        m_colsGame = cols;
    }
    
    /**
     * Guesses the code (for code breaker)
     * @return the guessed code generated by the strategy
     */
    abstract public int[] guessCode();

    /**
     * Generates a code (for codemaker)
     * @return the code generated by the strategy
     */
    abstract public int[] generateCode();
}