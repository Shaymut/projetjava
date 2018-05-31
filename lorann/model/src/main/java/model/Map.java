package model;

import java.util.ArrayList;

public class Map {
	
	Element[][] map;
	
	MotionlessElementFactory motionlessElementFactory;
	
	public void CreateMap(ArrayList<Tile> ListTiles) {
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
