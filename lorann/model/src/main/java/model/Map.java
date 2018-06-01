package model;

import java.util.List;

public class Map {
	
	Element[][] mapNiveau = new Element[20][12];
	
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	
	public void CreateMap(List<Tile> ListTiles) {
		for (Tile tile : ListTiles) {
			//System.out.println(tile.getX() + "," + tile.getY());
			mapNiveau[tile.getX()][tile.getY()] = motionlessElementFactory.createMotionlessElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
		}
		AfficherMapNiveau(mapNiveau);
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
	
}
