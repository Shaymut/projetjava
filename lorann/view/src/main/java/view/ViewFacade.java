package view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IController;
import model.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	private Window frame;
	
	private Element lorann;
	
	IController controller;
	
	public ViewFacade() {
		super();
	}
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(String name, int x, int y, Element[][] mapNiveau) {
        super();
        frame = new Window(name, x, y, mapNiveau);
        frame.setVisible(true);
    }
    
    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    @Override
    public void displayMap(Element[][] mapNiveau) {
		for (int i = 0; i <= 11; i++) {
			for (int j = 0; j <= 19; j++) {
				System.out.print(mapNiveau[j][i].getSprite());
			}
			System.out.println();
		}
	}
    
    public void setController(IController controller) {
    	this.controller = controller;
    	frame.setController(controller);
    }
	
	@Override
	public void updateFrame() {
		frame.updateFrame();
	}

	@Override
	public void setLorann(Element lorann) {
		this.lorann= lorann;
	}

	@Override
	public Order getOrder() {
		return frame.getOrder();
	}

}
