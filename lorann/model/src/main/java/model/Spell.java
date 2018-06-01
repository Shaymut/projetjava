package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Spell extends Mobile implements Hit{

	static private char sprite = 'P';
	static Permeability permeability= Permeability.BLOCK;
	static private ImageIcon icoImage = new ImageIcon(Spell.class.getResource("/Pictures/fireball_1.png"));
	static private Image image = icoImage.getImage();

	Spell(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
		super(permeability, sprite, image, position, icoImage);
		// TODO Auto-generated constructor stub

	}

	public char getSprite() {
		return sprite;
	}


	public Image getImage() {
		return image;
	}
	
	/*
	public static void hit() {
		
	/*	Position Evil_x = Evil.getX();
		
		Position Evil_y = Evil.getY();
		
		Position Spell_x = Spell.getX();
		
		Position Spell_y = Spell.getX();
		if (Evil_x == Spell_x && Evil_y == Spell_y) {
			Evil.setAlive = false;
			
			Spell.setAlive = false;
			
			Lorann.HaveASpell = true;
		}
		
	}*/
}

