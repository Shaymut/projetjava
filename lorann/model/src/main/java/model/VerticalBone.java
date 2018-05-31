package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class VerticalBone extends MotionlessElement{

	static char sprite = 'V';
	static Permeability permeability = Permeability.BLOCK;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/vertical_bone.png"));
	static private Image image = icoImage.getImage();
	
	VerticalBone(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet VerticalBone");
	}
}