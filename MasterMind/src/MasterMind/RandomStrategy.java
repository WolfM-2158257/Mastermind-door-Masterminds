package MasterMind;

import java.util.Random;

public class RandomStrategy extends MasterMindStrategy{

    public RandomStrategy(int amountColors, int cols) {
        super(amountColors, cols);
        //TODO Auto-generated constructor stub
    }
    
    public Code guessCode(){
        Random rand = new Random();
        
        int[] code = new int[m_colsGame];
        for (int i = 0; i < code.length; i++){
            code[i] = rand.nextInt(m_amountColorsGame);
        }
        return new Code(code);
    }

    public Code generateCode(){
        Random rand = new Random();
        
        int[] code = new int[m_colsGame];
        for (int i = 0; i < code.length; i++){
            code[i] = rand.nextInt(m_amountColorsGame);
        }
        return new Code(code);
    }
}
