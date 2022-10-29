package MasterMind;

import java.util.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import MasterMind.view.MasterMindView;

/**
 * @author Lorrens Pantelis, Groepsnr. 8
 */
public class MasterMind {
    private MasterMindModel m_model;

    private MasterMindView m_masterView;

    
    public MasterMind(){
        m_model = new MasterMindModel();
    }


    public void createGUI(){
        JFrame frame = new JFrame("Mastermind By Masterminds");
        frame.setPreferredSize(new Dimension(500, 500));
        m_masterView = new MasterMindView(frame.getContentPane(), "Mastermind By Masterminds", m_model);           

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
