package model;

public class VerticalBone extends MotionlessElement{

	static char sprite = 'V';
	static Permeability permeability = Permeability.BLOCK;
	
	VerticalBone(Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet VerticalBone");
	}
}