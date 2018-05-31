package view;

import javax.swing.JOptionPane;

import showboard.BoardFrame;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	private BoardFrame Frame;
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
	public void createFrame(String name) {
		Frame = new BoardFrame(name, false);
		
	}

}
