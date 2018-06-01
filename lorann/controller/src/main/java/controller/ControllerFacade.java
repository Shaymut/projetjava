package controller;

import java.sql.SQLException;
import java.util.List;
import model.IModel;
import model.Tile;
import view.IView;

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
        this.getView().createFrame("Lorann", 20, 12, this.getModel().getMap());
        System.out.println("UPDATE");
        //this.getView().updateFrame();   <------ Erreur si lancé
    }
    /**
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
}
