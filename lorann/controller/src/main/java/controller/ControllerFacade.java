package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

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
	
	private int niveau;
    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    private Element lorann;
    
    private Element evilRandom;
    
    private Element evilHorizontal;
    private boolean evilHorizontalMoveRight = true;
    
    private Element evilVertical;
    private boolean evilVerticalMoveDown = true;
    
    private Element evilPingPong;
    private int evilPingPongMove = 1;
    
    private ViewFacade viewFacade;
    private Element[][] mapNiveau;
    private double score;
    private boolean running = true;
    Random random = new Random();
    
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model, int niveau) {
        super();
        this.view = view;
        this.model = model;
        this.niveau = niveau;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
    	
        final List<Tile> ListTiles = this.getModel().getAllTilesByMap(niveau);
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
        this.evilRandom = this.getModel().getEvilRandom();
        this.evilHorizontal = this.getModel().getEvilHorizontal();
        this.evilVertical = this.getModel().getEvilVertical();
        this.evilPingPong = this.getModel().getEvilPingPong();
        this.getView().setLorann(this.lorann);
        timer();
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
	
	public void updatemoveLorann() {
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

	public void evilRandomMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilRandom.getX();
		int tempY = this.evilRandom.getY();
		this.mapNiveau[x][y] = evilRandom;
		this.mapNiveau[tempX][tempY] = temp;
		evilRandom.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	public void evilRadomMove() {
		int choix = random.nextInt(8);
		switch(choix) {
		case 1:
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() + 1, this.getModel().getEvilRandom().getY(), this);
			break;
		case 2:
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() - 1, this.getModel().getEvilRandom().getY(), this);
			break;
		case 3:
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX(), this.getModel().getEvilRandom().getY() - 1, this);
			break;
		case 4 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX(), this.getModel().getEvilRandom().getY() + 1, this);
			break;
		case 5 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() - 1, this.getModel().getEvilRandom().getY() - 1, this);
			break;
		case 6 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() + 1, this.getModel().getEvilRandom().getY() - 1, this);
			break;
		case 7 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() - 1, this.getModel().getEvilRandom().getY() + 1, this);
			break;
		case 8 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilRandom(), this.getModel().getEvilRandom().getX() + 1, this.getModel().getEvilRandom().getY() + 1, this);
			break;
		}
	}
	
	public void evilHorizontalMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilHorizontal.getX();
		int tempY = this.evilHorizontal.getY();
		this.mapNiveau[x][y] = evilHorizontal;
		this.mapNiveau[tempX][tempY] = temp;
		evilHorizontal.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	public void evilHorizontalMove() {
		if (evilHorizontalMoveRight) {
			new Collision(this.getModel().getMap(), this.getModel().getEvilHorizontal(), this.getModel().getEvilHorizontal().getX() + 1, this.getModel().getEvilHorizontal().getY(), this);
		}
		else {
			new Collision(this.getModel().getMap(), this.getModel().getEvilHorizontal(), this.getModel().getEvilHorizontal().getX() - 1, this.getModel().getEvilHorizontal().getY(), this);
		}
	}
	
	public void setEvilHorizontalMoveRight(boolean right) {
		this.evilHorizontalMoveRight = right;
	}
	
	public boolean getEvilHorizontalMoveRight() {
		return this.evilHorizontalMoveRight;
	}
	
	public void evilVerticalMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilVertical.getX();
		int tempY = this.evilVertical.getY();
		this.mapNiveau[x][y] = evilVertical;
		this.mapNiveau[tempX][tempY] = temp;
		evilVertical.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	public void evilVerticalMove() {
		if (evilVerticalMoveDown) {
			new Collision(this.getModel().getMap(), this.getModel().getEvilVertical(), this.getModel().getEvilVertical().getX(), this.getModel().getEvilVertical().getY() + 1, this);
		}
		else {
			new Collision(this.getModel().getMap(), this.getModel().getEvilVertical(), this.getModel().getEvilVertical().getX(), this.getModel().getEvilVertical().getY() - 1, this);
		}
	}
	
	public void setEvilVerticalMoveDown(boolean down) {
		this.evilVerticalMoveDown = down;
	}
	
	public boolean getEvilVerticalMoveDown() {
		return this.evilVerticalMoveDown;
	}
	
	@Override
	public void evilPingPongMove(int x, int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilPingPong.getX();
		int tempY = this.evilPingPong.getY();
		this.mapNiveau[x][y] = evilPingPong;
		this.mapNiveau[tempX][tempY] = temp;
		evilPingPong.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
		
	}
	
	public void evilPingPongMove() {
		switch(this.evilPingPongMove) {
		case 1 :
			System.out.println("Cas 1 ");
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() + 1, this.getModel().getEvilPingPong().getY() + 1 , this);
			break;
		case 2 : 
			System.out.println("Cas 2 ");
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() - 1, this.getModel().getEvilPingPong().getY() + 1 , this);
			break;
		case 3 :
			System.out.println("Cas 3 ");
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() - 1, this.getModel().getEvilPingPong().getY() - 1 , this);
			break;
		case 4 :
			System.out.println("Cas 4 ");
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() + 1, this.getModel().getEvilPingPong().getY() - 1 , this);
			break;
		}
	}
	
	public void setEvilPingPongMove(int nextMove) {
		this.evilPingPongMove = nextMove;
	}
	
	public int getEvilPingPongMove() {
		return this.evilPingPongMove;
	}
	
	@Override
	public void remove(int x, int y) {
		this.mapNiveau[x][y] = new Ground(new Position(x, y));
	}

	@Override
	public void died() {
		this.getView().displayMessage("Tu es mort !\nTon score est de : " + (int)this.score);
		this.getViewFacade().killFrame();
		this.running = false;
	}
	
	@Override
	public void win() {
		this.getView().displayMessage("Tu as fini le niveau, Bravo!\nTon score est de : " + (int)this.score);
		this.getViewFacade().killFrame();
		this.running = false;
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
	
	public void timer() {
		if (this.evilRandom != null) {
			this.evilRadomMove();
		}
		if (this.evilHorizontal != null) {
			this.evilHorizontalMove();
		}
		if(this.evilVertical != null) {
			this.evilVerticalMove();
		}
		if(this.evilPingPong != null) {
			this.evilPingPongMove();
		}
		try {
			Thread.sleep(250);
			if (this.running) {
				timer();
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	public Element getEvilVertical() {
		return evilVertical;
	}

	public void setEvilVertical(Element evilVertical) {
		this.evilVertical = evilVertical;
	}



}
