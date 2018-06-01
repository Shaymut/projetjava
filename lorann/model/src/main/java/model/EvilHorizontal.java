package model;

public class EvilHorizontal extends Evil implements EvilMove{
	
	static char sprite = 'F';
	
	EvilHorizontal(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilHorizontal");
	}
	
	
	@Override
	public void move() {
		
	}

}
	
