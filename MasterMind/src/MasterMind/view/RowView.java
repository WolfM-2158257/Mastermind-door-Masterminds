package MasterMind.view;
import MasterMind.Row;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import MasterMind.MasterMindController;
import MasterMind.MVC.AbstractView;

public class RowView extends AbstractView {
    private JPanel m_panel;
    private JLabel m_code;
    private JLabel m_red_pins;
    private JLabel m_white_pins;

    public RowView(Row row) {
        super(row, null);
    }

    public JComponent getUI() {

        Row m = (Row)getModel();

        this.m_code = new JLabel(m.getCodeString());
        this.m_red_pins = new JLabel(m.getRedString());
        this.m_red_pins = new JLabel(m.getWhiteString());
        LayoutManager layout = new FlowLayout();

        // set layout
        this.m_panel.setLayout(layout);

        // add buttons
        this.m_panel.add(this.m_code);
        this.m_panel.add(this.m_red_pins);
        this.m_panel.add(this.m_white_pins);

        return m_panel;
    }

    @Override
    public void update(Observable o, Object arg){
       this.m_panel.disable(); 
    }
}
