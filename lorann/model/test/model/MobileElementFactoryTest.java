package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileElementFactoryTest {
	
	private Spell spell;
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
		spell = new Spell(position);
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testCreateMobileElement() {
		int X;
		new Spell(position);
		X = spell.getX();
		assertEquals(10,X);
		Permeability permeability ; 
		permeability = spell.getPermeability();
		assertEquals(Permeability.COLLECTABLE, permeability);
		char sprite;
		sprite = spell.getSprite();
		assertEquals('P', sprite);
	}

}
