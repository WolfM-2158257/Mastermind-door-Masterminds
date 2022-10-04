package MasterMind.view;

import java.awt.Container;
import java.util.Observable;

import javax.swing.*;

import MasterMind.MVC.AbstractView;
import MasterMind.MVC.Controller;
import MasterMind.MasterMindController;

public class StartScreen extends AbstractView {
    private BoxLayout m_container;

    private JTextField m_textCols;
    private JTextField m_textRows;
    private JTextField m_textMaxScore;
    private JTextField m_textStrat;

    private JButton m_start;

    public StartScreen(Container target) {        
        m_container = new BoxLayout(target, BoxLayout.Y_AXIS);
        m_textCols = new JTextField();
        m_textRows = new JTextField();
        m_textMaxScore = new JTextField();
        m_textStrat = new JTextField();
        m_start = new JButton("Start");

        target.add(m_textCols);
        target.add(m_textRows);
        target.add(m_textMaxScore);
        target.add(m_textStrat);
        target.add(m_start);
    }

    public BoxLayout getUI(){
        return m_container;
    }
    
    @Override
    public Controller defaultController(Observable model) {
        return new MasterMindController(model);        
    }
}
