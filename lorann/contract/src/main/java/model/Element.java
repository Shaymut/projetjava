package model;

import java.util.Random;

public class Element {
	
	Permeability permeability;
	char sprite;
	static Position position;
	Random random = new Random();
	
	public Element(Permeability permeability, char sprite, Position position){
		this.permeability = permeability;
		this.sprite = sprite;
		Element.position = position;
	}
	
	public char getSprite() {
		return this.sprite;
	}
	
	public  int getX() {
		return Element.position.getX();
	}
	
	public int getY() {
		return Element.position.getY();
	}
	
	public  void setX(int x) {
		Element.position.x = x;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setY(int y) {
		Element.position.y = y;
	}
	
	public void setPosition(Position position) {
		Element.position = position;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}
	
}
