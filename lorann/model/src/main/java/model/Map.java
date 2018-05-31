package model;

import java.util.List;
public class Map {
	
	Element[][] map;
	
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	
	public void CreateMap(List<Tile> ListTiles) {
		for (Tile tile : ListTiles) {
			motionlessElementFactory.createMotionlessElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
			
		}
		
		
		/*
		 * for (final Tile tile : ListTiles) {
            message.append(tile);
            message.append('\n');
        }
		 */
	}
	
	
}
