package MasterMind;

import java.util.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import MasterMind.view.MasterMindView;

/**
 * @author Lorrens Pantelis, Groepsnr. 8
 */
public class MasterMind {
    private MasterMindModel m_model;
    
    public MasterMind(){
        m_model = new MasterMindModel();
    }


    public void createGUI(){
        JFrame frame = new MasterMindView("Mastermind By Masterminds", m_model);           

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void createAndShowGUI(){
        MasterMind game = new MasterMind();
        game.createGUI();
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
