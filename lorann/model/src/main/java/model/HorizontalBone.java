package model;

public class HorizontalBone extends MotionlessElement{

	static char sprite = 'H';
	static String image = "horizontal_bone.png";
	static Permeability permeability = Permeability.BLOCK;
	
	HorizontalBone(Position position) {
		super(permeability, sprite, image, position);
	}
}