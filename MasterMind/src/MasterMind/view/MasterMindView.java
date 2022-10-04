package MasterMind.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import MasterMind.MasterMindModel;

public class MasterMindView extends JFrame {
    StartScreen m_startScreen;
    
    public MasterMindView(String name, MasterMindModel model){
        super(name);

        m_startScreen = new StartScreen(this.getContentPane());

        showStartScreen();

    }

    private void showStartScreen(){
        this.setLayout(m_startScreen.getUI());
    }
}
