package MasterMind.view;

import MasterMind.GameUpdate;

import java.util.Observable;

import javax.swing.*;
import java.awt.Container;

import MasterMind.MasterMindModel;
import MasterMind.MVC.AbstractView;
import MasterMind.MasterMindModel.Event;

public class MasterMindView extends AbstractView {
    // The clock data (i.e., the Model).
    private MasterMindModel m_model;

    private Container m_target;

    StartView m_startScreen;
    GameView m_gameScreen;
    
    public MasterMindView(Container target, String name, MasterMindModel model){
        // init member variables
        m_target = target;
        m_model = model;

        m_model.addObserver(this);
        m_target.setLayout(new BoxLayout(m_target, BoxLayout.Y_AXIS));

        m_startScreen = new StartView(model, null);
        m_gameScreen = new GameView(model, null);
        m_model.addObserver(m_gameScreen);

        showStartScreen();
    }

    private void showStartScreen(){
        m_target.removeAll();
        m_target.add(m_startScreen.getUI());
    }

    private void showGame(){
        m_target.removeAll();
        m_target.add(m_gameScreen.getUI());
    }

    
    @Override
    public void update(Observable o, Object info) {
        switch (((GameUpdate) info).getEvent()){
            case GAME_STARTED:
                showGame();
                System.out.println("Shit is working");
                break;
        }
        // this redraws everything ????? AAAAAAA
        m_target.revalidate();
        m_target.repaint();
    }
}
