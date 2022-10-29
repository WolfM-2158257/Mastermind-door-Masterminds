package MasterMind.view;

import javax.swing.*;

import MasterMind.MVC.AbstractView;

public class RowView extends AbstractView {
    private JPanel m_panel;

    

    public JComponent getUI() {
        return m_panel;
    }
}
