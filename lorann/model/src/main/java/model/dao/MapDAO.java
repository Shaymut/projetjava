package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tile;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class MapDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlAllTilesByIDMap   = "{call findAllTilesByIDMap(?)}";

    /** The id column index. */
    private static int    idColumnIndex    = 1;

    /** The sprite column index. */
    private static int    SpriteColumnIndex  = 2;
    
    /** The x column index. */
    private static int XColumnIndex  = 3;
    
    /** The y column index. */
    private static int YColumnIndex  = 4;
    
    /** The IDMap column index. */
    private static int IDMapColumnIndex  = 5;
    /**
     * Gets the all examples.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public static List<Tile> getAllTilesByMap(final int IDMap) throws SQLException {
        final ArrayList<Tile> ListTiles = new ArrayList<Tile>();
        final CallableStatement callStatement = prepareCall(sqlAllTilesByIDMap);
        callStatement.setInt(1, IDMap);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                ListTiles.add(new Tile(result.getInt(idColumnIndex), result.getString(SpriteColumnIndex).charAt(0), result.getInt(XColumnIndex), result.getInt(YColumnIndex), result.getInt(IDMapColumnIndex)));
            }
            result.close();
        }
        return ListTiles;
    }
}
