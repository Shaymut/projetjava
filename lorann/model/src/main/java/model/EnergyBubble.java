package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'P';
	static Permeability permeability = Permeability.COLLECTABLE;
	static private ImageIcon icoImage = new ImageIcon(DoorClosed.class.getResource("/Pictures/cristal_ball.png"));
	static private Image image = icoImage.getImage();
	
	EnergyBubble(Position position) {
		super(permeability, sprite, image, position, icoImage);
		System.out.println("Cr�ation d'un objet EnergyBubble");
	}
}