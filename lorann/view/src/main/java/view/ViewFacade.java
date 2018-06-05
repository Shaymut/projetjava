package view;

import javax.swing.JOptionPane;

import controller.IController;
import model.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.1
 * 
 *
 */
public class ViewFacade implements IView {
    
    /**
     * 
     * Window of the game
     * 
     * @see ViewFacade#ViewFacade()
     * @see ViewFacade#setMap(Element[][])
     * @see ViewFacade#setController(IController)
     * @see ViewFacade#updateFrame()
     * @see ViewFacade#getOrder()
     * @see ViewFacade#killFrame()
     */
    
    private Window frame;
    
    IController controller;
    
    /**
     * 
     * Constructor ViewFacade
     * 
     */
    
    public ViewFacade() {
        super();
    }
    
    /**
     * 
     * Constructor ViewFacade
     * Instantiates a new view facade.
     * 
     * @param name
     * @param x
     * @param y
     * @param mapNiveau
     */
    
    public ViewFacade(String name, int x, int y, Element[][] mapNiveau) {
        super();
        frame = new Window(name, x, y, mapNiveau);
        frame.setVisible(true);
    }
    /**
     * 
     * @param mapNiveau
     *
     */
    
    public void setMap(Element[][] mapNiveau) {
        this.frame.setMap(mapNiveau);
    }
    
    /*
     * 
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    /**
     * 
     * Display the map
     * 
     * @param mapNiveau
     * 
     */
    
    @Override
    public void displayMap(Element[][] mapNiveau) {
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 19; j++) {
                System.out.print(mapNiveau[j][i].getSprite());
            }
            System.out.println();
        }
    }
    
    /**
     * 
     * Set the controller
     * 
     * @param controller
     * 
     */
    
    @Override
    public void setController(IController controller) {
        this.controller = controller;
        frame.setController(controller);
    }
    
    /**
     * 
     * Update the frame
     * 
     * @see ViewFacade#frame
     * 
     */
    
    @Override
    public void updateFrame() {
        frame.updateFrame();
    }

    /**
     * 
     * Get an order
     * 
     * @see ViewFacade#frame
     * 
     */
    
    @Override
    public Order getOrder() {
        return frame.getOrder();
    }

    /**
     * 
     * Kill a frame
     * 
     * @see ViewFacade#frame
     * 
     */
    
    @Override
    public void killFrame() {
        frame.killFrame();
        
    }

}