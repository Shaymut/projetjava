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
			if (MotionElement.getSprite() == 'F') {
				if (controller.getEvilHorizontalMoveRight()) {
					controller.setEvilHorizontalMoveRight(false);
				}else {
					controller.setEvilHorizontalMoveRight(true);
				}
				
			}else if (MotionElement.getSprite() == 'K') {
				if (controller.getEvilVerticalMoveDown()) {
					controller.setEvilVerticalMoveDown(false);
				}else {
					controller.setEvilVerticalMoveDown(true);
				}
			}
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.PENETRABLE) {
			System.out.println("PENETRABLE");
			if (MotionElement.getSprite() == 'L') {
				controller.lorannMove(x, y);
				
			}else if (MotionElement.getSprite() == 'B') {
				if (this.mapNiveau[x][y].getSprite() == 'L') {
					controller.remove(x,y);
					controller.evilRandomMove(x,y);
					controller.died();
				}else if (this.mapNiveau[x][y].getSprite() == 'O') {
					System.out.println("BLOCK");
				}else {
					controller.evilRandomMove(x,y);
				}
				
			}else if (MotionElement.getSprite() == 'F') {
			if (this.mapNiveau[x][y].getSprite() == 'L') {
				controller.remove(x,y);
				controller.evilHorizontalMove(x, y);
				controller.died();
			}else if (this.mapNiveau[x][y].getSprite() == 'O') {
				System.out.println("BLOCK");
			}else {
				controller.evilHorizontalMove(x,y);
				}
			}
			else if (MotionElement.getSprite() == 'K') {
				if (this.mapNiveau[x][y].getSprite() == 'L') {
					controller.remove(x,y);
					controller.evilVerticalMove(x, y);
					controller.died();
				}else if (this.mapNiveau[x][y].getSprite() == 'O') {
					System.out.println("BLOCK");
				}else {
					controller.evilVerticalMove(x,y);
				}
			}
			
			
			
			
			
			
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
				if (MotionElement.getSprite() == 'F') {
					if (controller.getEvilHorizontalMoveRight()) {
						controller.setEvilHorizontalMoveRight(false);
					}else {
						controller.setEvilHorizontalMoveRight(true);
					}
				}else if (MotionElement.getSprite() == 'K') {
					if (controller.getEvilVerticalMoveDown()) {
						controller.setEvilVerticalMoveDown(false);
					}else {
						controller.setEvilVerticalMoveDown(true);
					}
				}
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
				if (MotionElement.getSprite() == 'F') {
					if (controller.getEvilHorizontalMoveRight()) {
						controller.setEvilHorizontalMoveRight(false);
					}else {
						controller.setEvilHorizontalMoveRight(true);
					}
				}else if (MotionElement.getSprite() == 'K') {
					if (controller.getEvilVerticalMoveDown()) {
						controller.setEvilVerticalMoveDown(false);
					}else {
						controller.setEvilVerticalMoveDown(true);
					}
				}
				System.out.println("BLOCK");
			}
			
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.VICTORY) {
			if (MotionElement.getSprite() == 'L') {
				System.out.println("--------------------- WIN ---------------------");
				controller.remove(x,y);
				controller.lorannMove(x, y);
				controller.win();
			}else {
				if (MotionElement.getSprite() == 'F') {
					if (controller.getEvilHorizontalMoveRight()) {
						controller.setEvilHorizontalMoveRight(false);
					}else {
						controller.setEvilHorizontalMoveRight(true);
					}
				}else if (MotionElement.getSprite() == 'K') {
					if (controller.getEvilVerticalMoveDown()) {
						controller.setEvilVerticalMoveDown(false);
					}else {
						controller.setEvilVerticalMoveDown(true);
					}
				}
				System.out.println("BLOCK");
			}
		}
	}
	
}