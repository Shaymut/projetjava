package model;

public class Gold extends MotionlessElement{

	static char sprite = 'G';
	static Permeability permeability = Permeability.COLLECATBLE;
	
	Gold(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Gold");
	}
}
