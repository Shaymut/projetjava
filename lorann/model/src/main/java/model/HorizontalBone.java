package model;

public class HorizontalBone extends MotionlessElement{

	static char sprite = 'H';
	static Permeability permeability = Permeability.BLOCK;
	
	HorizontalBone(Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet HorizontalBone");
	}
}