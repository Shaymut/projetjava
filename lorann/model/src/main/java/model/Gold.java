package model;

public class Gold extends MotionlessElement{

	static char sprite = 'G';
	static Permeability permeability = Permeability.COLLECTABLE;
	
	Gold(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Gold");
	}
	
	public void Replace(){
/*		if(Recup == true) {
		
		}*/
	}
}
