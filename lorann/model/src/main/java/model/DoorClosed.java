package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class DoorClosed extends MotionlessElement{

	static char sprite = 'C';
	static Permeability permeability = Permeability.COLLECATBLE;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/gate_closed.png"));
	static private Image image = icoImage.getImage();
	
	DoorClosed(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Cr�ation d'un objet DoorClosed");
	}
}
