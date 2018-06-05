package model;

public class Spell extends MobileElement {

	static private char sprite = 'P';
	static Permeability permeability= Permeability.COLLECTABLE;
	
	public Spell(Position position) {
		super(permeability, sprite, position);
	}

	public char getSprite() {
		return sprite;
	}

	
}

