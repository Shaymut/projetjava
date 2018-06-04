package controller;

import model.Element;
import model.Permeability;

public class Collision {
	
	Element[][] mapNiveau;
	Element MotionElement;
	IController controller;
	
	public Collision(Element[][] mapNiveau, Element MotionElement, int x, int y, IController controller) {
		this.mapNiveau = mapNiveau;
		this.MotionElement = MotionElement;
		if (this.mapNiveau[x][y].getPermeability() == Permeability.BLOCK) {
			System.out.println("BLOCK");
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.PENETRABLE) {
			System.out.println("PENETRABLE");
			if (MotionElement.getSprite() == 'L') {
				controller.lorannMove(x, y);
			}/*else if (MotionElement.getSprite() == 'B') {
				controller.evilRandomMove(x,y);
			}*/
			
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.COLLECTABLE) {
			System.out.println("COLLECTABLE");
			if (MotionElement.getSprite() == 'L') {
				if (this.mapNiveau[x][y].getSprite() == 'E') {
					controller.replaceDoor();
				}else {
					controller.scoreUp(650);
				}
				controller.remove(x, y);
				controller.lorannMove(x, y);
			}else {
				System.out.println("BLOCK");
			}
		}
		
		
		
		
		
		else if (this.mapNiveau[x][y].getPermeability() == Permeability.HURT) {
			if (MotionElement.getSprite() == 'L') {
				System.out.println("--------------------- DIED ---------------------");
				controller.remove(x,y);
				controller.lorannMove(x, y);
				controller.died();
			}else {
				System.out.println("BLOCK");
			}
			
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.VICTORY) {
			if (MotionElement.getSprite() == 'L') {
				System.out.println("--------------------- WIN ---------------------");
				controller.remove(x,y);
				controller.lorannMove(x, y);
				controller.win();
			}else {
				System.out.println("BLOCK");
			}
		}
	}
	
}