package model;

public class Evil extends MobileElement{

	static Permeability permeability = Permeability.HURT;
	public Position position ; 
	int nextX;
	int nextY;
	
	Evil(char sprite, Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet Evil");
	
	}
	/*
	public void move() {
	}*/


}
