package model;

public class EvilVertical extends Evil implements EvilMove{
	
	static char sprite = 'K';
	
	EvilVertical(Position position) {
		super(sprite, position);
		System.out.println("Cr�ation d'un objet EvilVertical");
	}


	@Override
	public void move() {
		
	}

}
