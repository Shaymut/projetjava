package model;

public class DoorClosed extends MotionlessElement{

	static char sprite = 'C';
	static Permeability permeability = Permeability.COLLECATBLE;
	
	DoorClosed(Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet DoorClosed");
	}
}
