package model;

public class VerticalBone extends MotionlessElement{

	static char sprite = 'V';
	static String image = "/Pictures/vertical_bone.png";
	static Permeability permeability = Permeability.BLOCK;
	
	VerticalBone(Position position) {
		super(permeability, sprite, image, position);
	}
}