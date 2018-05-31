package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Stone extends MotionlessElement{

	static char sprite = 'X';
	static Permeability permeability = Permeability.BLOCK;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/bone.png"));
	static private Image image = icoImage.getImage();
	
	Stone(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet Stone");
	}
}