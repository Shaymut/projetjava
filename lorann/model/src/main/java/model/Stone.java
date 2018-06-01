package model;

public class Stone extends MotionlessElement{

	static char sprite = 'S';
	static Permeability permeability = Permeability.BLOCK;
	
	Stone(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Stone");
	}
}