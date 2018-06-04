package model;

import java.util.List;

public class Map {
	
	static Element[][] mapNiveau = new Element[20][12];
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	MobileElementFactory mobileElementFactory = new MobileElementFactory();
	Lorann lorann;
	Lorann lor;
	
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
				mapNiveau[tile.getX()][tile.getY()] = lorann = new Lorann(new Position(tile.getX(),tile.getY()), this);
			}
		}
	}
	
	public Element getElementInMap(int x, int y) {
		return Map.mapNiveau[x][y];
	}	
	
	public Element[][] getMap(){
		return Map.mapNiveau;
	}
	
	public void setMap(Element[][] map){
		Map.mapNiveau = map;
	}
	
	public char getElementByXY(int x, int y) {
		return Map.mapNiveau[x][y].getSprite();
	}
	
	public Element getLorann() {
		return this.lorann;
	}
	
	public Lorann getlorann() {
		return this.lor;
	}
	
	
	//Partie Consacr�e aux mouvements de Lorann : 
	
	
	
	public void LorannMoveUp() {
		this.lorann.moveUp();
	}
	
	public void LorannMoveDown() {
		this.lorann.moveDown();
	}
	
	public void LorannMoveLeft() {
		this.lorann.moveLeft();
	}
	
	public void LorannMoveRight() {
		this.lorann.moveRight();
	}
	
	public void LorannMoveUpLeft() {
		this.lorann.moveUpLeft();
	}
	
	public void LorannMoveUpRight() {
		this.lorann.moveUpRight();
	}
	
	public void LorannMoveDownLeft() {
		this.lorann.moveDownLeft();
	}
	
	public void LorannMoveDownRight() {
		this.lorann.moveDownRight();
	}
}
