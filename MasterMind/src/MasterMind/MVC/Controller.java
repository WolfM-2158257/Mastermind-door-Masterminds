package MasterMind.MVC;

import java.util.Observable;

/**
 *
 * @author jvermeulen
 */
public interface Controller {

    void setView(View view);
    View getView();
    void setModel(Observable model);
    Observable getModel();
}
