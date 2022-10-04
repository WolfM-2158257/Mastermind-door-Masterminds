package MasterMind;


import java.util.Arrays;


/**
 * Represents a code from the game MasterMind
 *
 * @author Lorrens Pantelis, Groeps nr. 8
 */
public class Code {
    private int[] m_codes;

    /**
     *
     * @param c array of ints that represents a code
     */
    public Code(int[] c){
        m_codes = c;
    }


    /**
     *
     * @param c String of code
     */
    public Code(String c){
        m_codes = new int[c.length()];
        for (int i = 0; i < c.length(); i++){
            m_codes[i] = c.charAt(i);
        }
    }


    /**
     * converts Code to a string
     * @return String
     */
    @Override
    public String toString() {
        return Arrays.toString(m_codes);
    }

    /**
     * Returns codeBlock at position pos
     * @param pos
     * @return block of the code
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

    /**
     * Checks if 2 codes are the same
     * @param code a Code instance
     * @return true if they are the same, false if not
     *
     * @pre code.getLength() == this.getLength()
     */
    public boolean compare(Code code){
        for(int i =0; i< this.m_codes.length; i++){
            if(this.m_codes[i] != code.m_codes[i]){
                return false;
            }
        }
        return true;
    }
}
