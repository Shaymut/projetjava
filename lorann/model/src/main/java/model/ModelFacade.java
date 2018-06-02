package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.MapDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {
	
	Map Niveau;
	
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }
    
    /*
     * (non-Javadoc)
     * @see model.IModel#getAllTilesByMap()
     */
	@Override
	public List<Tile> getAllTilesByMap(final int id) throws SQLException {
		return MapDAO.getAllTilesByMap(id);
	}

	@Override
	public void CreateMap(List<Tile> map) throws SQLException {
		this.Niveau = new Map();
		Niveau.CreateMap(map);
	}

	@Override
	public Element[][] getMap() {
		return Niveau.getMap();
	}

	@Override
	public char getElementByXY(int x, int y) {
		return Niveau.getElementByXY(x, y);
	}
	

}
