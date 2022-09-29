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
    public Row(Code code, Code baseCode) {
        m_pins_red = 0;
        m_pins_white = 0;
        this.m_code = code;
        this.calcPins(baseCode);
    }

    /**
     * Returns the row as a string
     * 
     * @out: String
     **/
    @Override
    public String toString() {
        return this.m_code.toString() + String.format("| %dW, %dR", this.m_pins_white, this.m_pins_red);
    }

    /**
     * Calculate the white and red pins (result) of the try
     * 
     * @param baseCode --> the code that needs to be cracked
     * @pre baseCode.length == m_code.length
     * @post amount red pins + amount white pins <= COLS
     **/
    private void calcPins(Code baseCode) {
        char[] pinsGuess = new char[baseCode.getLength()]; // array with red or white on the locations of the breaker's code
        fillArray(pinsGuess, '0');
        char[] pinsCorrect = new char[baseCode.getLength()]; // array with red or white on the locations of the correct code.
        fillArray(pinsCorrect, '0');
        for (int i = 0; i < baseCode.getLength(); i++) { // find the red pins
            if (m_code.getBlock(i) == baseCode.getBlock(i)){
                pinsGuess[i] = 'R';
                pinsCorrect[i] = 'R';
            }
        }
        for (int i = 0; i < baseCode.getLength(); i++) { // find the white pins
            for (int j = 0; j < baseCode.getLength(); j++) {
                if (m_code.getBlock(i) == baseCode.getBlock(j) 
                    && pinsGuess[i] == '0' && pinsCorrect[j] == '0'){ // when the current pin is empty, and the color is found somewhere else (on a location which has not been found before)
                    pinsCorrect[j] = 'W';
                    pinsGuess[i] = 'W';
                }
            }
        }
        setPinsByArr(pinsGuess);
    }

    /**
     * Fill an array with a certain character
     * @param arr : the array which is to be filled
     * @param c : the character 
     */
    private static void fillArray(char[] arr, char c) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = c;
    }


    /**
     * set m_pins_white and m_pins_red to the amount of them found in the given aray
     * @param pinsArr array with pins
     * @pre in pinsArr: 'R' for red pins, 'W' for white pins, '0' for empty pins 
     * @post m_pins_red and m_pins_white are set.
     */
    private void setPinsByArr(char[] pinsArr){
        for (int i = 0; i < pinsArr.length; i++){
            if (pinsArr[i] == 'R')
                m_pins_red += 1;
            else if (pinsArr[i] == 'W')
                m_pins_white += 1;
        }
    }
}
