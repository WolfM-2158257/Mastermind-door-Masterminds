package MasterMind;

import MasterMind.MVC.AbstractController;

import java.time.*;
import java.util.Observable;

/**
 * A clock controller that allows the clock to be started, stopped and reset.
 * @author jvermeulen
 */
public class MasterMindController extends AbstractController {
    public MasterMindController(Observable model) {
        super(model);
    }
    
    public void onStart() {
        ((MasterMindModel)getModel()).start();
    }
}
