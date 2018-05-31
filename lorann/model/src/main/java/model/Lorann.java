package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Lorann extends Mobile{
	
	public static boolean setAlive;
	public static boolean HaveASpell;

	Lorann(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
		super(permeability, sprite, image, position, icoImage);
		// TODO Auto-generated constructor stub
	}
	
	public boolean HaveASpell() {
		
		
		
		return true;
	}
	
	public void PickUp() {
		
	}

}
