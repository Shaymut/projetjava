package model;

public class Element {
	
	Permeability permeability;
	char sprite;
	String image;
	
	Element(Permeability permeability, char sprite, String image){
		this.permeability = permeability;
		this.sprite = sprite;
		this.image = image;
	}
}
