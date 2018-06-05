package model;

public class EvilVertical extends Evil {
	
	/**
	 * 
	 * character used for BDD
	 * 
	 * @see EvilVertical#EvilVertical(Position) 
	 */
	static char sprite = 'K';
	

	/**
	 * 
	 * Constructor EvilVertical
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	EvilVertical(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilVertical");
	}




}
