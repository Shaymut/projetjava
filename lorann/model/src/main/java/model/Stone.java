package model;

public class Stone extends MotionlessElement{

	static char sprite = 'X';
	static String image = "bone.png";
	static Permeability permeability = Permeability.BLOCK;
	
	Stone(Position position) {
		super(permeability, sprite, image, position);
	}
}