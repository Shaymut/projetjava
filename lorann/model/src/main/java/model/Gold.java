package model;

public class Gold extends MotionlessElement{

	/**
	 * 
	 * character used for BDD
	 * 
	 * @see Gold#Gold(Position) 
	 */
	
	static char sprite = 'G';
	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see Gold#Gold(Position)
	 */
	
	static Permeability permeability = Permeability.COLLECTABLE;
	
	/**
	 * 
	 * Constructor Gold
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	Gold(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Gold ");
	}

}
