package model;

public class DoorClosed extends MotionlessElement{

	static char sprite = 'C';
	static Permeability permeability = Permeability.COLLECATBLE;
	
	DoorClosed(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet DoorClosed");
	}
}
