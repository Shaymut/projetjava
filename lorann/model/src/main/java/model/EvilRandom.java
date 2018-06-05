package model;



public class EvilRandom extends Evil {
	
	/**
	 * 
	 * character used for BDD
	 * 
	 * @see EvilRandom#EvilRandom(Position) 
	 */
	static char sprite = 'B';
	
	/**
	 * 
	 * Constructor EvilRandom
	 * 
     * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	EvilRandom(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilRandom");
	}
	
	

	    }

	

