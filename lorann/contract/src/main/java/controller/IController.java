package controller;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	public void updatemoveLorann();
	
	public void lorannMove(int x, int y);
	
	//public void evilRandomMove( int x ,  int y);

	public void remove(int x, int y);

	public void died();
	
	public void win();
	
	public void scoreUp(double x);
	
	public void replaceDoor();
}
