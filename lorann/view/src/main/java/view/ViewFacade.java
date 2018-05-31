package view;

import java.util.List;

import javax.swing.JOptionPane;

import model.Tile;
import showboard.BoardFrame;
import showboard.ISquare;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	
	private BoardFrame boardFrame;
	
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
	public void createFrame(String name, boolean decorated) {
		this.boardFrame = new BoardFrame(name, decorated);
	}

	@Override
	public void showMapOnFrame(List<Tile> ListTiles) {
		for (final Tile tile : ListTiles) {
			
			//ISquare square = 
            //this.boardFrame.addSquare(square(), x, y);
        }
		
	}
		
		
		
		
		/*
		for (int y = 0; y < height; y++) {
        	for (int x = 0; x < width; x++) {
                ISquare square = this.getRoad().getOnTheRoadXY(x, y);
        		this.frame.addSquare(square, x, y);
            }
        }*/
}
