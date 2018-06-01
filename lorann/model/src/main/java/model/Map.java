package model;

import java.util.List;

public class Map {
	
	Element[][] mapNiveau = new Element[20][12];
	
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	MobileElementFactory mobileElementFactory = new MobileElementFactory();
	
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
			else if (tile.getSprite() == 'L' ||
					 tile.getSprite() == 'P' ||
					 tile.getSprite() == 'F' ||
					 tile.getSprite() == 'K' ||
					 tile.getSprite() == 'B' ||
					 tile.getSprite() == 'J'){
				mapNiveau[tile.getX()][tile.getY()] = mobileElementFactory.createMobileElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
			}
		}
	}
	
	public Element getElementInMap(int x, int y) {
		return this.mapNiveau[x][y];
	}
	
	public void AfficherMapNiveau(Element[][] mapNiveau) {
		for (int i = 0; i <= 11; i++) {
			for (int j = 0; j <= 19; j++) {
				System.out.print(mapNiveau[j][i].getSprite());
			}
			System.out.println();
		}
	}
	
	
	public Element[][] getMap(){
		return this.mapNiveau;
	}
	
	public char getElementByXY(int x, int y) {
		return this.mapNiveau[x][y].getSprite();
	}
}
