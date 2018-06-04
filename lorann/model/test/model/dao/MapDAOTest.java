package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllTilesByMap() {
	        try {
	            assertEquals(MapDAO.getAllTilesByMap(1).getClass(),ArrayList.class);
	        } catch (SQLException e) {
	            fail("Maybe credential mistake.");
	            e.printStackTrace();
	}
	}

}
