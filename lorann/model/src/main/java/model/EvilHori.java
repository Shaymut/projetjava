package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EvilHori extends Evil implements EvilMove{
	
	static char sprite = 'A';
	
	EvilHori(Position position) {
		super(sprite, position);
		// TODO Auto-generated constructor stub
		System.out.println("Création d'un objet EvilHori");
	}
	
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		
		
	}
}
