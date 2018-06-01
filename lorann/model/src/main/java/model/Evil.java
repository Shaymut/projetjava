package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Evil extends Mobile implements Kill{

	static Permeability permeability = Permeability.BLOCK;
	
	Evil(char sprite, Image image, Position position,ImageIcon icoImage) {
		super(permeability, sprite, image, position, icoImage);
		// TODO Auto-generated constructor stub
		System.out.println("Création d'un objet Evil");
	
	}
	
	

	public void kill() {
		
	
		
	}
	


}
