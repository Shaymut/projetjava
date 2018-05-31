package model;

public class Element {
	
	Permeability permeability;
	char sprite;
	String image;
	Position position;
	
	Element(Permeability permeability, char sprite, String image, Position position){
		this.permeability = permeability;
		this.sprite = sprite;
		this.image = image;
		this.position = position;
	}
}
