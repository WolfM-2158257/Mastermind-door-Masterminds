package MasterMind;

public class Row {
    private Code m_code;
    private int m_pins_red;
    private int m_pins_white;

    public void Row(){
        m_pins_red = 0; m_pins_white = 0;
    }

    /**
    * Returns the row as a string
    * @out: String
    **/
    public String GetRowAsString(){
        return this.m_code.GetCodeAsString() + String.format("%dW, %dR", this.m_pins_white, this.m_pins_red);
    }

    /**
     * Add a code to the row
     * @Param: User input code
     * @pre: Code is filled
     **/
    public void AddCode(Code code){
        this.m_code = code;
    }




}
