package MasterMind;


import java.awt.*;
import java.io.Console;
import java.util.*;

public class MasterMind {
    private int m_amountColours;
    private final Scanner m_scan = new Scanner(System.in);
    // private Code m_code;

    public int COLS; // len of code
    public int ROWS; // number of try's


    public static void main(String[] args){
        MasterMind game = new MasterMind();
        game.start();
    }

    private void start(){
        this.init();
    }

    private void init(){
        ROWS = getIntInput("How many codebreaker tries? ");
        COLS = getIntInput("How long can the code be? ");
        m_amountColours = getIntInput("How many colours? ");
    }

    private int getIntInput(String s){
        int ret = 0;
        boolean success = false;
        while (!success){
            try{
                System.out.print(s);
                ret = m_scan.nextInt();
                success = true;
            } catch(InputMismatchException e){
                System.out.println("You gave wrong input, must be integer. Thank you!");
                m_scan.next();
            }
        }
        return ret;
    }
}
