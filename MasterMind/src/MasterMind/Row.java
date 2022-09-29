package MasterMind;

/**
 * @author SenneW, HiddeB
 */
public class Row {
    private Code m_code;
    private int m_pins_red;
    private int m_pins_white;

    /**
     * @param code code used inside row
     * @pre: code must be filled
     **/
    public Row(Code code, Code baseCode)
    {
        m_pins_red = 0; m_pins_white = 0;
        this.m_code = code;
        this.calcPins(baseCode);
    }

    /**
    * Returns the row as a string
    * @out: String
    **/
    @Override
    public String toString()
    {
        return this.m_code.toString() + String.format("| %dW, %dR", this.m_pins_white, this.m_pins_red);
    }

    /**
     * Calculate the white and red pins (result) of the try
     * @param baseCode --> the code that needs to be cracked
     **/
    private void calcPins(Code baseCode) {
        for (int i = 0; i < m_code.getLength(); i++) {
            int sameColor = 0;
            boolean redIncremented = false;
            for (int j = 0; j < baseCode.getLength(); j++) {
                if (m_code.getBlock(i) == baseCode.getBlock(j) && i == j){
                    m_pins_red++;
                    redIncremented = true;
                    break;
                }
                else if (m_code.getBlock(i) == baseCode.getBlock(j) && i != j)
                    sameColor++;
            }
            if (sameColor > 0 && !redIncremented)
                m_pins_white++;
        }
    }
}
