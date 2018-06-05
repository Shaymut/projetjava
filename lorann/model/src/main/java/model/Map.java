package model;

import java.util.List;

public class Map {
	
	/**
	 * Creation of the map
	 * 
	 * @see Map#CreateMap(List)
	 */
	static Element[][] mapNiveau = new Element[20][12];
	
	/**
	 * Creation of motionless elements
	 * 
	 * @see Map#CreateMap(List)
	 */
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	
	/**
	 * 
	 * Creation of lorann
	 * 
	 * @see Map#CreateMap(List)
	 */
	Lorann lorann;
	
	/**
	 * Creation of evilRandom
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilRandom evilRandom;
	/**
	 * Creation of evilHorizontal
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilHorizontal evilHorizontal;
	/**
	 * Creation of evilVertical
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilVertical evilVertical;
	/**
	 * Creation of evilPingPong
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilPingPong evilPingPong;
	/**
	 * Creation of spell
	 * 
	 * @see Map#CreateMap(List)
	 */
	Spell spell;
	
	/**
	 * Creation of the map with images
	 * 
	 * @param ListTiles
	 */
	
	public void CreateMap(List<Tile> ListTiles) {
		for (Tile tile : ListTiles) {
			if (tile.getSprite() == 'S'||
				tile.getSprite() == 'H' || 
				tile.getSprite() == 'V' ||
				tile.getSprite() == 'X' || 
				tile.getSprite() == 'G' ||
				tile.getSprite() == 'E' || 
				tile.getSprite() == 'C' || 
				tile.getSprite() == 'O') {
				mapNiveau[tile.getX()][tile.getY()] = motionlessElementFactory.createMotionlessElement(tile.getSprite(), new Position(tile.getX(),tile.getY()));
			}
			else if(tile.getSprite() == 'L') {
				mapNiveau[tile.getX()][tile.getY()] = lorann = new Lorann(new Position(tile.getX(),tile.getY()));
			}
			else if(tile.getSprite() == 'B') {
				mapNiveau[tile.getX()][tile.getY()] = evilRandom = new EvilRandom(new Position(tile.getX(),tile.getY()));
			}
			else if(tile.getSprite() == 'F') {
				mapNiveau[tile.getX()][tile.getY()] = evilHorizontal = new EvilHorizontal(new Position(tile.getX(),tile.getY()));
			}
			else if(tile.getSprite() == 'K' ) {
				mapNiveau[tile.getX()][tile.getY()] = evilVertical = new EvilVertical(new Position(tile.getX(),tile.getY()));
			}
			else if (tile.getSprite() == 'J') {
				mapNiveau[tile.getX()][tile.getY()] = evilPingPong = new EvilPingPong(new Position(tile.getX(),tile.getY()));
			}
		}
	}
	
	/**
	 * 
	 * Get an element with X and Y
	 * 
	 * @param {@link Position#getX()}
	 * @param {@link Position#getY()}
	 * @return an element
	 */
	
	public Element getElementInMap(int x, int y) {
		return Map.mapNiveau[x][y];
	}	
	
	/**
	 * 
	 * Get a map
	 * 
	 * @return a map
	 */
	
	public Element[][] getMap(){
		return Map.mapNiveau;
	}
	
	/**
	 * Set a map
	 * 
	 * @param map
	 */
	
	public void setMap(Element[][] map){
		Map.mapNiveau = map;
	}
	
	/**
	 * 
	 * Get the sprite of an element in the map
	 * 
	 * @param {@link Position#getX()}
	 * @param {@link Position#getY()}
	 * @return the sprite of an element
	 */
	
	public char getElementByXY(int x, int y) {
		return Map.mapNiveau[x][y].getSprite();
	}
	
	/**
	 * Get lorann
	 * 
	 * @return lorann
	 */
	
	public Element getLorann() {
		return this.lorann;
	}
	
	/**
	 * Get evilRandom
	 * 
	 * @return evilRandom
	 */
	
	public EvilRandom getEvilRandom() {
		return this.evilRandom;
	}
	
	/**
	 * Get evilHorizontal
	 * 
	 * @return evilHorizontal
	 */
	
	public EvilHorizontal getEvilHorizontal() {
		return this.evilHorizontal;
	}

	/**
	 * Get evilVertical
	 * 
	 * @return evilVertical
	 */
	
	public EvilVertical getEvilVertical() {
		return evilVertical;
	}
	
	/**
	 * Get evilPingPong
	 * 
	 * @return evilPingPong
	 */
	
	public EvilPingPong getEvilPingPong() {
		return evilPingPong;
	}

	/**
	 * Get spell
	 * 
	 * @return spell
	 */
	
	public Spell getSpell() {
		return spell;
	}

}
