package MasterMind;

import java.util.Random;

public class RandomStrategy extends MasterMindStrategy{

    public RandomStrategy(int amountColors, int cols) {
        super(amountColors, cols);
    }
    
    /**
     * (code breaker)
     * Guess a random code
     */
    public int[] guessCode(){
        Random rand = new Random();
        
        int[] code = new int[m_colsGame];
        for (int i = 0; i < code.length; i++){
            code[i] = rand.nextInt(m_amountColorsGame);
        }
        return code;
    }

    /**
     * (code maker)
     * Generate a random code
     */
    public int[] generateCode(){
        Random rand = new Random();
        
        int[] code = new int[m_colsGame];
        for (int i = 0; i < code.length; i++){
            code[i] = rand.nextInt(m_amountColorsGame);
        }
        return code;
    }
}
