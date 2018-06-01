package model;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'P';
	static Permeability permeability = Permeability.COLLECATBLE;
	
	EnergyBubble(Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet EnergyBubble");
	}
}