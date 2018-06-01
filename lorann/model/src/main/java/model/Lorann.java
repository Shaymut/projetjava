package model;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Lorann extends Mobile{
	
	public long score;
	public  boolean HaveASpell;
	public boolean Recup;


	Lorann(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
		super(permeability, sprite, image, position, icoImage);
		// TODO Auto-generated constructor stub
	}
	
	public boolean HaveASpell() {
		return true;
	}
	

	public boolean PickUp() {
		if(permeability == Permeability.COLLECTABLE) {
			setScore(getScore()+650);
		Recup = true;
		}else if(permeability != Permeability.COLLECTABLE) {
			Recup = false;
		}
		return Recup;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
}
