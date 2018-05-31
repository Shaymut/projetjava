package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class DoorOpened extends MotionlessElement{

	static char sprite = 'O';
	// "/Pictures/gate_open.png";
	static Permeability permeability = Permeability.PENETRABLE;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/gate_open.png"));
	static private Image image = icoImage.getImage();
	
	
	DoorOpened(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Création d'un objet DoorOpened");
	}
} 
