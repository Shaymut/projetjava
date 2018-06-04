package controller;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {

	public void updatemove();
	
	public void lorannMove(int x, int y);

	public void remove(int x, int y);

	public void died();
}
