package MasterMind;

abstract public class MasterMindStrategy {
    protected int m_amountColorsGame;
    protected int m_colsGame;
    
    public MasterMindStrategy(int amountColors, int cols){
        
    }
    
    abstract public Code doMove();

    abstract public Code generateCode();
}