package model;

public class Mobile extends Element implements IMobile{

	private boolean alive = true;
	
	private static Position X;
	
	private static Position Y;
	
	// private IBoard board;

	Mobile(Permeability permeability, char sprite, String image, Position position) {
		super(permeability, sprite, image, position);
		// TODO Auto-generated constructor stub
	}

	public static Position getX() {
		return X;
	}

	public void setX(Position x) {
		X = x;
	}
	
	public static Position getY() {
		return Y;
	}

	public void setY(Position y) {
		Y = y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
			
		}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}

	public void moveUpLeft() {
		
	}
	
	public void moveUpRight() {
		
	}
	
	public void moveDownLeft() {
		
	}
	
	public void moveDownRight() {
		
	}
	
	
	
	
	
	
}
