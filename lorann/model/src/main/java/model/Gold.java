package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gold extends MotionlessElement{

	static char sprite = 'G';
	static Permeability permeability = Permeability.COLLECATBLE;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/purse.png"));
	static private Image image = icoImage.getImage();
	
	Gold(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet Gold");
	}
}
