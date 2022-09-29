package MasterMind;


import java.awt.*;
import java.io.Console;
import java.util.Scanner;

public class MasterMind {
    private int m_amountColours;
    private Scanner m_scan = new Scanner(System.in);

    public int COLS; // len of code
    public int ROWS; // number of try's


    public static void main(String[] args){
        MasterMind game = new MasterMind();
        game.start();
    }

    private void start(){
        System.out.print("How many codebreaker tries: ");
        int input = m_scan.nextInt();
        System.out.println(input);
    }
}
