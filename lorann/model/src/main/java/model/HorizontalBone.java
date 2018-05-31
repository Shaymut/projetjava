package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class HorizontalBone extends MotionlessElement{

	static char sprite = 'H';
	static Permeability permeability = Permeability.BLOCK;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/horizontal_bone.png"));
	static private Image image = icoImage.getImage();
	
	
	HorizontalBone(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet HorizontalBone");
	}
}