package model;

public class Lorann extends MobileElement{
	
	public  boolean HaveASpell;
	static char sprite = 'L';
	static Permeability permeability = Permeability.BLOCK;
	Position positionL;
	Map mapNiveau;

	Lorann(Position position, Map map) {
		super(permeability, sprite, position);
		this.mapNiveau = map;
	}
	
	public boolean HaveASpell() {
		return true;
	}
	
}
	