package model;

public class DoorClosed extends MotionlessElement{

	/**
	 * 
	 * Caractère utilisé pour la BDD
	 * 
	 * @see DoorClosed#DoorClosed(Position) 
	 */
	
	static char sprite = 'C';
	
	/**
	 * 
	 * Permeabilité de l'objet
	 * 
	 * @see DoorClosed#DoorClosed(Position)
	 */
	
	static Permeability permeability = Permeability.HURT;
	
	/**
	 * 
	 * Constructeur DoorClosed
	 * 
	 * @param position
	 */
	
	DoorClosed(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet DoorClosed");
	}
}
