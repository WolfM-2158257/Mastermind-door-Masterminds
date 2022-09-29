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
     **/
    // private void calcPins(Code baseCode) {
    //     for (int i = 0; i < m_code.getLength(); i++) {
    //         int sameColor = 0;
    //         boolean redIncremented = false;
    //         for (int j = 0; j < baseCode.getLength(); j++) {
    //             if (m_code.getBlock(i) == baseCode.getBlock(j) && i == j) {
    //                 m_pins_red++;
    //                 redIncremented = true;
    //                 break;
    //             } else if (m_code.getBlock(i) == baseCode.getBlock(j) && i != j)
    //                 sameColor++;
    //         }
    //         if (sameColor > 0 && !redIncremented)
    //             m_pins_white++;
    //     }
    // }

    private void calcPins(Code baseCode) {
        char[] pinsArr = new char[baseCode.getLength()];
        fillArray(pinsArr, '0');
        char[] locationsW = new char[baseCode.getLength()];
        fillArray(locationsW, '0');
        for (int i = 0; i < baseCode.getLength(); i++) {
            if (m_code.getBlock(i) == baseCode.getBlock(i)){
                pinsArr[i] = 'R';
                locationsW[i] = 'R';
            }
        }
        for (int i = 0; i < baseCode.getLength(); i++) {
            for (int j = 0; j < baseCode.getLength(); j++) {
                if (m_code.getBlock(i) == baseCode.getBlock(j) && pinsArr[i] == '0' && locationsW[j] == '0'){
                    locationsW[j] = 'W';
                    pinsArr[i] = 'W';
                }
            }
        }
        setPinsByArr(pinsArr);
    }

    private static void fillArray(char[] arr, char c) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = c;
    }


    private void setPinsByArr(char[] pinsArr){
        for (int i = 0; i < pinsArr.length; i++){
            if (pinsArr[i] == 'R')
                m_pins_red += 1;
            else if (pinsArr[i] == 'W')
                m_pins_white += 1;
        }
    }
}
