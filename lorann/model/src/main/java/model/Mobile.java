package model;

public class Mobile extends Element implements IMobile{

    private int nextY;
    private int nextX;

    Mobile(Permeability permeability, char sprite, Position position) {
        super(permeability, sprite, position);
    }

    public int getNextY() {
		return nextY;
	}

	public void setNextY(int nextY) {
		this.nextY = nextY;
	}

	public int getNextX() {
		return nextX;
	}

	public void setNextX(int nextX) {
		this.nextX = nextX;
	}
	
	@Override
    public void moveUp() {
    	  setNextY(position.getY()-1); //On Sauvegarde l'ancienne position dans une variable temporaire afin de sauvegardé et ensuite 
          //Mettre les méthodes de collision
          position.setY(nextY);
    }

	@Override
    public void moveDown() {
    	setNextY(position.getY()+1);
    	position.setY(nextY);
        }
	
	@Override
    public void moveLeft() {
    	setNextX(position.getX()-1);
    	position.setX(nextX);
    }
	
	@Override
    public void moveRight() {
    	setNextX(position.getX()+1);
    	position.setX(nextX);
    }
	
	@Override
    public void moveUpLeft() {
    	setNextY(position.getY()-1);
    	setNextX(position.getX()-1);
    	position.setX(nextX);
        position.setY(nextY);
    }
	
	@Override
    public void moveUpRight() {
    	setNextY(position.getY()-1); 
        setNextX(position.getX()+1);
     	position.setX(nextX);
     	position.setY(nextY);
    }
	
	@Override
    public void moveDownLeft() {
    	setNextY(position.getY()+1);
    	setNextX(position.getX()-1);
    	position.setX(nextX);
    	position.setY(nextY);
    }
	
	@Override
    public void moveDownRight() {
    	setNextY(position.getY()+1);
    	setNextX(position.getX()+1);
    	position.setX(nextX);
    	position.setY(nextY);
    	
    }






}