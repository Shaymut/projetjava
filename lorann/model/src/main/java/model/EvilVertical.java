package model;

import java.awt.Image;

public class EvilVertical extends Evil implements EvilMove{
	
	static char sprite = 'B';
	
	
	EvilVertical(Permeability permeability, char sprite, Image image, Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilHori");
	}


	@Override
	public void move() {
		
	}

	/*
	public static Image getImage() {
		return image;
	}


	public static void setImage(Image image) {
		EvilHori.image = image;
	}*/

}
