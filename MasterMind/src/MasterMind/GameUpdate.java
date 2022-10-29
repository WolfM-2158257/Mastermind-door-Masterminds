package MasterMind;

import MasterMind.MasterMindModel.Event;

public class GameUpdate {
    private Event m_event;
    private Row m_row;
    
    GameUpdate(Event event){
        m_event = event;
    }

    public void setRow(Row row){
        m_row = row;
    }
    
    public Row getRow(){
        return new Row(m_row);
    }

    public Event getEvent(){
        return m_event;
    }
}
