package model;

import java.util.List;

public class Map {
	
	Element[][] mapNiveau = new Element[20][12];
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	MobileElementFactory mobileElementFactory = new MobileElementFactory();
	Lorann lorann;
	
	public void CreateMap(List<Tile> ListTiles) {
		for (Tile tile : ListTiles) {
			if (tile.getSprite() == 'S'||
				tile.getSprite() == 'H' || 
				tile.getSprite() == 'V' ||
				tile.getSprite() == 'X' || 
				tile.getSprite() == 'G' ||
				tile.getSprite() == 'E' || 
				tile.getSprite() == 'C' ||
				tile.getSprite() == 'O') {
				mapNiveau[tile.getX()][tile.getY()] = motionlessElementFactory.createMotionlessElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
			}
			else if (tile.getSprite() == 'P' ||
					 tile.getSprite() == 'F' ||
					 tile.getSprite() == 'K' ||
					 tile.getSprite() == 'B' ||
					 tile.getSprite() == 'J'){
				mapNiveau[tile.getX()][tile.getY()] = mobileElementFactory.createMobileElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
			}
			else if(tile.getSprite() == 'L') {
				mapNiveau[tile.getX()][tile.getY()] = lorann = new Lorann(new Position(tile.getX(),tile.getY()));
			}
		}
	}
	
	public Element getElementInMap(int x, int y) {
		return this.mapNiveau[x][y];
	}	
	
	public Element[][] getMap(){
		return this.mapNiveau;
	}
	
	public char getElementByXY(int x, int y) {
		return this.mapNiveau[x][y].getSprite();
	}
	
	public Element getLorann() {
		return this.lorann;
	}
	
	
	//Partie Consacrée aux mouvements de Lorann : 
	
	
	
	public void LorannMoveUp() {
		this.lorann.moveUp(null);
	}
	
	public void LorannMoveDown() {
		this.lorann.moveDown(null);
	}
	
	public void LorannMoveLeft() {
		this.lorann.moveLeft(null);
	}
	
	public void LorannMoveRight() {
		this.lorann.moveRight(null);
	}
	
	public void LorannMoveUpLeft() {
		this.lorann.moveUpLeft(null);
	}
	
	public void LorannMoveUpRight() {
		this.lorann.moveUpRight(null);
	}
	
	public void LorannMoveDownLeft() {
		this.lorann.moveDownLeft(null);
	}
	
	public void LorannMoveDownRight() {
		this.lorann.moveDownRight(null);
	}
}
