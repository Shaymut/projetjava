package model;

public class DoorClosed extends MotionlessElement{

	/**
	 * 
	 * Caract�re utilis� pour la BDD
	 * 
	 * @see DoorClosed#DoorClosed(Position) 
	 */
	
	static char sprite = 'C';
	
	/**
	 * 
	 * Permeabilit� de l'objet
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
		System.out.println("Cr�ation d'un objet DoorClosed");
	}
}
