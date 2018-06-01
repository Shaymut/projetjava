package model;

public class EvilRandom extends Evil implements EvilMove{
	
	static char sprite = 'B';
	
	EvilRandom(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilRandom");
	}
	
	
	@Override
	public void move() {
		
	}

}