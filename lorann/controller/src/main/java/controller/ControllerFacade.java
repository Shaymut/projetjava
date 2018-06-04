package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.ViewFactory;

import model.Element;
import model.IModel;
import model.Tile;
import view.IView;
import view.Order;
import view.ViewFacade;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    private Element lorann;
    
    private ViewFacade viewFacade;
    
    //Keyboard keyboard = new Keyboard();
    
    

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        /*this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());*/
    	
        final List<Tile> ListTiles = this.getModel().getAllTilesByMap(1);
        final StringBuilder message = new StringBuilder();
        for (final Tile tile : ListTiles) {
            message.append(tile);
            message.append('\n');
        }
        System.out.println(message.toString());
        this.getModel().CreateMap(ListTiles);
        this.getView().displayMap(this.getModel().getMap());
        this.setViewFacade(new ViewFacade("Lorann", 20, 12, this.getModel().getMap()));
        this.viewFacade.setController(this);
        this.lorann = this.getModel().getLorann();
        this.getView().setLorann(this.lorann);
        
	    System.out.println(this.getViewFacade().getOrder());
        
        
        //this.getView().updateFrame();     <------ Erreur si lanc�
    }
    /*
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	public ViewFacade getViewFacade() {
		return viewFacade;
	}

	public void setViewFacade(ViewFacade viewFacade) {
		this.viewFacade = viewFacade;
	}
	
	public void updatemove() {
		if (this.getViewFacade().getOrder() == Order.RIGHT) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() +1, this.getModel().getLorann().getY(), this);
		}else if (this.getViewFacade().getOrder() == Order.LEFT) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() -1, this.getModel().getLorann().getY(), this);
		}
	}
}
