package model;

public class DoorClosed extends MotionlessElement{

	/**
	 * 
	 * character used for BDD
	 * 
	 * @see DoorClosed#DoorClosed(Position) 
	 */
	
	static char sprite = 'C';
	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see DoorClosed#DoorClosed(Position)
	 */
	
	static Permeability permeability = Permeability.HURT;
	
	/**
	 * 
	 * Constructor DoorClosed
	 * 
	 * @param position
	 * We get the position of this object
	 */
	
	DoorClosed(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet DoorClosed");
	}
}
