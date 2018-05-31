package model;

public class Ground extends MotionlessElement{

	static char sprite = 'X';
	static String image = "ground.png";
	static Permeability permeability = Permeability.PENETRABLE;
	
	Ground(Position position) {
		super(permeability, sprite, image, position);
	}
}