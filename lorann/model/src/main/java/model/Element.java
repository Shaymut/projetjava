package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Element {
	
	Permeability permeability;
	char sprite;
	Image image;
	ImageIcon icoImage;
	Position position;
	
	Element(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage){
		this.permeability = permeability;
		this.sprite = sprite;
		this.image = image;
		this.position = position;
		this.icoImage = icoImage;
	}
	
	public char getSprite() {
		return this.sprite;		
	}
}
