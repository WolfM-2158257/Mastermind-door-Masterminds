package MasterMind.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;

import MasterMind.MVC.AbstractView;
import MasterMind.MVC.Controller;
import MasterMind.MasterMindController;

public class StartScreen extends AbstractView {
    private BoxLayout m_container;

    private JTextField m_textAmountColours;
    private JTextField m_textCols;
    private JTextField m_textRows;
    private JTextField m_textMaxScore;
    private JTextField m_textGameMode;

    private JButton m_start;

    public StartScreen(Container target) {        
        m_container = new BoxLayout(target, BoxLayout.Y_AXIS);
        m_textAmountColours = new JTextField();
        m_textCols = new JTextField();
        m_textRows = new JTextField();
        m_textMaxScore = new JTextField();
        m_textGameMode = new JTextField();
        m_start = new JButton("Start");

        target.add(m_textCols);
        target.add(m_textRows);
        target.add(m_textMaxScore);
        target.add(m_textGameMode);
        target.add(m_start);

        m_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int amountColours = Integer.parseInt(m_textAmountColours.getText());
                int cols = Integer.parseInt(m_textCols.getText());
                int rows = Integer.parseInt(m_textRows.getText());
                int maxScore = Integer.parseInt(m_textMaxScore.getText());
                int gameMode = Integer.parseInt(m_textGameMode.getText());

                ((MasterMindController)getController()).onStart(amountColours, cols, rows, maxScore, gameMode);
            }
        });
    }

    public BoxLayout getUI(){
        return m_container;
    }
    
    @Override
    public Controller defaultController(Observable model) {
        return new MasterMindController(model);        
    }
}
