package view;

import controller.IController;
import model.*;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    
   //void createFrame(String name, int x, int y, Element[][] mapNiveau);
    
    void displayMap(Element[][] elements);
    
    void updateFrame();
    
    Order getOrder();
    
    void killFrame();

	void setController(IController controller);
   
}
