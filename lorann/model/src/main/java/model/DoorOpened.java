package model;

public class DoorOpened extends MotionlessElement{

	static char sprite = 'O';
	// "/Pictures/gate_open.png";
	static Permeability permeability = Permeability.PENETRABLE;
	
	
	public DoorOpened(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet DoorOpened");
	}
} 
