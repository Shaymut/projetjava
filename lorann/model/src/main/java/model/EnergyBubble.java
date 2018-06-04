package model;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'E';
	
	static Permeability permeability = Permeability.COLLECTABLE;

	EnergyBubble(Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet EnergyBubble");
	}
}