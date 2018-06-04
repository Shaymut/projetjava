package controller;

import java.sql.SQLException;
import java.util.List;

import javax.management.timer.Timer;

import model.DoorOpened;
import model.Element;
import model.Ground;
import model.IModel;
import model.Position;
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
    
    private Element[][] mapNiveau;
    
    private double score;
    
    Timer timer;
    
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
    	
        final List<Tile> ListTiles = this.getModel().getAllTilesByMap(5);
        final StringBuilder message = new StringBuilder();
        for (final Tile tile : ListTiles) {
            message.append(tile);
            message.append('\n');
        }
        System.out.println(message.toString());
        this.getModel().CreateMap(ListTiles);
        this.getView().displayMap(this.getModel().getMap());
        this.mapNiveau = this.getModel().getMap();
        this.setViewFacade(new ViewFacade("Lorann", 20, 12, this.getModel().getMap()));
        this.viewFacade.setController(this);
        this.lorann = this.getModel().getLorann();
        this.getView().setLorann(this.lorann);
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
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() + 1, this.getModel().getLorann().getY(), this);
		}else if (this.getViewFacade().getOrder() == Order.LEFT) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() - 1, this.getModel().getLorann().getY(), this);
		}else if (this.getViewFacade().getOrder() == Order.UP) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX(), this.getModel().getLorann().getY() - 1, this);
		}else if (this.getViewFacade().getOrder() == Order.DOWN) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX(), this.getModel().getLorann().getY() + 1, this);
		}else if (this.getViewFacade().getOrder() == Order.LEFT_UP) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() - 1, this.getModel().getLorann().getY() - 1, this);
		}else if (this.getViewFacade().getOrder() == Order.RIGHT_UP) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() + 1, this.getModel().getLorann().getY() - 1, this);
		}else if (this.getViewFacade().getOrder() == Order.LEFT_DOWN) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() - 1, this.getModel().getLorann().getY() + 1, this);
		}else if (this.getViewFacade().getOrder() == Order.RIGHT_DOWN) {
			new Collision(this.getModel().getMap(), this.getModel().getLorann(), this.getModel().getLorann().getX() + 1, this.getModel().getLorann().getY() + 1, this);
		}
	}
	
	public void lorannMove(int x, int y){
		Element temp = this.mapNiveau[x][y];
		int tempX = this.lorann.getX();
		int tempY = this.lorann.getY();
		this.mapNiveau[x][y] = lorann;
		this.mapNiveau[tempX][tempY] = temp;
		lorann.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}

	@Override
	public void remove(int x, int y) {
		this.mapNiveau[x][y] = new Ground(new Position(x,y));
	}

	@Override
	public void died() {
		this.getView().displayMessage("Tu es mort !\nTon score est de : " + this.score);
		this.getViewFacade().killFrame();
	}
	
	@Override
	public void win() {
		this.getView().displayMessage("Tu as fini le niveau, Bravo!\nTon score est de : " + this.score);
		this.getViewFacade().killFrame();
	}

	@Override
	public void scoreUp(double x) {
		this.score = score + x;
		System.out.println("Score : " + this.score);
	}

	@Override
	public void replaceDoor() {
		for(int i = 0; i <= 19; i++) {
			for(int j = 0; j <= 11; j++) {
				if(this.mapNiveau[i][j].getSprite() == 'C') {
					this.mapNiveau[i][j] = new DoorOpened(this.mapNiveau[i][j].getPosition());
				}
			}
		}
		this.getModel().setMap(this.mapNiveau);
	}
	
	
}
