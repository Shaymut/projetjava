package model;

public class Gold extends MotionlessElement{

	static char sprite = 'G';
	static String image = "/Pictures/purse.png";
	static Permeability permeability = Permeability.COLLECATBLE;
	
	Gold(Position position) {
		super(permeability, sprite, image, position);
		System.out.println("Cr�ation d'un objet Gold");
	}
}
