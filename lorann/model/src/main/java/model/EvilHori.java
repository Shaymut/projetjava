package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EvilHori extends Evil implements EvilMove{
	
	static char sprite = 'A';
	static private ImageIcon icoImage = new ImageIcon(Evil.class.getResource("/Pictures/monster_1.png"));
	static Image image = icoImage.getImage();
	
	
	EvilHori(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
		super(sprite, image, position, icoImage);
		// TODO Auto-generated constructor stub
		System.out.println("Création d'un objet EvilHori");
	}
	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		
		
	}


	public static Image getImage() {
		return image;
	}


	public static void setImage(Image image) {
		EvilHori.image = image;
	}

}
