package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	JFrame frame;
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
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

	@Override
	public void createFrame(String name, int x, int y, Element[][] mapNiveau) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new Window(name, x, y, mapNiveau);
                frame.setVisible(true);
            }
        });
		
	}

}
