package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ground extends MotionlessElement{

	static char sprite = 'X';
	static Permeability permeability = Permeability.PENETRABLE;
	static public  ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/ground.png"));
	static public Image image = icoImage.getImage();
	
	Ground(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet Ground");
	}
}