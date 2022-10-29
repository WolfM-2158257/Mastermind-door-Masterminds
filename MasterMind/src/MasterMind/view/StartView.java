package MasterMind.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;

import MasterMind.MVC.AbstractView;
import MasterMind.MVC.Controller;
import MasterMind.MVC.View;
import MasterMind.MasterMindController;

public class StartView extends AbstractView {
    private JPanel m_panel;

    private JTextField m_textAmountColours;
    private JTextField m_textCols;
    private JTextField m_textRows;
    private JTextField m_textMaxScore;
    private JTextField m_textGameMode;

    private JButton m_start;

    public StartView(Observable model, MasterMindController controller) {      
        super(model, controller);  
        
        m_panel = new JPanel();

        Dimension dimension = new Dimension(100, 20);
        
        m_textAmountColours = new JTextField("5");
        m_textAmountColours.setPreferredSize(dimension);
        m_textCols = new JTextField("5");
        m_textCols.setPreferredSize(dimension);
        m_textRows = new JTextField("5");
        m_textRows.setPreferredSize(dimension);
        m_textMaxScore = new JTextField("10");
        m_textMaxScore.setPreferredSize(dimension);
        m_textGameMode = new JTextField("1");
        m_textGameMode.setPreferredSize(dimension);
        m_start = new JButton("Start");

        m_panel.add(m_textAmountColours);
        m_panel.add(m_textCols);
        m_panel.add(m_textRows);
        m_panel.add(m_textMaxScore);
        m_panel.add(m_textGameMode);
        m_panel.add(m_start);

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

    
    @Override
    public void update(Observable o, Object info) {

    }

    @Override
    public Controller defaultController(Observable model) {
        return new MasterMindController(model);        
    }
    
    public JComponent getUI() {
        return m_panel;
    }
}
