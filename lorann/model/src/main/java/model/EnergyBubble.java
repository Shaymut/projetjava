package model;

public class EnergyBubble extends MotionlessElement{
	
	
	/**
	 * 
	 * character used for BDD 
	 * 
	 * @see EnergyBubble#EnergyBubble(Position) 
	 */
	
	static char sprite = 'E';
	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see EnergyBubble#EnergyBubble(Position)
	 */
	
	static Permeability permeability = Permeability.COLLECTABLE;
	

	/**
	 * 
	 * Constructor EnergyBubble
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	

	EnergyBubble(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet EnergyBubble");
	}
}