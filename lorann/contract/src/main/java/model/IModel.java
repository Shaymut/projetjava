package model;

import java.sql.SQLException;
import java.util.List;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {
	
    /**
     * Gets the all tiles by IDMap.
     * @param id
     *            the id
     * @return the all tiles by IDMap
     * @throws SQLException
     *             the SQL exception
     */    
	List<Tile> getAllTilesByMap(final int id) throws SQLException;
	
	
	void CreateMap(List<Tile> listTiles) throws SQLException;
	
	
	Element[][] getMap();
	
	void setMap(Element[][] map);
	
	char getElementByXY(int x, int y);
	
	Element getLorann();
	Element getEvilRandom();
	Element getEvilHorizontal();
	Element getEvilVertical();
	Element getEvilPingPong();
	Element getSpell();
}
