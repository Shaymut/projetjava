package model;

public class EvilPingPong extends Evil {
	
	/**
	 * 
	 * character used for BDD
 	 * 
	 * @see EvilPingPong#EvilPingPong(Position) 
	 */
	
	static char sprite = 'J';
	
	/**
	 * 
	 * Constructor EvilPingPong
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	EvilPingPong(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilStalker");
	}
	
	


}
