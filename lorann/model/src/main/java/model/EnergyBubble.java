package model;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'P';
	
	static Permeability permeability = Permeability.COLLECTABLE;

	EnergyBubble(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet EnergyBubble");
	}
}