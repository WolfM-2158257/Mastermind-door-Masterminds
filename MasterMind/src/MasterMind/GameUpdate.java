package MasterMind;

import MasterMind.MasterMindModel.Event;

public class GameUpdate {
    private Event m_event;
    
    GameUpdate(Event event){
        m_event = event;
    }

    public Event getEvent(){
        return m_event;
    }
}
