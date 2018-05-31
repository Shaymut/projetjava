package model;

public class Ground extends MotionlessElement{

	static char sprite = 'X';
	static String image = "/Pictures/ground.png";
	static Permeability permeability = Permeability.PENETRABLE;
	
	Ground(Position position) {
		super(permeability, sprite, image, position);
		System.out.println("Création d'un objet Ground");
	}
}