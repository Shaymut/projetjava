package model;

public class EvilStalker extends Evil implements EvilMove{
	
	static char sprite = 'J';
	
	EvilStalker(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilStalker");
	}
	
	
	@Override
	public void move() {
		
	}

}
