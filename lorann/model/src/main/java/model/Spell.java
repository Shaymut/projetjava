package model;

public class Spell extends Mobile implements Hit{

	static private char sprite = 'P';
	static Permeability permeability= Permeability.BLOCK;
	
	
	Spell(Position position) {
		super(permeability, sprite, position);
	}
	

	public char getSprite() {
		return sprite;
	}

	
	/*
	public static void hit() {
		
		Position Evil_x = Evil.getX();
		
		Position Evil_y = Evil.getY();
		
		Position Spell_x = Spell.getX();
		
		Position Spell_y = Spell.getX();
		if (Evil_x == Spell_x && Evil_y == Spell_y) {
			Evil.setAlive = false;
			
			Spell.setAlive = false;
			
			Lorann.HaveASpell = true;
		}
		
	}*/
	
}
