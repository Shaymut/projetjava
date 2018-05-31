package model;

public class Gold extends MotionlessElement{

	static char sprite = 'G';
	static String image = "purse.png";
	static Permeability permeability = Permeability.COLLECATBLE;
	
	Gold(Position position) {
		super(permeability, sprite, image, position);
	}
}
