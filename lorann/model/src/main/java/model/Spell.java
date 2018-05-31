package model;

public class Spell extends Mobile implements Hit{

	private static boolean setAlive;

	private char sprite = 'P';
	
	private String image = "";
	
	
	Spell(Permeability permeability, char sprite, String image, Position position) {
		super(permeability, sprite, image, position);
		// TODO Auto-generated constructor stub
	}


	public char getSprite() {
		return sprite;
	}


	public void setSprite(char sprite) {
		this.sprite = sprite;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	public static void hit() {
		
		Position Evil_x = Evil.getX();
		
		Position Evil_y = Evil.getY();
		
		Position Spell_x = Spell.getX();
		
		Position Spell_y = Spell.getX();
		/*
		if (Evil_x == Spell_x && Evil_y == Spell_y) {
			Evil.setAlive = false;
			
			Spell.setAlive = false;
			
			Lorann.HaveASpell = true;
		}*/
		
	}
	
}
