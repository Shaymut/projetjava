package model;

public class Lorann extends MobileElement{
	
	public long score;
	public  boolean HaveASpell;
	public boolean Recup;
	static char sprite = 'L';
	public boolean isAlive = false;
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
	

	public boolean PickUp() {
		
		//if(permeability == Permeability.COLLECTABLE) {
		//	setScore(getScore()+650);
		//Recup = true;
		//}else if(permeability != Permeability.COLLECTABLE) {
		//	Recup = false;
	//	}
		return Recup;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}	
	
}
	