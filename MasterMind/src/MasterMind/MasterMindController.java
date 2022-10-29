package MasterMind;

import MasterMind.MVC.AbstractController;

import java.time.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * A clock controller that allows the clock to be started, stopped and reset.
 * @author jvermeulen
 */
public class MasterMindController extends AbstractController {
    public MasterMindController(Observable model) {
        super(model);
    }
    
    public void onStart(int amountColours, int cols, int rows, int maxScore, int gameMode) {
        System.out.println("[Controller] Game starting");
        ((MasterMindModel)getModel()).start(amountColours, cols, rows, maxScore, gameMode);
    }

    public void onMakerSubmittedCode(String codeStr) {
        ((MasterMindModel)getModel()).setCodeBase(codeStr);
    }
}
