package controller;

import model.Element;

public class Collision {
	
	Element[][] mapNiveau;
	Element lorann;
	
	public Collision(Element[][] mapNiveau, Element lorann) {
		this.mapNiveau = mapNiveau;
		this.lorann = lorann;
	}
	
	public void test() {
		System.out.println(this.lorann.getX() + " , " + this.lorann.getY());
	}
	
	public void Check() {
		
	}
	
}