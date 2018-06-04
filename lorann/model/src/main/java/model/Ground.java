package model;

public class Ground extends MotionlessElement{

	static char sprite = 'X';
	static Permeability permeability = Permeability.PENETRABLE;
	
	public Ground(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Ground");
	}
}