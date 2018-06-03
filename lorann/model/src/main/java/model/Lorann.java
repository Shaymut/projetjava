package model;

public class Lorann extends MobileElement{
	
	public long score;
	public  boolean HaveASpell;
	public boolean Recup;
	static char sprite = 'L';
	public boolean isAlive = false;
	static Permeability permeability = Permeability.BLOCK;


	

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	Lorann(Position position) {
		super(permeability, sprite, position);
		
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

	@Override
    public void moveUp(Position position) {
    	  setNextY(position.getY()-1);
          position.setY(nextY);

          
    }

	@Override
    public void moveDown(Position position) {
    	setNextY(position.getY()+1);
    	position.setY(nextY);
   
    	
        }
	
	@Override
    public void moveLeft(Position position) {
    	setNextX(position.getX()-1);
    	position.setX(nextX);
    
    }
	
	@Override
    public void moveRight(Position position) {
    	setNextX(position.getX()+1);
    	position.setX(nextX);
    }
	
	@Override
    public void moveUpLeft(Position position) {
    	setNextY(position.getY()-1);
    	setNextX(position.getX()-1);
    	position.setX(nextX);
        position.setY(nextY);
    }
	
}
