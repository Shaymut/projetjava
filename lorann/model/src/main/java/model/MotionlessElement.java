package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class MotionlessElement extends Element{

	MotionlessElement(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
		super(permeability, sprite, image, position, icoImage);
	}
	
}
