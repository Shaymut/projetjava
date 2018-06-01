package model;

public class Element {
	
	Permeability permeability;
	char sprite;
	Position position;
	
	Element(Permeability permeability, char sprite, Position position){
		this.permeability = permeability;
		this.sprite = sprite;
		this.position = position;
	}
	
	public char getSprite() {
		return this.sprite;
	}
	
	public int getX() {
		return this.position.getX();
	}
	
	public int getY() {
		return this.position.getY();
	}
	
}
