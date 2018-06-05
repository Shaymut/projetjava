package model;

import java.util.List;

public class Map {
	
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	static Element[][] mapNiveau = new Element[20][12];
	
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	MotionlessElementFactory motionlessElementFactory = new MotionlessElementFactory();
	
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	Lorann lorann;
	
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilRandom evilRandom;
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilHorizontal evilHorizontal;
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilVertical evilVertical;
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	EvilPingPong evilPingPong;
	/**
	 * 
	 * @see Map#CreateMap(List)
	 */
	Spell spell;
	

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
	
	public Element getElementInMap(int x, int y) {
		return Map.mapNiveau[x][y];
	}	
	
	public Element[][] getMap(){
		return Map.mapNiveau;
	}
	
	public void setMap(Element[][] map){
		Map.mapNiveau = map;
	}
	
	public char getElementByXY(int x, int y) {
		return Map.mapNiveau[x][y].getSprite();
	}
	
	public Element getLorann() {
		return this.lorann;
	}
	
	public EvilRandom getEvilRandom() {
		return this.evilRandom;
	}
	
	public EvilHorizontal getEvilHorizontal() {
		return this.evilHorizontal;
	}

	public EvilVertical getEvilVertical() {
		return evilVertical;
	}
	
	public EvilPingPong getEvilPingPong() {
		return evilPingPong;
	}

	public Spell getSpell() {
		return spell;
	}

}
