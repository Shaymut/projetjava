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
			}else if (MotionElement.getSprite() == 'J') {
				switch(controller.getEvilPingPongMove()) {
				case 1 :
					controller.setEvilPingPongMove(2);
					break;
				case 2 :
					controller.setEvilPingPongMove(3);
					break;
				case 3 :
					controller.setEvilPingPongMove(4);
					break;
				case 4 :
					controller.setEvilPingPongMove(1);
					break;
				}
			}/*else if (MotionElement.getSprite() == 'P') {
				if (controller.getSpellMoveDirectionLorann()) {
					controller.setSpellMoveDirectionLorann(false);
				}else {
					controller.setSpellMoveDirectionLorann(true);
				}
				System.out.println("BLOOCKK");
			}*/
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.PENETRABLE) {
			if (MotionElement.getSprite() == 'L') {
				controller.lorannMove(x, y);
				
			}else if (MotionElement.getSprite() == 'B') {
				if (this.mapNiveau[x][y].getSprite() == 'L') {
					controller.remove(x,y);
					controller.evilRandomMove(x,y);
					controller.died();
				}else if (this.mapNiveau[x][y].getSprite() == 'O') {
				}else {
					controller.evilRandomMove(x,y);
				}
				
			}else if (MotionElement.getSprite() == 'F') {
			if (this.mapNiveau[x][y].getSprite() == 'L') {
				controller.remove(x,y);
				controller.evilHorizontalMove(x, y);
				controller.died();
			}else if (this.mapNiveau[x][y].getSprite() == 'O') {
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
				}else {
					controller.evilVerticalMove(x,y);
				}
			}
			else if (MotionElement.getSprite() == 'J') {
				if (this.mapNiveau[x][y].getSprite() == 'L') {
					controller.remove(x,y);
					controller.evilPingPongMove(x, y);
					controller.died();
				}else if (this.mapNiveau[x][y].getSprite() == 'O') {
				}else {
					controller.evilPingPongMove(x,y);
				}
			}
			/*else if (MotionElement.getSprite() == 'P') {
				if (this.mapNiveau[x][y].getSprite() == 'L') {
					controller.remove(MotionElement.getX(), MotionElement.getY());
					controller.setHaveSpell(true);
				}else if (this.mapNiveau[x][y].getSprite() == 'O') {
				}else {
					controller.SpellMove(x, y);
				}
			}*/
			
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.COLLECTABLE) {
			if (MotionElement.getSprite() == 'L') {
				if (this.mapNiveau[x][y].getSprite() == 'E') {
					controller.replaceDoor();
				}else {
					controller.scoreUp(650);
				}
				controller.remove(x, y);
				controller.lorannMove(x, y);
			}else if (MotionElement.getSprite() == 'F') {
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
			else if (MotionElement.getSprite() == 'J') {
				switch(controller.getEvilPingPongMove()) {
				case 1 :
					controller.setEvilPingPongMove(2);
					break;
				case 2 :
					controller.setEvilPingPongMove(3);
					break;
				case 3 :
					controller.setEvilPingPongMove(4);
					break;
				case 4 :
					controller.setEvilPingPongMove(1);
					break;
				}
			}	
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.HURT) {
			if (MotionElement.getSprite() == 'L') {
				System.out.println("--------------------- DIED ---------------------");
				controller.remove(x,y);
				controller.setRunning(false);
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
				else if (MotionElement.getSprite() == 'J') {
					switch(controller.getEvilPingPongMove()) {
					case 1 :
						controller.setEvilPingPongMove(2);
						break;
					case 2 :
						controller.setEvilPingPongMove(3);
						break;
					case 3 :
						controller.setEvilPingPongMove(4);
						break;
					case 4 :
						controller.setEvilPingPongMove(1);
						break;
					}
				}
			}
			
			
			
			
			
		}else if (this.mapNiveau[x][y].getPermeability() == Permeability.VICTORY) {
			if (MotionElement.getSprite() == 'L') {
				System.out.println("--------------------- WIN ---------------------");
				controller.remove(x,y);
				controller.setRunning(false);
				controller.lorannMove(x, y);
				controller.win();
			}else if (MotionElement.getSprite() == 'F') {
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
				else if (MotionElement.getSprite() == 'J') {
					switch(controller.getEvilPingPongMove()) {
					case 1 :
						controller.setEvilPingPongMove(2);
						break;
					case 2 :
						controller.setEvilPingPongMove(3);
						break;
					case 3 :
						controller.setEvilPingPongMove(4);
						break;
					case 4 :
						controller.setEvilPingPongMove(1);
						break;
					}
				}
			}
		}
}