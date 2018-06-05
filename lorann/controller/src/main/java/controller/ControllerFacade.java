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
	
	/** The niveau. */
	private int niveau;
    /** The view. */
    private final IView view;
    /** The model. */
    private final IModel model;
    /** The lorann. */
    private Element lorann;
    /** The spell. */
    private Element spell;
    /** The lastOrder. */
    private Order lastOrder = Order.DOWN;
    /** The HaveSpell. */
    private boolean HaveSpell = true;
    /** The spellMoveDirectionLorann. */
    private boolean spellMoveDirectionLorann = true;
    /** The evilRandom. */
    private Element evilRandom;
    /** The evilHorizontal. */
    private Element evilHorizontal;
    /** The evilHorizontalMoveRight. */
    private boolean evilHorizontalMoveRight = true;
    /** The evilVertical. */    
    private Element evilVertical;
    /** The evilVerticalMoveDown. */
    private boolean evilVerticalMoveDown = true;
    /** The evilPingPong. */
	private Element evilPingPong;
	/** The evilPingPongMove. */
    private int evilPingPongMove = 1;
    /** The viewFacade. */
    private ViewFacade viewFacade;
    /** The mapNiveau. */
    private Element[][] mapNiveau;
    /** The score. */
    private double score;
    /** The running. */
    private boolean running = true;
    /** The random. */
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
    
    /*
     * Gets the viewFacade.
     *
     * @return the viewFacade
     */
	public ViewFacade getViewFacade() {
		return viewFacade;
	}

	/**
     * Sets the viewFacade.
     *
     * @param viewFacade
     *            the new viewFacade
     */
	public void setViewFacade(ViewFacade viewFacade) {
		this.viewFacade = viewFacade;
	}
	
	/**
     * Gets the HaveSpell.
     *
     * @return the HaveSpell
     */
    public boolean getHaveSpell() {
		return this.HaveSpell;
	}
    
    /**
     * Sets the HaveSpell.
     *
     * @param HaveSpell
     *            the new HaveSpell
     */
	public void setHaveSpell(boolean haveSpell) {
		HaveSpell = haveSpell;
	}
	
	/**
     * Gets the spellMoveDirectionLorann.
     *
     * @return the spellMoveDirectionLorann
     */
	public boolean getSpellMoveDirectionLorann() {
		return spellMoveDirectionLorann;
	}
	
	/**
     * Sets the spellMoveDirectionLorann.
     *
     * @param spellMoveDirectionLorann
     *            the new spellMoveDirectionLorann
     */
	public void setSpellMoveDirectionLorann(boolean spellMoveDirectionLorann) {
		this.spellMoveDirectionLorann = spellMoveDirectionLorann;
	}
	
	/**
     * Sets the lastOrder.
     *
     * @param lastOrder
     *            the new lastOrder
     */
	public void setLastOrder(Order lastOrder) {
		this.lastOrder = lastOrder;
	}
	
	/**
     * Update the Lorann Move.
     */
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
	
	/**
     * Update the Lorann Move.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
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
		System.out.println("Score : " + this.score);
	}
	
	/**
     * Update the EvilRandom Move.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	public void evilRandomMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilRandom.getX();
		int tempY = this.evilRandom.getY();
		this.mapNiveau[x][y] = evilRandom;
		this.mapNiveau[tempX][tempY] = temp;
		evilRandom.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		//this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	/**
     * Update the EvilRandom Move.
     */
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
	
	/**
     * Update the EvilHorizontal Move.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	public void evilHorizontalMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilHorizontal.getX();
		int tempY = this.evilHorizontal.getY();
		this.mapNiveau[x][y] = evilHorizontal;
		this.mapNiveau[tempX][tempY] = temp;
		evilHorizontal.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		//this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	/**
     * Update the EvilHorizontal Move.
     */
	public void evilHorizontalMove() {
		if (evilHorizontalMoveRight) {
			new Collision(this.getModel().getMap(), this.getModel().getEvilHorizontal(), this.getModel().getEvilHorizontal().getX() + 1, this.getModel().getEvilHorizontal().getY(), this);
		}
		else {
			new Collision(this.getModel().getMap(), this.getModel().getEvilHorizontal(), this.getModel().getEvilHorizontal().getX() - 1, this.getModel().getEvilHorizontal().getY(), this);
		}
	}
	
	/**
     * Sets the evilHorizontalMoveRight.
     *
     * @param evilHorizontalMoveRight
     *            the new evilHorizontalMoveRight
     */
	public void setEvilHorizontalMoveRight(boolean right) {
		this.evilHorizontalMoveRight = right;
	}
	
	/**
     * Gets the evilHorizontalMoveRight.
     *
     * @return the evilHorizontalMoveRight
     */
	public boolean getEvilHorizontalMoveRight() {
		return this.evilHorizontalMoveRight;
	}
	
	/**
     * Update the EvilVerticalMove.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	public void evilVerticalMove(int x ,  int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilVertical.getX();
		int tempY = this.evilVertical.getY();
		this.mapNiveau[x][y] = evilVertical;
		this.mapNiveau[tempX][tempY] = temp;
		evilVertical.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		//this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
	}
	
	/**
     * Update the EvilVertical Move.
     */
	public void evilVerticalMove() {
		if (evilVerticalMoveDown) { 
			new Collision(this.getModel().getMap(), this.getModel().getEvilVertical(), this.getModel().getEvilVertical().getX(), this.getModel().getEvilVertical().getY() + 1, this);
		}
		else {
			new Collision(this.getModel().getMap(), this.getModel().getEvilVertical(), this.getModel().getEvilVertical().getX(), this.getModel().getEvilVertical().getY() - 1, this);
		}
	}
	
	/**
     * Sets the evilVerticalMoveDown.
     *
     * @param evilVerticalMoveDown
     *            the new evilVerticalMoveDown
     */
	public void setEvilVerticalMoveDown(boolean down) {
		this.evilVerticalMoveDown = down;
	}
	
	/**
     * Gets the evilVerticalMoveDown.
     *
     * @return the evilVerticalMoveDown
     */
	public boolean getEvilVerticalMoveDown() {
		return this.evilVerticalMoveDown;
	}
	
	/**
     * Update the EvilPingPong Move.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	@Override
	public void evilPingPongMove(int x, int y) {
		Element temp = this.mapNiveau[x][y];
		int tempX = this.evilPingPong.getX();
		int tempY = this.evilPingPong.getY();
		this.mapNiveau[x][y] = evilPingPong;
		this.mapNiveau[tempX][tempY] = temp;
		evilPingPong.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		//this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
		
	}
	
	/**
     * Update the EvilPingPong Move.
     */
	public void evilPingPongMove() {
		switch(this.evilPingPongMove) {
		case 1 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() + 1, this.getModel().getEvilPingPong().getY() + 1 , this);
			break;
		case 2 : 
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() - 1, this.getModel().getEvilPingPong().getY() + 1 , this);
			break;
		case 3 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() - 1, this.getModel().getEvilPingPong().getY() - 1 , this);
			break;
		case 4 :
			new Collision(this.getModel().getMap(), this.getModel().getEvilPingPong(), this.getModel().getEvilPingPong().getX() + 1, this.getModel().getEvilPingPong().getY() - 1 , this);
			break;
		}
	}
	
	/**
     * Sets the evilPingPongMove.
     *
     * @param evilPingPongMove
     *            the new evilPingPongMove
     */
	public void setEvilPingPongMove(int nextMove) {
		this.evilPingPongMove = nextMove;
	}
	
	/**
     * Gets the evilPingPongMove.
     *
     * @return the evilPingPongMove
     */
	public int getEvilPingPongMove() {
		return this.evilPingPongMove;
	}
	
	/**
     * Update the Spell Move.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	public void SpellMove(int x, int y) {/*
		Element temp = this.mapNiveau[x][y];
		int tempX = this.spell.getX();
		int tempY = this.spell.getY();
		this.mapNiveau[x][y] = spell;
		this.mapNiveau[tempX][tempY] = temp;
		spell.setPosition(new Position(x,y));
		this.getModel().setMap(this.mapNiveau);
		//this.getView().displayMap(this.mapNiveau);
		this.getViewFacade().setMap(mapNiveau);
		*/
	}
	
	/**
     * Update the Spell Move.
     */
	public void fire() {/*
		System.out.println("FIRE");
		if (this.spell != null) {
			switch(this.lastOrder) {
			case RIGHT:
				new Collision(this.getModel().getMap(), this.getModel().getSpell(), this.getModel().getSpell().getX() + 1, this.getModel().getSpell().getY(), this);
				break;
			case LEFT:
				new Collision(this.getModel().getMap(), this.getModel().getSpell(), this.getModel().getSpell().getX() - 1, this.getModel().getSpell().getY(), this);
				break;
			case UP:
				new Collision(this.getModel().getMap(), this.getModel().getSpell(), this.getModel().getSpell().getX(), this.getModel().getSpell().getY() - 1, this);
				break;
			case DOWN:
				new Collision(this.getModel().getMap(), this.getModel().getSpell(), this.getModel().getSpell().getX(), this.getModel().getSpell().getY() + 1, this);
				break;
			case LEFT_DOWN:
				break;
			case LEFT_UP:
				break;
			case NONE:
				break;
			case RIGHT_DOWN:
				break;
			case RIGHT_UP:
				break;
			case SPACE:
				break;
			}
		}else {
			switch(this.lastOrder) {
			case RIGHT:
				this.spell = new model.Spell(new Position(lorann.getX() + 1 ,lorann.getY()));
				this.setHaveSpell(false);
				break;
			case LEFT:
				this.spell = new model.Spell(new Position(lorann.getX() - 1 ,lorann.getY()));
				this.setHaveSpell(false);
				break;
			case UP:
				this.spell = new model.Spell(new Position(lorann.getX() ,lorann.getY() - 1 ));
				this.setHaveSpell(false);
				break;
			case DOWN:
				this.spell = new model.Spell(new Position(lorann.getX() ,lorann.getY() + 1));
				this.setHaveSpell(false);
				break;
			case LEFT_DOWN:
				break;
			case LEFT_UP:
				break;
			case NONE:
				break;
			case RIGHT_DOWN:
				break;
			case RIGHT_UP:
				break;
			case SPACE:
				break;
			}
		}*/		
	}
	
	/**
     * Gets the spell.
     *
     * @return the spell
     */
	public Element getSpell() {
		return spell;
	}
	
	/**
     * Sets the spell.
     *
     * @param spell
     *            the new spell
     */
	public void setSpell(Element spell) {
		this.spell = spell;
	}
	
	/**
     * Remove an Element in mapNiveau.
     *
     * @param x
     *            the new x
     * @param y
     *            the new y
     */
	@Override
	public void remove(int x, int y) {
		this.mapNiveau[x][y] = new Ground(new Position(x, y));
	}
	
	/**
     * Make the end of the programme with a death message.
     */
	@Override
	public void died() {
		this.getView().displayMessage("Tu es mort !\nTon score est de : " + (int)this.score);
		this.getViewFacade().killFrame();
		this.running = false;
	}
	
	/**
     * Make the end of the programme with a win message.
     */
	@Override
	public void win() {
		this.getView().displayMessage("Tu as fini le niveau, Bravo!\nTon score est de : " + (int)this.score);
		this.getViewFacade().killFrame();
		this.running = false;
	}
	
	/**
     * Increments the score with x.
     *
     * @param x
     *            the new x
     */
	@Override
	public void scoreUp(double x) {
		this.score = score + x;
	}
	
	/**
     * Replace the door closed by a open door in the map.
     */
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
	
	/**
     * Sets the running.
     *
     * @param running
     *            the new running
     */
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	/**
     * Timer for the evil's move.
     */
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
	
	/**
     * Gets the evilVertical.
     *
     * @return the evilVertical
     */
	public Element getEvilVertical() {
		return evilVertical;
	}
	
	/**
     * Sets the evilVertical.
     *
     * @param evilVertical
     *            the new evilVertical
     */
	public void setEvilVertical(Element evilVertical) {
		this.evilVertical = evilVertical;
	}


}
