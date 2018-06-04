package model;

import java.util.List;

public class Map {
	
	static Element[][] mapNiveau = new Element[20][12];
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

}
