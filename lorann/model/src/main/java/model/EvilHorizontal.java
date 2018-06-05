package model;

public class EvilHorizontal extends Evil {
	
	/**
	 * 
	 * character used for BDD
	 * 	 
	 * @see EvilHorizontal#EvilHorizontal(Position) 
	 */
	static char sprite = 'F';
	
	/**
	 * 
	 * Constructor EvilHorizontal
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	EvilHorizontal(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilHorizontal");
	}


	
	

}
	
