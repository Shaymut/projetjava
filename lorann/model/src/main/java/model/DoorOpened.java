package model;

public class DoorOpened extends MotionlessElement{

	static char sprite = 'O';
	static String image = "/Pictures/gate_open.png";
	static Permeability permeability = Permeability.PENETRABLE;
	
	DoorOpened(Position position) {
		super(permeability, sprite, image, position);
	}
} 
