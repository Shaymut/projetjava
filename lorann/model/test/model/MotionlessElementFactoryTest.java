package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionlessElementFactoryTest {
	
	private Gold gold;
	private Position position;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		position = new Position(10,1);
		gold = new Gold(position);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateMotionlessElement() {
		int X;
		new Gold(position);
		X = gold.getX();
		assertEquals(10,X);
		Permeability permeability ; 
		permeability = gold.getPermeability();
		assertEquals(Permeability.COLLECTABLE, permeability);
		char sprite;
		sprite = gold.getSprite();
		assertEquals('G', sprite);
	}
	

}
