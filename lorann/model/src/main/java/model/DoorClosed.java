package model;

public class DoorClosed extends MotionlessElement{

	static char sprite = 'C';
	static String image = "gate_closed.png";
	static Permeability permeability = Permeability.COLLECATBLE;
	
	DoorClosed(Position position) {
		super(permeability, sprite, image, position);
	}
}
