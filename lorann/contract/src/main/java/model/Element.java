package model;

public class Element {
	
	Permeability permeability;
	char sprite;
	Position position;
	
	public Element(Permeability permeability, char sprite, Position position){
		this.permeability = permeability;
		this.sprite = sprite;
		this.position = position;
	}
	
	public char getSprite() {
		return this.sprite;
	}
	
	public  int getX() {
		return this.position.getX();
	}
	
	public int getY() {
		return this.position.getY();
	}
	
	public  void setX(int x) {
		this.position.x = x;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setY(int y) {
		this.position.y = y;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}
}
