package model;

public class EvilPingPong extends Evil implements EvilMove{
	
	static char sprite = 'J';
	
	EvilPingPong(Position position) {
		super(sprite, position);
		System.out.println("Cr�ation d'un objet EvilStalker");
	}
	
	
	@Override
	public void move() {
		
	}

}
