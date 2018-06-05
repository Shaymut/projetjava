package model;

public class DoorOpened extends MotionlessElement{


	/**
	 * 
	 * character used for BDD
	 * 
	 * @see DoorOpened#DoorOpened(Position) 
	 */
	
	static char sprite = 'O';

	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see DoorOpened#DoorOpened(Position)
	 */
	
	static Permeability permeability = Permeability.VICTORY;
	
	/**
	 * 
	 * Constructor DoorOpened
	 * 
     * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	public DoorOpened(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet DoorOpened");
	}
} 
