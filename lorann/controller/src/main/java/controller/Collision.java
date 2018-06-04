package controller;

import model.Element;
import model.Permeability;

public class Collision {
	
	Element[][] mapNiveau;
	Element lorann;
	IController controller;
	
	public Collision(Element[][] mapNiveau, Element lorann, int x, int y, IController controller) {
		this.mapNiveau = mapNiveau;
		this.lorann = lorann;
		if (this.mapNiveau[x][y].getPermeability() == Permeability.BLOCK) {
			System.out.println("BLOCK");
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.PENETRABLE) {
			System.out.println("PENETRABLE");
			controller.lorannMove(x, y);
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.COLLECTABLE) {
			System.out.println("COLLECTABLE");
			controller.remove(x,y);
			controller.lorannMove(x, y);
		}
		else if (this.mapNiveau[x][y].getPermeability() == Permeability.HURT) {
			System.out.println("--------------------- DIED ---------------------");
			controller.remove(x,y);
			controller.lorannMove(x, y);
			controller.died();
		}
	}
	
}