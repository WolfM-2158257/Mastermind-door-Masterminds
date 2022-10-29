package MasterMind.view;

import MasterMind.GameUpdate;

import java.util.ArrayList;
import java.util.Observable;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MasterMind.MasterMindController;
import MasterMind.MVC.AbstractView;
import MasterMind.MVC.Controller;

public class GameView extends AbstractView {
    private JPanel m_panel;

    // code maker components
    private JTextField m_textMakerCode;
    private JButton m_buttonMaker;

    // code breaker components
    private JTextField m_textBreakerCode;
    private JButton m_buttonBreaker;

    private ArrayList<RowView> m_rows; 

    public GameView(Observable model, MasterMindController controller) {      
        super(model, controller);
        
        m_panel = new JPanel();
        // initialization
        initMakerComponents();
        initBreakerComponents();
        
        // show the components
        showMaker();
    }

    private void initMakerComponents(){
        Dimension dimension = new Dimension(200, 20);
        m_textMakerCode = new JTextField("Code Separated By Space");
        m_textMakerCode.setPreferredSize(dimension);

        m_buttonMaker = new JButton("Break Code");
        m_buttonMaker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String codeStr = m_textMakerCode.getText();
    
                ((MasterMindController)getController()).onMakerSubmittedCode(codeStr);
            }
        });
    }

    private void initBreakerComponents(){
        Dimension dimension = new Dimension(200, 20);
        m_textBreakerCode = new JTextField("5");
        m_textBreakerCode.setPreferredSize(dimension);

        m_buttonBreaker = new JButton("Guess Code");
    }

    private void showMaker(){
        m_panel.removeAll();
        m_panel.add(m_textMakerCode);
        m_panel.add(m_buttonMaker);
    }

    private void showBreaker(){
        m_panel.removeAll();
        m_panel.add(m_textBreakerCode);
        m_panel.add(m_buttonBreaker);
    }

    private void addRow(){

    }
    
    
    @Override
    public void update(Observable o, Object info) {
        GameUpdate gameInfo = (GameUpdate) info;
        switch (gameInfo.getEvent()){
            case GAME_MAKRCODE_ADDED:
                System.out.println("Code Made!");
                showBreaker();
                break;
            case GAME_BRKRCODE_ADDED:
                addRow();
                break;
        }
    }

    @Override
    public Controller defaultController(Observable model) {
        return new MasterMindController(model);        
    }
    
    public JComponent getUI() {
        return m_panel;
    }
}
