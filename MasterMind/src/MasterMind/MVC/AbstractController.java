package MasterMind.MVC;

import java.util.Observable;

/**
 *
 * @author jvermeulen
 */
public abstract class AbstractController implements Controller {
    private Observable mModel;
    private View mView;
    
    public AbstractController(Observable model) {
        // Set the model.
        setModel(model);
    }
    
    
    @Override
    public void setView(View view) {
        mView = view;
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void setModel(Observable model) {
        mModel = model;
    }

    @Override
    public Observable getModel() {
        return mModel;
    }
    
}
