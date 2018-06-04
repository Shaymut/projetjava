package model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class AbstractDAOTest {

    private static String user     = "Joueur";
    private static String password = "root";
    private static String url      = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";

    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    /**
     * Test if the query is correctly executed.
     */
    @Test
    public void executeQuery() {
        try {
            ResultSet resultExpected = AbstractDAO.executeQuery("SELECT Sprite FROM levels");
            ResultSet result = statement.executeQuery("SELECT Sprite FROM levels");
            result.last();
            resultExpected.last();
            assertEquals(resultExpected.getRow(),result.getRow());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Maybe credential mistake.");
        }
    }

    /**
     * Check if update fail, if so return 0
     */
    @Test
    public void executeUpdate() {
        assert(AbstractDAO.executeUpdate("UPDATE levels SET Sprite = 'C' WHERE  Sprite = 'C'") != 0);
    }

    /**
     * Check that the call is not null (null if query fail)
     */
    @Test
    public void prepareCall() {
        try {
            assertNotNull(AbstractDAO.prepareCall("CALL getLevelByID(1)").executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}