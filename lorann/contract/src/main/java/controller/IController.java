package controller;

import view.Order;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	public void updatemoveLorann();
	
	public void lorannMove(int x, int y);
	
	public void remove(int x, int y);
	
	public void setRunning(boolean running);

	public void died();
	
	public void win();
	
	public void scoreUp(double x);
	
	public void replaceDoor();
	
	public void evilRandomMove(int x, int y);
	
	public void evilHorizontalMove(int x, int y);
	public boolean getEvilHorizontalMoveRight();
	public void setEvilHorizontalMoveRight(boolean right);
	
	public void evilVerticalMove(int x, int y );
	public boolean getEvilVerticalMoveDown();
	public void setEvilVerticalMoveDown(boolean down);
	
	public void evilPingPongMove(int x, int y );
	public int getEvilPingPongMove();
	public void setEvilPingPongMove(int nextMove);
	
	public boolean getHaveSpell();
	public void setHaveSpell(boolean haveSpell);
	public boolean getSpellMoveDirectionLorann();
	public void setSpellMoveDirectionLorann(boolean spellMoveDirectionLorann);
	public void setLastOrder(Order lastOrder);
	public void fire();
	public void SpellMove(int x, int y);
}
