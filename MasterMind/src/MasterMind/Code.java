package MasterMind;


import java.util.Arrays;

public class Code {
    private int[] m_codes;


    public Code(String s){
        String[] invCodes = s.split(" ");
        m_codes = new int[invCodes.length];
        int i = 0;
        for (String c: invCodes) m_codes[i++] = Integer.parseInt(c);
    }
    public Code(int[] c){
        m_codes = c;
    }

    @Override
    public String toString() {
        return Arrays.toString(m_codes);
    }

    /**
     * Returns codeBlock at position pos
     * @param pos
     * @return int
     *
     * @pre 0 < pos && pos < Code.length()
     * @post integer
     */
    public int getBlock(int pos){
        return m_codes[pos];
    }

    /** Returns the length of code
     *
     * @return length of Code
     */
    public int getLength(){
        return m_codes.length;
    }



}
