package model.dao;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.mysql.cj.jdbc.StatementImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class LorannBDDConnectorTest {

    private LorannBDDConnector connector;

    private static String user     = "Joueur";
    private static String password = "root";
    private static String url      = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";

    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        this.connector = new LorannBDDConnector();
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    /**
     * Test if the query is correctly executed.
     */
    @Test
    public void executeQuery() {
        try {
            ResultSet resultExpected = statement.executeQuery("SELECT Sprite FROM levels");
            ResultSet result = connector.executeQuery("SELECT Sprite FROM levels");
            result.last();
            resultExpected.last();
            assertEquals(resultExpected.getRow(),result.getRow());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Maybe credential mistake.");
        }
    }

    /**
     * Check that the call is not null (null if query fail)
     */
    @Test
    public void prepareCall() {
        try {
            assertNotNull(connector.prepareCall("CALL findAllTilesByIDMap(1)").executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if update fail, if so return 0
     */
    @Test
    public void executeUpdate() {
        assert(connector.executeUpdate("UPDATE levels SET Sprite = 'C' WHERE  Sprite = 'C'") != 0);
    }

    /**
     * Check that the good class is return
     */
    @Test
    public void getInstance() {
        assertEquals(connector.getInstance().getClass(),LorannBDDConnector.class);
    }

    /**
     * Check that the good class is return
     */
    @Test
    public void getConnection() {
        assertEquals(connector.getConnection().getClass(),ConnectionImpl.class);
    }
    /**
     * Check that connection is set correctly
     */
    @Test
    public void setConnection() {
        connector.setConnection(connection);
        assertEquals(connector.getConnection(),connection);
    }
    /**
     * Check that the good class is return
     */
    @Test
    public void getStatement() {
        assertEquals(connector.getStatement().getClass(),StatementImpl.class);
    }
    /**
     * Check that statement is set correctly
     */
    @Test
    public void setStatement() {
        connector.setStatement(statement);
        assertEquals(connector.getStatement(),statement);
    }
}